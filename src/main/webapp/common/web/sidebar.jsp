<%@include file="/common/taglib.jsp" %>
<div id="sidebar" class="span3">
    <div class="well well-small"><a id="myCart" href="product_summary.html"><img width="30" height="30" src="https://cdn-icons-png.flaticon.com/512/34/34627.png" alt="cart">3 Items in your cart  <span class="badge badge-warning pull-right">$155.00</span></a></div>
    <ul id="sideManu" class="nav nav-tabs nav-stacked">
<%--        <c:forEach items="${listCategories}" var="category" varStatus="status">--%>
<%--            <c:set var="category" value="${category}" scope="request"/>--%>
<%--            <c:import url="web.jsp"></c:import>--%>
<%--            <c:set var="category" value="" scope="request"/>--%>
<%--        </c:forEach>--%>
        <c:forEach begin="0" end="5" var="index">
            <c:import url="/views/web/components/category.component.jsp"></c:import>
        </c:forEach>
    </ul>
    <script>
        document.getElementsByClassName("subMenu")[0].className += " open";
    </script>
    <br/>
</div>

