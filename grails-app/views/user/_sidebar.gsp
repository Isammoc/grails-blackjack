<%@page import="org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils" %>
<g:set var="config" value="${SpringSecurityUtils.securityConfig}"/>
<div id="sidebar">
    <sec:ifLoggedIn>
        <h3>Connect&eacute;(e)</h3>
        <dl>
            <dt>Utilisateur</dt>
            <dd>
              <sec:username>Guest</sec:username>
            </dd>
            <dt>Jetons</dt>
            <dd>${currentUser.account }</dd>
            <g:if test="${table }">
            <dt>Mise</dt>
            <dd>${ table.bet}</dd>
            </g:if>
        </dl>
        <sec:ifLoggedIn><g:link controller="logout" action="index">Se d&eacute;connecter</g:link></sec:ifLoggedIn>
    </sec:ifLoggedIn>

    <sec:ifNotLoggedIn>
       <h3>Connexion</h3>
        <div id="loginForm">
            <form id="loginForm" method="POST" action="${request.contextPath + config.apf.filterProcessesUrl}">
                <dl>
                  <dt>Login :</dt>
                  <dd><g:textField id="j_username" name="j_username" /></dd>
                  <dt>Mot de passe :</dt>
                  <dd><input name="j_password" type="password"/></dd>
				  <dt>Rester connecté(e) :</dt>
				  <dd><input type='checkbox' name='${config.rememberMe.parameter}'<g:if test='${hasCookie}'> checked='checked'</g:if>/></dd>
                </dl>
				<g:submitButton name="login" value="Login"/>
				<a href="${createLink(controller:'user',action:'register')}">S'inscrire</a>
            </form>
        </div>
    </sec:ifNotLoggedIn>
</div>
