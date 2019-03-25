<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<script>
    $(document).ready(function () {
        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10,-1], [1,2,3,5,10, "All"]]
        });
    });
</script>

<div class="page-header">
    <h1>Product Inventory</h1>

    <p class="lead">This is a product inventory page!</p>
</div>

<table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
        <th>Photo phumb</th>
        <th>Product name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>
                <img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image" style="width:100%" />
            </td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice} USD</td>
            <td>
                <a href="<spring:url value="/product/viewProduct/${product.productId}"></spring:url> ">
                    <span class="glyphicon glyphicon-info-sign"></span>
                </a>
                <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}"></spring:url> ">
                    <span class="glyphicon glyphicon-remove"></span>
                </a>
                <a href="<spring:url value="/admin/product/edit/${product.productId}"></spring:url> ">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<a class="btn btn-primary" href="<spring:url  value="/admin/product/addProduct" />">Add Product</a>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>