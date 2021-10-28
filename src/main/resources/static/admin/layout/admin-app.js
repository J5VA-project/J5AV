app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/dashboard-ctrl", {
            templateUrl: "../layout/home/dashboard.html",
            controller: "dashboard-list-ctrl",
        })
    
        .when("/product-ctrl", {
            templateUrl: "../layout/product/list-products.html",
            controller: "product-list-ctrl",
        })
		.when("/product-edit", {
            templateUrl: "../layout/product/product-form.html",
            controller: "product-list-ctrl"
        })
		.when("/size-manager", {
            templateUrl: "../layout/product/size-manager.html",
            controller: "product-list-ctrl"
        })
        
        
        .when("/customer-ctrl", {
            templateUrl: "../layout/customer/list-customers.html",
            controller: "customer-list-ctrl"
        })
        .when("/customer-edit", {
            templateUrl: "../layout/customer/customer-form.html",
            controller: "customer-list-ctrl"
        })
        
        
        .when("/order-ctrl", {
            templateUrl: "../layout/order/form-fileupload.html",
            controller: "order-list-ctrl"
        })
        .when("/order-edit", {
            templateUrl: "../layout/order/form-fileupload.html",
            controller: "order-list-ctrl"
        })
        .when("/order-shipped", {
            templateUrl: "../layout/order/form-xeditable.html",
            controller: "order-list-ctrl"
        })
        .when("/order-success", {
            templateUrl: "../layout/order/form-xeditable.html",
            controller: "order-list-ctrl"
        })
        .when("/order-received", {
            templateUrl: "../layout/order/form-xeditable.html",
            controller: "order-list-ctrl"
        })
        
        
        .when("/login", {
            templateUrl: "../layout/account/page-login.html",
            controller: "login-ctrl"
        })
        .when("/report", {
            templateUrl: "../layout/report/report.html",
            controller: "report-ctrl"
        })
        .when("/authorized", {
            templateUrl: "../layout/account/authorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
        	templateUrl: "../layout/home/dashboard.html",
            controller: "dashboard-list-ctrl"
    	});
})




