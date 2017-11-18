<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <c:choose>
        <c:when test = "${errorMessage == null}">
            <div class="alert alert-success" role="alert">
                <strong>New User Registration -- Success</strong> Time to add a new trail or report!
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger" role="alert">
                <strong>New User Registration -- Failed</strong>$<br />
                {errorMessage}<br /><br />
                <a href="signUp.jsp"><button type="button" class="btn btn-primary">
                    Retry</button></a>
                <a href="viewTrails"><button type="button" class="btn btn-default">Cancel

            </div>
        </c:otherwise>
        </c:choose>



    </div>
</body>
<jsp:include page="footer.jsp" />
</html>
