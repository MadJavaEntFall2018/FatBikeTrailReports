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
        <h1>Trails</h1>
    </div>
<c:forEach items="${trails}" var="trail">
        <div class="col-sm-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${trail.name}</h3>
                </div>
                <div class="panel-body">
                    ${trail.description}<br />
                    ${trail.length} ${trail.lengthUnits}<br /><br />
                    ${trail.type.name}<br />
                    ${trail.difficulty.name}<br />
                    ${trail.trailMap}<br />
                    ${trail.website}<br />
                    ${trail.location.address1}<br />
                    ${trail.location.city}, ${trail.location.state} ${trail.location.postalcode}<br />
                    ${trail.location.lat}, ${trail.location.lon}
                </div>
            </div>
        </div>
</c:forEach>

</div>

</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>
