<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Customer</h1>

    <p class="lead">Customer details</p>
</div>

<form:form modelAttribute="order" cssClass="form-horizontal">

    <h3>Shipping address</h3>

    <div class="form-group">
        <label for="shippingAddress.streetName">Street name</label>
        <form:input path="cart.customer.shippingAddress.streetName" id="shippingAddress.streetName" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="shippingAddress.apartmentNumber">Apartment</label>
        <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingAddress.apartmentNumber" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="shippingAddress.city">City</label>
        <form:input path="cart.customer.shippingAddress.city" id="shippingAddress.city" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="shippingAddress.state">State</label>
        <form:input path="cart.customer.shippingAddress.state" id="shippingAddress.state" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="shippingAddress.country">Country</label>
        <form:input path="cart.customer.shippingAddress.country" id="shippingAddress.country" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="shippingAddress.zip">Zipcode</label>
        <form:input path="cart.customer.shippingAddress.zip" id="shippingAddress.zip" class="form-control"/>
    </div>

    <input type="hidden" name="_flowExecutionKey">

    <br/><br/>

    <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
    <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />
    <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</form:form>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>