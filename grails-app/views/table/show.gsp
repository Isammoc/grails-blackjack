<html>
	<head>
		<style type="text/css" media="screen">
bank,player {
	display: block;
	margin: 3em;
}

hand {
	display: block;
}

mytable {
	display: block;
  margin-left: 15%;
  margin-right: 15%
}

.flash {
background-color: red;
}

.winner {
background-color: green;
}
		</style>
	</head>
	<body>
	<g:render template="/user/sidebar"/>
		<g:if test="${flash.message}">
			<div class="flash">${flash.message}</div>
		</g:if>
		<mytable>
			<bank class="${winner == 'bank' ? 'winner':''}">
				Banque : 
				<g:if test="${table.bank.size() > 1}">
					${bankScore}
				</g:if>
				<hand>
					<g:each in="${table.bank}">
						<img src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />" alt="${it.name}" />
					</g:each>
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
					<g:each in="${table.player}">
						<img src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />" alt="${it.name}" />
					</g:each>
				</hand>
			</player>
			<controls>
				<g:if test="${canCard}">
					<a href="<g:createLink action='card' id='${table.id}'/>">Carte</a><br />
					<a href="<g:createLink action='stop' id='${table.id}'/>">Stop</a><br />
				</g:if>
				<g:if test="${winner}">
					<a href="<g:createLink action='renew' id='${table.id}'/>">Rejouer</a>
				</g:if>
			</controls>
 		</mytable>
	</body>
</html>