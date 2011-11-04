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
</style>
</head>
<body>
<mytable> <bank> Banque : <hand> <g:each
	in="${table.bank}">
	<img
		src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />"	alt="${it.name}" />
</g:each> </hand> </bank> <player> Votre main : <hand> <g:each
	in="${table.player}">
	<img
		src="<g:resource dir='images/cards/default' file='${it.name}.svg' } />"	alt="${it.name}" />
</g:each></hand>
<controls>

<a href="<g:createLink action='card' id='${table.id}'/>">Carte</a>
</controls>
</player> </mytable>
</body></html>