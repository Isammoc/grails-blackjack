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
		
		if (aces && score == 11 && cards.size == 2) {
			result = "Blackjack"
		} else if(aces && (score + 10) <= 21) {
			result = "$score / ${score + 10}"
		} else {
			result = "$score";
		} 
		
		return result;
	}
}