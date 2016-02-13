<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 1/29/16
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Fixed navbar -->

<script type="text/javascript">
    function getPageNameFromURL() {
        var URL = document.location.href;
        var PageFileName = URL.substring(URL.lastIndexOf('/') + 1);

        return PageFileName;


    }

    $(document).ready(function() {
        var PageName = getPageNameFromURL();

        switch (PageName) {
            case 'index.jsp':
                $('#index').addClass("active");
                break;
            case 'viewTrail.jsp':
                $('#viewTrail').addClass("active");
                break;
            case 'addReport.jsp':
                $('#addReport').addClass("active");
                break;
            case 'addTrail.jsp':
                $('#addTrail').addClass("active");
                break;
            case 'signInConfirmation.jsp':
                $('#signInConfirmation').addClass("active");
                break;
            case 'about.jsp':
                $('#about').addClass("active");
                break;
            case 'signUp.jsp':
                $('#signUp').addClass("active");
                break;
        }
    });


</script>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Fat Bike Trail Reports</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="index"><a href="index.jsp">Reports</a></li>
                <li id="viewTrail"><a href="viewTrail.jsp">Trails</a></li>
                <li id="addReport"><a href="user/addReport.jsp">New
                    Report</a></li>
                <li id="addTrail"><a href="user/addTrail.jsp">New Trail</a></li>
                <li id="signInConfirmation"><a
                        href="user/signInConfirmation.jsp">Sign In</a></li>
                <li id="signUp"><a href="signUp.jsp">Sign Up</a></li>
                <li id="about"><a href="about.jsp">About</a></li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>