package net.isammoc.gbj

class CardService {

	static transactional = true

	static scoreForRank = [
		'A':1,
		'K':10,
		'Q':10,
		'J':10,
		'9':9,
		'8':8,
		'7':7,
		'6':6,
		'5':5,
		'4':4,
		'3':3,
		'2':2
	]

	Card random() {
		Card.findAll()[new Random().nextInt(Card.count())]
	}

	String scoreToDisplay(List<Card> cards) {
		int score = 0;
		boolean aces = false;
		cards.each { card ->
			score += scoreForRank[card.rank]
			if(card.rank == 'A'){
				aces = true;
			}
		}

		String result;

		if (aces && score == 11 && cards.size() == 2) {
			result = "Blackjack"
		} else if(aces && (score + 10) <= 21) {
			result = "$score / ${score + 10}"
		} else {
			result = "$score"
		}

		return result
	}

	int score(List<Card> cards) {
		int score = 0;
		boolean aces = false;
		cards.each { card ->
			score += scoreForRank[card.rank]
			if(card.rank == 'A'){
				aces = true;
			}
		}

		if(aces && (score + 10) <= 21) {
			score += 10
		}
		return score
	}


	boolean canCard(Table table) {
		if(table.bank.size() >= 2) {
			return false
		}
		def currentScore = scoreToDisplay(table.player)

		def pattern = ~/\d+/
		if( pattern.matcher(currentScore).matches() && Integer.parseInt(currentScore) <21 ) {
			return true
		}
		if (currentScore ==~ /\d+ \/ \d+/ ) {
			return true
		}
		return false
	}

	void playBank(Table table){
		while(score(table.bank) < 17) {
			table.addToBank(random())
		}
		table.save()
	}

	String whoWin(Table table) {
		if( table.bank.size() < 2 ) {
			return null
		}

		if( table.abandon ) {
			return 'abandon'
		}
		
		def winner
		def player = score(table.player)
		def bank =  score(table.bank)

		def playerBJ = player == 21 && table.player.size() == 2
		def bankBJ = bank == 21 && table.bank.size() == 2
		def playerBurn = player > 21
		def bankBurn = bank > 21

		if( !playerBurn && (bankBurn || (playerBJ && !bankBJ) || player > bank) ) {
			winner = "player"
			if(playerBJ){
				table.user.account += 2.5 * table.bet
			}else{
				table.user.account += 2 * table.bet
			}
			table.bet = 0
		} else if (playerBurn || (bankBJ && !playerBJ) || bank > player) {
			winner = "bank"
			table.bet = 0
		} else {
			winner = "draw"
			table.user.account += table.bet
			table.bet = 0
		}
		table.save()
		return winner
	}
}
