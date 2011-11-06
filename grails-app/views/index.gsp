<g:applyLayout name="main">
<html>
    <head>
        <title>Blackjack - Accueil</title>
    </head>
    <body>
	    <h3>Jeux en cours</h3>
	    <table>
    		<tr>
    			<th>N°</th>
    			<th>Joueurs</th>
    			<th></th>
    		</tr>
	    	<g:each var="table" in="${net.isammoc.gbj.Table.findAll()}">
	    		<tr>
	    			<td><a href="${createLink(controller:'table',action:'show',id:"$table.id")}">${table.id}</a></td>
	    			<td>${table.user.username} (${table.user.account})</td>
	    			<td><a href="${createLink(controller:'table',action:'show',id:"$table.id")}">Voir</a></td>
	    		</tr>
	    	</g:each>
	    </table>
	    <a href="${createLink(controller:'table',action:'create')}">Cr&eacute;er une nouvelle table</a>
	</body>
</html>
</g:applyLayout>