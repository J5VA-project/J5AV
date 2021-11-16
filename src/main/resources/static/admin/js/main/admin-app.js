app = angular.module("admin-app", ["ngRoute"]);
app.controller("app-ctrl", function($scope, $http) {
	$scope.total = [];
	$scope.total = function() {
		$http.get("/rest/orders/total-order").then(resp => {
			$scope.total = resp.data;
		});
	}
	$scope.total();
});
app.config(function($routeProvider) {
	$routeProvider
		.when("/logout", {
			templateUrl: "/auth/logoff",
			controller: "login-ctrl"
		})
		.when("/change-pw", {
			templateUrl: "/admin/change-pw",
			controller: "change-pw-ctrl"
		})
		.when("/reset-pw", {
			templateUrl: "/admin/reset-pw",
			controller: "reset-pw-ctrl"
		})
		.when("/authorized", {
			templateUrl: "/admin/authorized",
			controller: "authorized-ctrl"
		})
		.when("/account-form", {
			templateUrl: "/admin/account-form",
			controller: "account-form-ctrl"
		})
		.when("/account-list", {
			templateUrl: "/admin/account-list",
			controller: "account-list-ctrl"
		})

		.when("/product-manager", {
			templateUrl: "/admin/product-manager",
			controller: "product-manager-ctrl"
		})
		.when("/size-manager", {
			templateUrl: "/admin/size-manager",
			controller: "size-manager-ctrl"
		})
		.when("/report", {
			templateUrl: "/admin/report",
			controller: "report-ctrl"
		})
		.when("/category-manager", {
			templateUrl: "/admin/category-manager",
			controller: "category-manager-ctrl"
		})
		.when("/order", {
			templateUrl: "/admin/order",
			controller: "order-ctrl"
		})
		.otherwise({
			templateUrl: "/admin/home",
			controller: "home-ctrl"
		});
})