<%@include file="/common/taglib.jsp" %>
<div id="header">
    <div class="container">
        <div id="welcomeLine" class="row">
            <div class="span6">Welcome!<strong> User</strong></div>
            <div class="span6">
                <div class="pull-right">
                    <span class="btn btn-mini">$155.00</span>
                    <a href="product_summary.html"><span class="btn btn-mini btn-primary">CART: 3 items </span> </a>
                </div>
            </div>
        </div>
        <!-- Navbar ================================================== -->
        <div id="logoArea" class="navbar">
            <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
            </a>
            <div class="navbar-inner">
                <a class="brand" href="index.html"><img width="100" height="100" src="https://en.everybodywiki.com/images/thumb/4/42/Hireleven.com_logo_hire11_100x200.png/300px-Hireleven.com_logo_hire11_100x200.png" alt="Bootsshop"/></a>
                <form class="form-inline navbar-search" method="post" action="products.html" >
                    <input id="srchFld" class="srchTxt" type="text" />
                    <select class="srchTxt">
                        <option>All</option>
                        <option>OPT 1 </option>
                        <option>OPT 2 </option>

                    </select>
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <ul id="topMenu" class="nav pull-right">
                    <li class=""><a href="<c:url value="/register"/>">Sign up</a></li>
                    <li class="">
                        <a href="<c:url value='/login'/>" role="button" data-toggle="modal" style="padding-right:0">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Header End====================================================================== -->