<%@include file="/common/taglib.jsp"%>
<%--product variable is set in scope request in parent (homepage.jsp)--%>
<li class="span3">
    <div class="thumbnail">
        <a href="/${product.id}"><img src="${product.colors[0].imageUrl[0]}" alt="media"/></a>
        <div class="caption">
            <h5>${product.productName}</h5>
            <p>
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
