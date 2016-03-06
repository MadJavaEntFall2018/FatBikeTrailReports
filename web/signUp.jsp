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
<div class = "container">
    <form id="signUpForm" role="form" data-toggle="validator" class="form-horizontal"
          action="/signUpUser"
           method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First
                Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="firstName"
                   name="firstName" required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="lastName"
                   name="lastName" required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="emailAddress">Email
                Address</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="emailAddress"
                   name="emailAddress" required>
                </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password
                </label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password"
                   name="password" required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"
                   for="confirmPassword">Retype
                Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="confirmPassword"
                   name="confirmPassword"
                       data-fv-identical="true"
                       data-fv-identical-field="password"
                       data-fv-identical-message="The password and its confirmation are not the same" required>
                </div>
        </div>

        <button type="submit" class="btn btn-default col-sm-offset-3">Submit
        </button>
        <button type="reset" class="btn btn-default">Clear</button>

    </form>
</div>
</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>

</form>