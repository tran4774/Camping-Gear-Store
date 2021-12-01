<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <title>CAMP GEAR</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="<c:url value="/templates/web/js/jquery.simplePagination.js" />" type="text/javascript"></script>

    <!-- Bootstrap style -->
    <link rel="stylesheet"  id="callCss" type="text/css" href="<c:url value='/templates/web/css/bootstrap.min.css'/>" media="screen" />
    <link rel="stylesheet"  type="text/css" href="<c:url value='/templates/web/css/base.css'/>" media="screen" />
    <link rel="stylesheet"  type="text/css" href="<c:url value='/templates/web/css/simplePagination.css'/>" media="screen" />
    <!-- Bootstrap style responsive -->
    <link rel="stylesheet"  type="text/css" href="<c:url value='/templates/web/css/bootstrap-responsive.min.css'/>"  />
    <link rel="stylesheet"  type="text/css" href="<c:url value='/templates/web/css/font-awesome.css'/>">
    <!-- Google-code-prettify -->
    <link rel="stylesheet"  type="text/css" href="<c:url value='/templates/web/js/google-code-prettify/prettify.css'/>" />
    <!-- fav and touch icons -->
<%--    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">--%>
<%--    <link rel="apple-touch-icon-precomposed" sizes="144x144"--%>
<%--          href="themes/images/ico/apple-touch-icon-144-precomposed.png">--%>
<%--    <link rel="apple-touch-icon-precomposed" sizes="114x114"--%>
<%--          href="themes/images/ico/apple-touch-icon-114-precomposed.png">--%>
<%--    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">--%>
<%--    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">--%>
    <!--	<style type="text/css" id="enject"></style>-->
</head>
<body>

<%@ include file="/common/web/header.jsp" %>
<div id="mainBody">
    <div class="container">
        <div class="row">
            <%@ include file="/common/web/sidebar.jsp" %>
            <sitemesh:write property='body'/>
        </div>
    </div>
</div>
<%@ include file="/common/web/footer.jsp" %>


<%--<script src="<c:url value="/templates/web/js/jquery.js" />" type="text/javascript"></script>--%>

<%--<script src="<c:url value="/templates/web/js/jquery.twbsPagination.min.js" />" type="text/javascript"></script>--%>
<script src="<c:url value="/templates/web/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/web/js/google-code-prettify/prettify.js"/>"></script>
<script src="<c:url value="/templates/web/js/bootshop.js"/>"></script>
<script src="<c:url value="/templates/web/js/jquery.lightbox-0.5.js"/>"></script>

</body>
</html>
