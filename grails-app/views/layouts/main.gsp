<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails Casino" /></title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="${resource(dir:'css',file:'style.css')}" rel="stylesheet" type="text/css" media="screen" />
		<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
    </head>
    <body>
    <div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1><a href="${createLink(uri:'/') }">Grails Casino</a></h1>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#">Accueil</a></li>
		<!-- 
				<li><a href="#">Blog</a></li>
				<li><a href="#">Photos</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Links</a></li>
				<li><a href="#">Contact</a></li>
		-->
			</ul>
		</div>
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<g:if test="${flash.message}">
						<div class="flash">${flash.message}</div>
					</g:if>
					<div id="content">
	        			<g:layoutBody />
	        			<div style="clear: both;">&nbsp;</div>
	        		</div>
	    			<g:render template="/user/sidebar"/>
	        		<div style="clear: both;">&nbsp;</div>
	        	</div>
	        </div>
	    </div>
	</div>
       	<div id="footer">
			<p>Copyright (c) 2011 Isammoc. Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
		</div>
    </body>
</html>