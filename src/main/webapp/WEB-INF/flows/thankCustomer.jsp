<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Thank you for your order!</h1>
            <p>Your order will be shipped in 2 business days!</p>
        </div>
    </div>
</section>

<section class="container">
    <p>
        <a href="<spring:url value="/" />" class="btn btn-primary">Ok</a>
    </p>
</section>

<%@include file="/WEB-INF/view/template/footer.jsp" %>
