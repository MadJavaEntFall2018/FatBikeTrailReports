<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 1/29/16
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/contentType.jsp" />
<html>
    <jsp:include page="/head.jsp" />
    <jsp:include page="js.jsp" />
    <body role="document">
    <jsp:include page="/navbar.jsp" />

    <div class = "container">
        <form id="addTrailForm" role="form" data-toggle="validator"
              class="form-horizontal"
              action="addReport"
              method="post">

            <div class="form-group">
                <label class="control-label col-sm-2" for="trail">Trail
                </label>
                <div class="col-sm-4">
                    <select class="form-control" id="trail"
                            name="trail"
                            data-error="Please select trail name." required>
                        <c:forEach var="trail" items="${trails}">
                            <option
                                    value="${trail.trailId}">${trail.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="help-block with-errors"></div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="date">Date Ridden</label>
                <div class="col-sm-4">
                    <div class="input-group date" data-provide="datepicker">
                        <input type="text" class="form-control" id="date" name="date" data-error="Please enter the date you rode."
                               required>
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>
                    </div>
                </div>
                <div class="help-block with-errors"></div>
            </div>




            <div class="form-group">
                <label class="control-label col-sm-2" for="grooming">Grooming
                    Type
                </label>
                <div class="col-sm-4">
                    <select class="form-control" id="grooming"
                            name="grooming"
                            data-error="Please select grooming type." required>
                        <c:forEach var="groomingType" items="${groomingTypes}">
                            <option
                                    value="${groomingType.groomingTypeId}">
                                    ${groomingType.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="help-block with-errors"></div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2"
                       for="conditions">Conditions
                </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="conditions"
                           name="conditions"
                           data-error="Please enter the trail conditions."
                           required>
                </div>
                <div class="help-block with-errors"></div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="comments">Comments
                </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="comments"
                           name="commments">
                </div>
            </div>

            <button type="submit" class="btn btn-default col-sm-offset-3"
                    data-disable="true">Submit
            </button>
            <button type="reset" class="btn btn-default">Clear</button>

        </form>
    </div>
</body>
    <jsp:include page="/contentEnd.jsp" />
<jsp:include page="/footer.jsp" />
</html>
