<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
<div id="login-box">
    <h2>Login with Username and Password</h2>
    <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post" >
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">User: </label>
            <input type="text" id="password" name="password" class="form-control">
        </div>

        <input type="submit" value="submit" class="btn btn-default">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>