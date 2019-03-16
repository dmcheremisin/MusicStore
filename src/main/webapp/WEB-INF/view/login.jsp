<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
<div id="login-box">
    <h2>Login with Username and Password</h2>

    <c:if test="${not empty msg}" >
        <div class="msg">
                ${msg}
        </div>
    </c:if>

    <form name="loginForm" action="<c:url value="/login" />" method="post" >
        <c:if test="${not empty error}">
            <div class="error" style="color: red;">
                ${error}
            </div>
        </c:if>
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">User: </label>
            <input type="text" id="password" name="password" class="form-control">
        </div>

        <input type="submit" value="Submit" class="btn btn-primary">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>