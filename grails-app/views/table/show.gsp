<g:applyLayout name="main">
<html>
	<head>
		<style type="text/css" media="screen">
bank,player,hand {
	display: block;
}

.winner {
background-color: green;
}
		</style>
	</head>
	<body>
		<bank class="${winner == 'bank' ? 'winner':''}">
			Banque : 
			<g:if test="${table.bank.size() > 1}">
				${bankScore}
			</g:if>
			<hand>
				<g:each status="i" var="card" in="${table.bank}">
					<img class="card" src="${resource(dir:'images/cards/default',file:"$card.name"+'.svg')}" alt="${card.name}" style="left:-${7.8*i}em" />
				</g:each>
				<g:if test="${ bankScore == 'Blackjack' }">
					<div class="blackjack">
						<img src="${resource(dir:'images/cards/default',file:'blackjack.svg')}" alt="BlackJack"/>
						<span>Blackjack !</span>
					</div>
				</g:if>
			</hand>
		</bank>
		<g:if test="${winner == 'draw'}">
			<div class="winner">
				<h3>Egalit&eacute;</h3>
			</div>
		</g:if>
		<player class="${winner == 'player' ? 'winner':''}">
			Votre main : ${score}
			<hand>
				<g:each status="i" var="card" in="${table.player}">
					<img class="card" src="${resource(dir:'images/cards/default',file:"$card.name"+'.svg')}" alt="${card.name}" style="left:-${7.8*i}em"/>
				</g:each>
				<g:if test="${ score == 'Blackjack' }">
					<div class="blackjack">
						<img src="${resource(dir:'images/cards/default',file:'blackjack.svg')}" alt="BlackJack"/>
						<span>Blackjack !</span>
					</div>
				</g:if>
			</hand>
		</player>
		<controls>
			<g:if test="${canCard}">
				<a href="${createLink(action:'card',id:"$table.id")}">Carte</a><br />
				<a href="${createLink(action:'stop',id:"$table.id")}">Stop</a><br />
			</g:if>
			<g:if test="${winner}">
				<a href="${createLink(action:'renew',id:"$table.id")}">Rejouer</a>
			</g:if>
		</controls>
	</body>
</html>
</g:applyLayout>