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
        </dl>
        <sec:ifLoggedIn><g:link controller="logout" action="index">Se d&eacute;connecter</g:link></sec:ifLoggedIn>
    </sec:ifLoggedIn>

    <sec:ifNotLoggedIn>
       <h3>Connexion</h3>
        <div id="loginForm">
            <form id="loginForm" method="POST" action="${request.contextPath + config.apf.filterProcessesUrl}">
                <table>
                  <tr>
                    <td>Login :</td><td><g:textField id="j_username" name="j_username"/></td>
                  </tr>
                  <tr>
                    <td>Mot de passe :</td><td><input name="j_password" type="password"/></td>
                  </tr>
                  <tr>
				    <td>Se souvenir de moi la prochaine fois :</td><td><input type='checkbox' name='${config.rememberMe.parameter}'<g:if test='${hasCookie}'> checked='checked'</g:if>/></td>
                  </tr>
                  <tr>
                    <td colspan="2"><g:submitButton name="login" value="Login"/></td>
                  </tr>
                  <tr>
				    <td colspan="2"><a href="${createLink(controller:'user',action:'register')}">S'enregistrer</a></td>
                  </tr>
                </table>
				
            </form>
        </div>
    </sec:ifNotLoggedIn>
</div>
