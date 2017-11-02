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
          action="addTrail"
          method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Trail Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="name"
                       name="name"
                       data-error="Please enter the trail name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="address">Trailhead
                Address</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="address"
                       name="address"
                       data-error="Please enter the trailhead street address."
                       required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="city">City</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="city"
                       name="city"
                       data-error="Please enter the city." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="state">State</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="state"
                       name="state"
                       data-error="Please enter the state." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="zip">Zip Code</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="zip"
                       name="zip"
                       data-error="Please enter trail zip code." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="length">Length
            </label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="length"
                       name="length"
                       data-error="Please enter trail length." required>
            </div>
            <div class="help-block with-errors"></div>
            <label class="control-label col-sm-1" for="mi">mi
            </label>
            <div class="col-sm-1 ">
                <input type="radio" class="form-control" id="mi"
                       name="units" value="mi">
            </div>
            <label class="control-label col-sm-1" for="km">km
            </label>
            <div class="col-sm-1">
                <input type="radio" class="form-control" id="km"
                       name="units" value="km">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="difficulty">Difficulty
            </label>
            <div class="col-sm-4">
                <select class="form-control" id="difficulty"
                       name="difficulty"
                       data-error="Please select trail difficulty." required>
                    <c:forEach var="difficulty" items="${difficulties}">
                    <option value="${difficulty.difficultyId}">${difficulty.name}</option>
                        </c:forEach>
                </select>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">x
            <label class="control-label col-sm-2" for="type">Type
            </label>
            <div class="col-sm-4">
                <select class="form-control" id="type"
                        name="type"
                        data-error="Please select trail type." required>
                    <c:forEach var="type" items="${types}">
                        <option value="${type.trailTypeId}">${type.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Description
            </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="description"
                       name="description"
                       data-error="Please enter trail description." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="website">Website
            </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="website"
                       name="website"
                       data-error="Please enter link to trail website."
                       required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="trailMap">Trail Map
            </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="trailMap"
                       name="trailMap"
                       data-error="Please enter link to trail map."
                       required>
            </div>
            <div class="help-block with-errors"></div>
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