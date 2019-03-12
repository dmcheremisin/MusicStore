<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

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
            <td><img src="#" alt="image"/></td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice} USD</td>
            <td>
                <a href="<spring:url value="/productList/viewProduct/${product.productId}"></spring:url> ">
                    <span class="glyphicon glyphicon-info-sign"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<a class="btn btn-primary" href="<spring:url  value="/admin/productInventory/addProduct" />">Add Product</a>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>