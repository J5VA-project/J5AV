app.controller("account-list-ctrl", function ($scope, $http, $location) {
	$("#btn-add").click(function () {
		$('.error_username').css('color', 'red');
		$('.error_username').css('font-style', 'italic');
		$('.error_password').css('color', 'red');
		$('.error_password').css('font-style', 'italic');
		$('.error_fullname').css('color', 'red');
		$('.error_fullname').css('font-style', 'italic');
		$('.error_email').css('color', 'red');
		$('.error_email').css('font-style', 'italic');
		$('.error_address').css('color', 'red');
		$('.error_address').css('font-style', 'italic');
		$('.error_phone').css('color', 'red');
		$('.error_phone').css('font-style', 'italic');
		$('.error_salary').css('color', 'red');
		$('.error_salary').css('font-style', 'italic');

		var check = true;
		if ($('#username').val() == '') {
			$('.error_username').html('X Username not null');
			$('.error_username').show();
			check = false;
		} else {
			$('.error_username').hide();
		}

		if ($('#password').val() == '') {
			$('.error_password').html('X Password not null');
			$('.error_password').show();
			check = false;
		} else if ($('#password').val().length > 50
			|| $('#password').val().length < 3) {
			$('.error_password').html('X Length password between 3 and 50 characters');
			$('.error_password').show();
			check = false;
		}
		else {
			$('.error_password').hide();
		}

		if ($('#fullname').val() == '') {
			$('.error_fullname').html('X Fullname not null');
			$('.error_fullname').show();
			check = false;
		} else {
			$('.error_fullname').hide();
		}
       var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 

		if ($('#email').val() == '') {
			$('.error_email').html('X Email not null');
			$('.error_email').show();
			check = false;
		} else if(!filter.test($('#email').val())){
		    $('.error_email').html('X Email invalid!');
			$('.error_email').show();
			check = false;
		} else {
			$('.error_email').hide();
		}

		if ($('#address').val() == '') {
			$('.error_address').html('X Address not null');
			$('.error_address').show();
			check = false;
		} else {
			$('.error_address').hide();
		}

		if ($('#phone').val() == '') {
			$('.error_phone').html('X Phone not null');
			$('.error_phone').show();
			check = false;
		} else {
			$('.error_phone').hide();
		}

		if ($('#salary').val() == '') {
			$('.error_salary').html('X Salary not null');
			$('.error_salary').show();
			check = false;
		} else {
			$('.error_salary').hide();
		}


		if (check == true) {
			$scope.create();
		}
	});

	$scope.accounts = [];
	$scope.form = {};

	$scope.initialize = function () {
		//load products
		$http.get("/rest/accounts").then(resp => {
			$scope.accounts = resp.data;
			$scope.accounts.forEach(account => {
				account.hire_date = new Date(account.hire_date)
				account.birthdate = new Date(account.birthdate)
			})
		});
	}

	//khởi đầu
	$scope.initialize();

	//xóa form
	$scope.reset = function () {
		$scope.form = {
			hire_date: new Date(),
			image: 'empty-account.jpg',
			gender: true,
		};
		$scope.check = '';
		$('#username').css('border-color', 'grey');
		$('.error_username').hide();
		$('#email').css('border-color', 'grey');
		$('.error_email').hide();
	}

	//hiển thị lên form
	$scope.edit = function (account) {
		$scope.form = angular.copy(account);
		$scope.check = 1;
		$('#username').css('border-color', 'grey');
		$('.error_username').hide();
		$('#email').css('border-color', 'grey');
		$('.error_email').hide();
	}

	//thêm sản phẩm mới
	$scope.create = function () {
		var account = angular.copy($scope.form);

		$http.get(`/rest/accounts/checkUsername/${account.username}`).then(resp => {
			$scope.check = resp.data;
			//alert($scope.check.username);
			if (account.username == $scope.check.username) {
				$('#username').css('border-color', 'red');
				$('.error_username').html('X Username existed');
				$('.error_username').show();
			} else {
				$('#username').css('border-color', 'grey');
				$('.error_username').hide();
				$http.get(`/rest/accounts/checkEmail/${account.email}`).then(resp => {
					$scope.email = resp.data;
					if (account.email == $scope.email.email) {
						$('#email').css('border-color', 'red');
						$('.error_email').html('X Email existed');
						$('.error_email').show();
					} else {
						$('#email').css('border-color', 'grey');
						$('.error_email').hide();
						$http.post(`/rest/accounts`, account).then(resp => {
							$scope.accounts.push(resp.data);
							$scope.reset();
							alert("Successfully added new account!");
						}).catch(error => {
							alert("Failed to add new account!");
							console.log("Error", error);
						});
					}
				}).catch(error => {
					alert("Lỗi tìm email!");
					console.log("Error", error);
				});
			}
		}).catch(error => {
			alert("Lỗi tìm account!");
			console.log("Error", error);
		});
	}

	//update sản phẩm
	$scope.update = function () {
		var account = angular.copy($scope.form);
		$http.put(`/rest/accounts/${account.username}`, account).then(resp => {
			var index = $scope.accounts.findIndex(p => p.username == account.username);
			$scope.accounts[index] = account;
			//$scope.reset();
			alert("Cập nhật account thành công!");
		}).catch(error => {
			alert("Lỗi cập nhật account!");
			console.log("Error", error);
		});
		$('#username').css('border-color', 'grey');
		$('.error_username').hide();
		$('#email').css('border-color', 'grey');
		$('.error_email').hide();
	}



	//xóa sản phẩm
	$scope.delete = function (account) {
		$http.delete(`/rest/accounts/${account.username}`).then(resp => {
			var index = $scope.accounts.findIndex(p => p.username == account.username);
			$scope.accounts.splice(index, 1);
			$scope.reset();
			alert("Xóa account thành công!");
		}).catch(error => {
			alert("Lỗi xóa account!");
			console.log("Error", error);
		});
		$('#username').css('border-color', 'grey');
		$('.error_username').hide();
		$('#email').css('border-color', 'grey');
		$('.error_email').hide();
	}

	//Upload hình
	$scope.imageChanged = function (files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/account', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		})
	}



	// $scope index lưu trữ tab hiện tại, ban đầu gán nó = tab1
	$scope.current_tab = 1;

	// Hàm đổi tab
	$scope.changeTab = function (index) {
		$scope.current_tab = index;
	};

	// Hàm kiểm tra có phải tab hiện tại hay không
	// hàm này sẽ trả về true/false và dùng kết hợp
	// với ng-class để active menu
	$scope.isActiveTab = function (index) {
		return index === $scope.current_tab;
	};

	$scope.pager = {
		page: 0,
		account: 12,
		get accounts() {
			var start = this.page * this.account;
			return $scope.accounts.slice(start, start + this.account);
		},
		get count() {
			return Math.ceil(1.0 * $scope.accounts.length / this.account);
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

	$scope.reset();
});