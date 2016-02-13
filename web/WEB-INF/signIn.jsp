<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 1/29/16
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../contentType.jsp" />
<html>
    <jsp:include page="../head.jsp" />
<body>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username"></TD></TR>
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password"></TD></TR>
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In"></TH></TR>
    </TABLE>
</FORM>
</body>
<jsp:include page="../footer.jsp" />
</html>
