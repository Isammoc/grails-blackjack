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
</style>
</head>
<body>
<g:if test="${flash.message}">
<div class="flash">${flash.message}</div>
</g:if>
<mytable> <bank> Banque : <hand> <g:each
	in="${table.bank}">
	<img
		src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />"	alt="${it.name}" />
</g:each> </hand> </bank> <player> Votre main : ${score}<hand> <g:each
	in="${table.player}">
	<img
		src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />"	alt="${it.name}" />
</g:each></hand>
<controls>
<g:if test="${canCard}">
<a href="<g:createLink action='card' id='${table.id}'/>">Carte</a></g:if>
<g:else>
Vous ne pouvez plus tirer de carte
</g:else>

</controls>
</player> </mytable>
</body></html>