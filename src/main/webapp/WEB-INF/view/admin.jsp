<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Admin page</h1>

    <p class="lead">This is administrator page!</p>
</div>
<h3>
    <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
</h3>

<p>Here you can view, check and modify the product inventory!</p>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>