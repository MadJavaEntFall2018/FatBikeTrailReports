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
<jsp:include page="js.jsp" />
<body role="document">
<jsp:include page="navbar.jsp" />
<div class = "container">
    <form id="signUpForm" role="form" data-toggle="validator" class="form-horizontal"
          action="signUpUser"
           method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First
                Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="firstName"
                   name="firstName"
                       data-error="Please enter your first name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="lastName"
                   name="lastName"
                       data-error="Please enter your last name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="emailAddress">Email
                Address</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="emailAddress"
                   name="emailAddress"
                       data-error="Please enter your email address." required>
                </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="userName">Username</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="userName"
                       name="userName"
                       data-error="Please enter your userName." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password
                </label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password"
                   name="password" data-error="Please provide a password."
                       required>
                <div class="help-block with-errors"></div>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"
                   for="confirmPassword">Retype
                Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="confirmPassword"
                   name="confirmPassword" equalTo="#password"
                       data-match="#password"
                       data-match-error="Confirmation password does not match"
                       required data-error="Please retype your password.">
                <div class="help-block with-errors"></div>
                </div>
        </div>

        <button type="submit" class="btn btn-default col-sm-offset-3"
                data-disable="true">Submit
        </button>
        <button type="reset" class="btn btn-default">Clear</button>
        <!--for google recaptcha-->
        <div class="g-recaptcha" data-sitekey="6LewtTgUAAAAADuEbgusz9FbghpuXq-gBm6rLPS9"></div>
    </form>
</div>
</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>

</form>