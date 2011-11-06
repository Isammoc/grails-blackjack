<html>
    <head>
        <title>Blackjack - Accueil</title>
    </head>
    <body>
	    <g:render template="/user/sidebar"/>
	    <h3>Jeux en cours</h3>
	    <table>
	    	<g:each var="table" in="${net.isammoc.gbj.Table.findAll()}">
	    		<tr>
	    			<td><a href="${createLink(controller:'table',action:'show',id:"$table.id")}">${table.id}</a></td>
	    		</tr>
	    	</g:each>
	    </table>
	</body>
</html>
