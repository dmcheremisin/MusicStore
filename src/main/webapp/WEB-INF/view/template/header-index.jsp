<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Music Store</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/datatables.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <%--<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>--%>
    <script src="<c:url value="/resources/js/datatables.min.js" />"></script>
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="<c:url value="/" /> ">Home</a></li>
                        <li><a href="<c:url value="/product/productList" />">Products</a></li>
                        <li><a href="<c:url value="/about" />">About Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <sec:authentication var="user" property="principal"/>
                        <sec:authorize access="isAuthenticated()">
                            <li><a>Welcome: ${user.username}</a></li>
                            <li>
                                <form:form class="mysic_logout" action="${pageContext.request.contextPath}/logout" method="POST">
                                    <input type="hidden" value="Logout"/>
                                </form:form>
                                <a href="#" class="logout">Logout</a>
                            </li>
                            <sec:authorize access="!hasRole('ROLE_ADMIN')">
                                <li><a href="<c:url value="/customer/cart" />">Cart</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </sec:authorize>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <li><a href="<c:url value="/loginPage" />">Login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a></li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>