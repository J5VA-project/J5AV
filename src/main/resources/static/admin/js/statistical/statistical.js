app.controller("size-manager-ctrl", function ($scope, $http) {

	$scope.statistical = [];
	$scope.form = {};

	$scope.initialize = function () {
		//load products
		$http.get("/rest/size").then(resp => {
			$scope.statistical = resp.data;
		});
	}

	//khởi đầu
	$scope.initialize();

});