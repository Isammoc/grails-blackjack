<html>
<body>
<g:each in="${cards}">
	<img src="<g:resource dir='images/cards/default' file='${it.name}.svg' }/>"	alt="hubbub logo" />
</g:each>
</body>
</html>