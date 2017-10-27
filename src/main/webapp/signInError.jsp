<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 1/29/16
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html>
    <jsp:include page="head.jsp" />
    <body role="document">
    <jsp:include page="navbar.jsp" />
    <div class="container theme-showcase" role="main">

        <div class="alert alert-danger" role="alert">
            <strong>Login Failed</strong> That userid/password combination
            does not exist.
        </div>
        <a href="addTrail.jsp"><button type="button" class="btn btn-primary">
            Retry</button></a>
        <a href="/viewTrail"><button type="button" class="btn btn-default">Cancel
        </button></a>

    </div>
    </body>
    <jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>
