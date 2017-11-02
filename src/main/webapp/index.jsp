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
    <div class="page-header">
      <h1>Reports</h1>
    </div>

    <c:forEach items="${trailReports}" var="report">
    <div class="col-sm-7">
      <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">${report.trail.name} - Posted
            ${report.createDate} </h3>
          </div>
          <div class="panel-body">
            Reported by: ${report.user.firstName} &nbsp;
             ${report.user.lastName}<br />
            Ridden on: ${report.rideDate}<br />
            Grooming Type: ${report.grooming.name}<br />
            Conditions: ${report.conditions}<br />
            Comments: ${report.comments}
          </div>
      </div>
    </div>

  </c:forEach>


  </div>


</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>
