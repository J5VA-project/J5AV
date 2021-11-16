app.controller("product-manager-ctrl", function($scope, $http) {
	$scope.foods = [];
	$scope.cates = [];
	$scope.sizes = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load foods
		$http.get("/rest/food-detail").then(resp => {
			$scope.foods = resp.data;
		});
		//load categories
		$http.get("/rest/category").then(resp => {
			$scope.cates = resp.data;
		});
		//load size
		$http.get("/rest/size").then(resp => {
			$scope.sizes = resp.data;
		});
		$scope.random = Math.floor((Math.random() * 99999));
		$scope.form.food_id = $scope.random;
	}

	//khởi đầu
	$scope.initialize();


	//xóa form
	$scope.reset = function() {
	$scope.random = Math.floor((Math.random() * 99999));
		$scope.form = {
		food_id : $scope.random,
		status : true,
		};
	}
		

	//hiển thị lên form
	$scope.edit = function(food) {
		$scope.form = angular.copy(food);
	}

		//thêm sản phẩm mới
	$scope.create = function() {
		var food = angular.copy($scope.form);
		$http.post(`/rest/food-detail`, food).then(resp => {
			$scope.foods.push(resp.data);
			$scope.reset();
			alert("Thêm mới food thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới food!");
			console.log("Error", error);
		});
	}
	
	
	//thêm sản phẩm mới
	$scope.update = function() {
		var food = angular.copy($scope.form);
		$http.put(`/rest/food-detail/${food.food_id}`, food).then(resp => {
			var index = $scope.foods.findIndex(p => p.food_id == food.food_id);
			$scope.foods[index] = food;
			alert("Cập nhật food thành công!");
		}).catch(error => {
			alert("Lỗi cập nhật food!");
			console.log("Error", error);
		});
	}

	//xóa sản phẩm
	$scope.delete = function(food) {
		$http.delete(`/rest/food/${food.food_id}`).then(resp => {
			var index = $scope.foods.findIndex(p => p.food_id == food.food_id);
			$scope.foods.splice(index, 1);
			$scope.reset();
			alert("Xóa food thành công!");
		}).catch(error => {
			alert("Lỗi xóa food!");
			console.log("Error", error);
		});
	}
	//Upload hình
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/feature', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.photo = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		})
	}

	$scope.pager = {
		page: 0,
		food: 6,
		get foods() {
			var start = this.page * this.food;
			return $scope.foods.slice(start, start + this.food);
		},
		get count() {
			return Math.ceil(1.0 * $scope.foods.length / this.food);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}

	// $scope index lưu trữ tab hiện tại, ban đầu gán nó = tab1
	$scope.current_tab = 1;

	// Hàm đổi tab
	$scope.changeTab = function(index) {
		$scope.current_tab = index;
	};

	// Hàm kiểm tra có phải tab hiện tại hay không
	// hàm này sẽ trả về true/false và dùng kết hợp
	// với ng-class để active menu
	$scope.isActiveTab = function(index) {
		return index === $scope.current_tab;
	};
});