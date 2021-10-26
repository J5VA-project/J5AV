app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
	alert("ga")
    $routeProvider
	alert("ga")
        .when("/product-list", {
            templateUrl: "admin/product/list-products.html",
            controller: "product-list-ctrl"
        })
		.when("/product-edit", {
            templateUrl: "/admin/product/product-form.html",
            controller: "product-form-ctrl"
        })
		.when("/size-manager", {
            templateUrl: "/admin/product/size-manager.html",
            controller: "size-manager-ctrl"
        })
        .when("/login", {
            templateUrl: "/admin/account/page-login.html",
            controller: "login-ctrl"
        })
        .when("/report", {
            templateUrl: "/admin/report/report.html",
            controller: "report-ctrl"
        })
        .when("/customer", {
            templateUrl: "/admin/customer/list-customers.html",
            controller: "customers-ctrl"
        })
        .when("/authorized", {
            templateUrl: "/admin/account/authorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            templateUrl: "<h1 class='text-center'>FPT Polytechnic Administration</h1>"
        });
})