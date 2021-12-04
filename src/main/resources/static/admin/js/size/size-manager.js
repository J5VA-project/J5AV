app.controller("size-manager-ctrl", function ($scope, $http) {
	//Button Add
	$("#btn-add").click(function () {
		$('.error_name').css('color','red');
		$('.error_name').css('font-style','italic');

		var check = true;
		if ($('#name').val() == '') {
			$('.error_name').html('X Size name not nul');
			$('.error_name').show();
			check = false;
		} else {
			$('.error_name').hide();
		}
		if(check==true){
			$scope.create();
		}
	});
	//Button update
	$("#btn-update").click(function () {
		$('.error_name').css('color','red');
		$('.error_name').css('font-style','italic');

		var check = true;
		if ($('#name').val() == '') {
			$('.error_name').html('X Size name not nul');
			$('.error_name').show();
			check = false;
		} else {
			$('.error_name').hide();
		}
		if(check==true){
			$scope.update(size);
		}
	});
	$scope.sizes = [];
	$scope.form = {};

	$scope.initialize = function () {
		//load products
		$http.get("/rest/size").then(resp => {
			$scope.sizes = resp.data;
		});
	}

	//khởi đầu
	$scope.initialize();


	//xóa form
	$scope.reset = function () {
		$scope.form = {
		};
	}

	//hiển thị lên form
	$scope.edit = function (size) {
		$scope.form = angular.copy(size);
	}

	//thêm sản phẩm mới
	$scope.create = function () {
		var size = angular.copy($scope.form);
		$http.post(`/rest/size`, size).then(resp => {
			$scope.sizes.push(resp.data);
			$scope.reset();
			alert("Thêm mới size thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới size!");
			console.log("Error", error);
		});
	}

	//thêm sản phẩm mới
	$scope.update = function () {
		var size = angular.copy($scope.form);
		$http.put(`/rest/size/${size.size_id}`, size).then(resp => {
			var index = $scope.sizes.findIndex(p => p.size_id == size.size_id);
			$scope.sizes[index] = size;
			alert("Cập nhật size thành công!");
		}).catch(error => {
			alert("Lỗi cập nhật size!");
			console.log("Error", error);
		});
	}

	//xóa sản phẩm
	$scope.delete = function (size) {
		$http.delete(`/rest/size/${size.size_id}`).then(resp => {
			var index = $scope.sizes.findIndex(p => p.size_id == size.size_id);
			$scope.sizes.splice(index, 1);
			$scope.reset();
			alert("Xóa size thành công!");
		}).catch(error => {
			alert("Lỗi xóa size!");
			console.log("Error", error);
		});
	}

	$scope.pager = {
		page: 0,
		size: 6,
		get sizes() {
			var start = this.page * this.size;
			return $scope.sizes.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.sizes.length / this.size);
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
});