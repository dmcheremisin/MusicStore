var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.refreshCart = function() {
        $http.get($scope.getUrl() + '/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function() {
        $http.delete($scope.getUrl() + '/rest/cart/' + $scope.cartId)
            .success($scope.refreshCart());
    };

    $scope.addToCart = function (productId) {
        $http.put($scope.getUrl() + '/rest/cart/add/' + productId).success(function (data) {
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put($scope.getUrl() + '/rest/cart/remove/' + productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.getUrl = function () {
        return window.location.protocol + "//" + window.location.host;
    }

});