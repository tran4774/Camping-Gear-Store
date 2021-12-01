<%@include file="/common/taglib.jsp" %>
<%--listProducts variable is in attribute of request from ProductAPI--%>
<c:forEach items="${listProducts}" var="product" varStatus="status">
    <li class="span3">
        <div class="thumbnail" style="overflow: hidden; max-height: 500px; vertical-align: center">
            <div style="min-width: 260px; min-height: 260px; overflow: hidden;">
                <a href="/${product.id}"><img src="${product.colors[0].imageUrl[0]}" alt="media"/></a>
            </div>
            <div class="caption">
                <h5 style="overflow: hidden; height: 40px;">${product.productName}</h5>
                <p style="overflow: hidden; max-height: 40px;">
                        ${product.description}
                </p>
                <h4 style="text-align:center">
                    <a class="btn" href="product_details.html">DETAIL</a>
                    <a class="btn" href="#">Add to CART</a>
                    <a class="btn btn-primary" href="#">$${product.sales[0]}</a>
                </h4>
            </div>
        </div>
    </li>
</c:forEach>
