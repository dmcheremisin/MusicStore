<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Invalid cart!</h1>
        </div>
    </div>
</section>

<section class="container">
    <p>
        <a href="<spring:url value="/product/productList" />" class="btn btn-primary">Products</a>
    </p>
</section>

<%@include file="/WEB-INF/view/template/footer.jsp" %>
