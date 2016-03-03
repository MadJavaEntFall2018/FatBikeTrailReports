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

<form action="/signUpUser" method="post">
    First name: <input type="text" name="firstName"><br>
    Last name: <input type="text" name="lastName"><br>
    Email address: <input type="text" name="emailAddress"><br>
    Password: <input type="password" name="password"><br>
    Confirm Password: <input type="password" name="password"><br>

    <input type="submit" value="Submit"><input type="reset" value="Clear">
</form>
</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>

</form>