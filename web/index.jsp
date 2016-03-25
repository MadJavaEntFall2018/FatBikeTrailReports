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
  <table>
  <c:forEach items="${trailReports}" var="report">
    <tr><th>${report.trail.name} - Posted ${report.createDate}</th></tr>
    <tr><td>User: ${report.user}</td><td>Ridden on:
     ${report.dateRidden}</td></tr>
    <tr><td>Grooming Type: ${report.type.grooming}</td></tr>
    <tr><td>Conditions: ${report.conditions}></td></tr>
    <tr><td>Comments: ${report.comments}></td></tr>


  </c:forEach>
  </table>




</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>
