<%@include file="/common/taglib.jsp" %>
<div class="span9">
    <div style="display: contents" class="well well-small">
        <h4>Latest Products </h4>
        <ul class="thumbnails" id="list-products"></ul>
        <div style="margin-left: 250px"><ul class="pagination" id="pagination"></ul></div>
        <script>
            $(document).ready(function () {
                let urlPattern = `/api/products?page=1`;
                getListProductPagination(urlPattern);
            })
            $(function() {
                $('#pagination').pagination({
                    items: ${productsNumber},
                    itemsOnPage: ${itemsOnPage},
                    hrefTextPrefix: "?page=",
                    cssStyle: 'light-theme',
                    onPageClick: function (pageNumber, event) {
                        let urlPattern = `/api/products?page=\${\$('#pagination').pagination('getCurrentPage')}`;
                        event.preventDefault();
                        getListProductPagination(urlPattern)
                    }
                });
            });
            function getListProductPagination(urlPattern){
                $.get(urlPattern, function (data) {
                    $('#list-products').html(data);
                })
            }
        </script>
    </div>
</div>