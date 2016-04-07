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
<body role="document">

<jsp:include page="/navbar.jsp" />
<div class = "container">
    <form id="addTrailForm" role="form" data-toggle="validator"
          class="form-horizontal"
          action="/addTrail"
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
            <label class="control-label col-sm-2" for="zip">Zip Code</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="zip"
                       name="zip"
                       data-error="Please enter trail zip code." required>
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