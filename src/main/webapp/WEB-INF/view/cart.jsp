<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Cart</h1>
            <p>All the selected products in your shopping cart</p>
        </div>
    </div>
</section>

<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit price</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems">
                <td>{{item.product.productName}}</td>
                <td>{{item.product.productPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td>
                    <a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove">Remove</span>
                    </a>
                </td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>Grand total:</th>
                <th>{{grandTotal}}</th>
                <th></th>
            </tr>
        </table>
        <div>
            <a href="<spring:url value="/product/productList" />" class="btn btn-primary">Continue shopping</a> <a class="btn btn-danger" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Clear cart</a>
        </div>
    </div>
</section>

<script src="<c:url value="/resources/js/controller.js" />" ></script>
<%@include file="/WEB-INF/view/template/footer.jsp" %>
