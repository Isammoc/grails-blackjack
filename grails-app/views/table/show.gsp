<g:applyLayout name="main">
<html>
	<head>
		<style type="text/css" media="screen">
bank,player,hand {
	display: block;
}
		</style>
	</head>
	<body>
		<bank>
			Banque : 
			<g:if test="${table.bank.size() > 1}">
				${bankScore}
			</g:if>
			<hand>
				<g:each status="i" var="card" in="${table.bank}">
					<img class="card" src="${resource(dir:'images/cards/default',file:"$card.name"+'.svg')}" alt="${card.name}" style="left:${2.2*i}em" />
				</g:each>
				<g:if test="${ bankScore == 'Blackjack' }">
					<div class="blackjack">
						<img src="${resource(dir:'images/cards/default',file:'blackjack.svg')}" alt="BlackJack"/>
						<span>Blackjack !</span>
					</div>
				</g:if>
				<g:if test="${ bankBurn }">
					<div class="burn">
						<img src="${resource(dir:'images/cards/default',file:'burnt.svg')}" alt="burn" />
					</div>
				</g:if>
			</hand>
		</bank>
		<div class="winner">
			<g:if test="${ winner == 'draw'}">
				<h2>Egalit&eacute;</h3>
			</g:if>
			<g:elseif test="${ winner == 'bank' }">
				<h2>Perdu</h3>
			</g:elseif>
			<g:elseif test="${ winner == 'player' }">
				<h2>Gagné</h3>
			</g:elseif>
		</div>
		<player>
			Votre main : ${score}
			<hand>
				<g:each status="i" var="card" in="${table.player}">
					<img class="card" src="${resource(dir:'images/cards/default',file:"$card.name"+'.svg')}" alt="${card.name}" style="left:${2.2*i}em"/>
				</g:each>
				<g:if test="${ score == 'Blackjack' }">
					<div class="blackjack">
						<img src="${resource(dir:'images/cards/default',file:'blackjack.svg')}" alt="BlackJack"/>
						<span>Blackjack !</span>
					</div>
				</g:if>
				<g:if test="${ playerBurn }">
					<div class="burn">
						<img src="${resource(dir:'images/cards/default',file:'burnt.svg')}" alt="burn" />
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