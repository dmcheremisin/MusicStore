var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.refreshCart = function() {
        $http.get($scope.getUrl() + '/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
            $scope.calcGrandTotal();
        });
    };

    $scope.clearCart = function() {
        $http.delete($scope.getUrl() + '/rest/cart/' + $scope.cartId)
            .success($scope.refreshCart());
    };

    $scope.addToCart = function (productId) {
        $http.put($scope.getUrl() + '/rest/cart/add/' + productId).success(function () {
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put($scope.getUrl() + '/rest/cart/remove/' + productId).success(function () {
            $scope.refreshCart();
        });
    };

    $scope.calcGrandTotal = function () {
        var grandTotal = 0;
        for(var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        $scope.grandTotal = grandTotal;
        return grandTotal;
    };

    $scope.getUrl = function () {
        return window.location.protocol + "//" + window.location.host;
    }

});