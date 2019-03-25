<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Register Customer</h1>

    <p class="lead">Please, fill the information below</p>
</div>

<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="customer">
    <h3>Basic info</h3>
    
    <div class="form-group">
        <label for="name">Name</label>
        <form:errors path="name" cssStyle="color: red" />
        <form:input path="name" id="name" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="email">Email</label>
        <form:errors path="email" cssStyle="color: red" />
        <span style="color: red">${emailMsg}</span>
        <form:input path="email" id="email" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="phone">Phone</label>
        <form:errors path="phone" cssStyle="color: red" />
        <form:input path="phone" id="phone" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="userName">User name</label>
        <form:errors path="userName" cssStyle="color: red" />
        <span style="color: red">${userNameMsg}</span>
        <form:input path="userName" id="userName" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="password">Password</label>
        <form:errors path="password" cssStyle="color: red" />
        <form:password path="password" id="password" class="form-control" />
    </div>
    
    <h3>Billing address</h3>

    <div class="form-group">
        <label for="billingAddress.streetName">Street name</label>
        <form:errors path="billingAddress.streetName" cssStyle="color: red" />
        <form:input path="billingAddress.streetName" id="billingAddress.streetName" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.apartmentNumber">Apartment</label>
        <form:errors path="billingAddress.apartmentNumber" cssStyle="color: red" />
        <form:input path="billingAddress.apartmentNumber" id="billingAddress.apartmentNumber" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.city">City</label>
        <form:errors path="billingAddress.city" cssStyle="color: red" />
        <form:input path="billingAddress.city" id="billingAddress.city" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.state">State</label>
        <form:errors path="billingAddress.state" cssStyle="color: red" />
        <form:input path="billingAddress.state" id="billingAddress.state" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.country">Country</label>
        <form:errors path="billingAddress.country" cssStyle="color: red" />
        <form:input path="billingAddress.country" id="billingAddress.country" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.zip">Zipcode</label>
        <form:errors path="billingAddress.zip" cssStyle="color: red" />
        <form:input path="billingAddress.zip" id="billingAddress.zip" class="form-control" />
    </div>

    
    <h3>Shipping address</h3>

    <div class="form-group">
        <label for="shippingAddress.streetName">Street name</label>
        <form:errors path="shippingAddress.streetName" cssStyle="color: red" />
        <form:input path="shippingAddress.streetName" id="shippingAddress.streetName" class="form-control" />
    </div>

    <div class="form-group">
        <label for="shippingAddress.apartmentNumber">Apartment</label>
        <form:errors path="shippingAddress.apartmentNumber" cssStyle="color: red" />
        <form:input path="shippingAddress.apartmentNumber" id="shippingAddress.apartmentNumber" class="form-control" />
    </div>

    <div class="form-group">
        <label for="shippingAddress.city">City</label>
        <form:errors path="shippingAddress.city" cssStyle="color: red" />
        <form:input path="shippingAddress.city" id="shippingAddress.city" class="form-control" />
    </div>

    <div class="form-group">
        <label for="shippingAddress.state">State</label>
        <form:errors path="shippingAddress.state" cssStyle="color: red" />
        <form:input path="shippingAddress.state" id="shippingAddress.state" class="form-control" />
    </div>

    <div class="form-group">
        <label for="shippingAddress.country">Country</label>
        <form:errors path="shippingAddress.country" cssStyle="color: red" />
        <form:input path="shippingAddress.country" id="shippingAddress.country" class="form-control" />
    </div>

    <div class="form-group">
        <label for="shippingAddress.zip">Zipcode</label>
        <form:errors path="shippingAddress.zip" cssStyle="color: red" />
        <form:input path="shippingAddress.zip" id="shippingAddress.zip" class="form-control" />
    </div>

    <br/><br/>

    <input type="submit" value="Submit" class="btn btn-primary" />
    <a href="<c:url value="/" />" class="btn btn-primary" >Cancel</a>

</form:form>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>