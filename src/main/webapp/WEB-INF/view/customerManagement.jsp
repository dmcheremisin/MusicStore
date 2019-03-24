<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Customer Management Page</h1>

    <p class="lead">Here you can view the customer information!</p>
</div>

<table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
        <th>Name</th>
        <th>Email</th>
        <th>Phone number</th>
        <th>User name</th>
        <th>Enabled</th>
    </tr>
    </thead>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
            <td>${customer.userName}</td>
            <td>${customer.enabled}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>