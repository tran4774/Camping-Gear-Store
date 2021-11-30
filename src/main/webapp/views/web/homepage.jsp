<%@include file="/common/taglib.jsp" %>
<div class="span9">
    <div style="display: contents" class="well well-small">
        <h4>Latest Products </h4>
        <ul class="thumbnails">
            <c:forEach items="${listProducts}" var="product" varStatus="status">
                <c:set var="product" value="${product}" scope="request"/>
                <c:import url="components/product.component.jsp"></c:import>
                <c:set var="product" value="" scope="request"/>
            </c:forEach>
        </ul>
    </div>
</div>