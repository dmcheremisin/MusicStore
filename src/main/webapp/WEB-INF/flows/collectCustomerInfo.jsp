<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Customer</h1>

    <p class="lead">Customer details</p>
</div>

<form:form modelAttribute="order" cssClass="form-horizontal">
    <h3>Basic info</h3>

    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="cart.customer.name" id="name" class="form-control" />
    </div>

    <div class="form-group">
        <label for="email">Email</label>
        <form:input path="cart.customer.email" id="email" class="form-control" />
    </div>

    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input path="cart.customer.phone" id="phone" class="form-control" />
    </div>

    <h3>Billing address</h3>

    <div class="form-group">
        <label for="billingAddress.streetName">Street name</label>
        <form:input path="cart.customer.billingAddress.streetName" id="billingAddress.streetName" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.apartmentNumber">Apartment</label>
        <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingAddress.apartmentNumber" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.city">City</label>
        <form:input path="cart.customer.billingAddress.city" id="billingAddress.city" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.state">State</label>
        <form:input path="cart.customer.billingAddress.state" id="billingAddress.state" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.country">Country</label>
        <form:input path="cart.customer.billingAddress.country" id="billingAddress.country" class="form-control" />
    </div>

    <div class="form-group">
        <label for="billingAddress.zip">Zipcode</label>
        <form:input path="cart.customer.billingAddress.zip" id="billingAddress.zip" class="form-control" />
    </div>

    <input type="hidden" name="_flowExecutionKey">

    <br/><br/>

    <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />
    <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</form:form>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>