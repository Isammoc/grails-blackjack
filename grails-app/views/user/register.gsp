<html>
    <head>
        <title>Register New User</title>
        <style>
            dd {
                text-align: left;
                margin-left: 80px;
                margin-top: 5px;
            }
        </style>
    </head>
    <body>

      <g:if test="${flash.message}">
        <div class="flash">${flash.message}</div>
      </g:if>
      
        <h1>Register New User</h1>

        <g:hasErrors bean="${userDetails}">
            <div class="errors">
               <g:renderErrors bean="${userDetails}" as="list" />
            </div>
        </g:hasErrors>

        <g:form action="register">
            <dl>
                <dt>Login</dt>
                <dd><g:textField name="username" value="${userDetails?.username}"/></dd>
                <dt>Password</dt>
                <dd><g:passwordField name="password"/></dd>
                <dt>V&eacute;rification</dt>
                <dd><g:passwordField name="passwordRepeat" /></dd>
                <dt><g:submitButton name="register" value="Register"/></dt>
            </dl>

        </g:form>
    </body>
</html>
