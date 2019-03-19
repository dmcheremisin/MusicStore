<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <sec:authentication var="user" property="principal"/>
    <sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
        <h1>Welcome: ${user.username}
            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                <input type="submit" value="Logout" class="btn btn-primary"/>
            </form:form>
        </h1>
    </sec:authorize>
</div>

<h3>
    <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
</h3>

<p>Here you can view, check and modify the product inventory!</p>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>