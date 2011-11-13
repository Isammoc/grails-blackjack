<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails Casino" /></title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="${resource(dir:'css',file:'casino.css')}" rel="stylesheet" type="text/css" media="screen" />
		<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <g:layoutHead />
    </head>
    <body>
		<header>
			<div id="logo">
				<a href="${createLink(uri:'/') }">Grails Casino</a>
			</div>
			<nav>
				<nav:render /><%--
				<ul>
					<li class="active"><a href="#">Accueil</a></li>
				</ul>
			--%></nav>
		</header>
		<div id="page">
			<section id="left">
	   			<g:render template="/user/sidebar"/>
			</section>
			<section id="content">
				<g:if test="${flash.message}">
					<div class="flash">${flash.message}</div>
				</g:if>
				<div id="table">
	       			<g:layoutBody />
	       			<div style="clear: both;">&nbsp;</div>
	       		</div>
	       	</section>
		    <section id="right">
		    </section>
		</div>
       	<footer>
			<p>Copyright (c) 2011 Isammoc.</p>
		</footer>
    </body>
</html>