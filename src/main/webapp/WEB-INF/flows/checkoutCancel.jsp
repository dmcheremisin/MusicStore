<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">Checkout canceled</h1>

            <p>Your checkout process is cancelled. You may continue shopping.</p>
        </div>
    </div>
</section>

<section class="container">
    <p>
        <a href="<spring:url value="/product/productList" />" class="btn btn-primary">Products</a>
    </p>
</section>

<%@include file="/WEB-INF/view/template/footer.jsp" %>
