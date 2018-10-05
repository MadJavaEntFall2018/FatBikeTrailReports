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

  <!-- used for the sorting/paging on the table -->
  <script type="text/javascript" class="init">
      $(document).ready( function () {
          $('#trailReportsTable').DataTable();
      } );
  </script>

  <body role="document">
  <jsp:include page="navbar.jsp" />
  <div class="container theme-showcase" role="main">
    <div class="page-header">
      <h1>Reports</h1>
    </div>

      <div class="container-fluid">
        <h2>Trail Reports </h2>
        <table id="trailReportsTable" class="display" cellspacing="0" width="100%">
          <thead>
          <th>Trail</th>
          <th>Posted On</th>
          <th>Reported By</th>
          <th>Ride Date</th>
          <th>Grooming</th>
          <th>Conditions</th>
          <th>Comments</th>

          </thead>
          <tbody>
          <c:forEach var="report" items="${trailReports}">
            <tr>
              <td>${report.trail.name} </td>
              <td>${report.createDate}</td>
              <td>${report.user.firstName} &nbsp; ${report.user.lastName}</td>
              <td>${report.rideDate}</td>
              <td>${report.grooming.name}</td>
              <td>${report.conditions}</td>
              <td>${report.comments}</td>
            </tr>


          </c:forEach>
          </tbody>
        </table>
      </div>



  </c:forEach>


  </div>


</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>
