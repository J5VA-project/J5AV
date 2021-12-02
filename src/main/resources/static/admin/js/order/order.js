app.controller("order-ctrl", function($scope, $http){
    $scope.orders = [];
	$scope.form = {};

    $scope.initialize = function(){
        $http.get("/rest/orders").then(resp => {
            $scope.orders = resp.data;
        });
    }

    //khởi đầu
    $scope.initialize();
	$scope.edit = function (order) {
		$scope.form = angular.copy(order);
	}
	
	$scope.pending = function() {
		$http.get(`/rest/orders/status/1`).then(resp => {
			$scope.pendings = resp.data;
		});
	}
	
	$scope.ready = function() {
		$http.get(`/rest/orders/status/2`).then(resp => {
			$scope.readys = resp.data;
		});
	}
	$scope.shipping = function() {
		$http.get(`/rest/orders/status/3`).then(resp => {
			$scope.shippings = resp.data;
		});
	}
	$scope.delivered = function() {
		$http.get(`/rest/orders/status/4`).then(resp => {
			$scope.delivereds = resp.data;
		});
	}
	$scope.cancelled = function() {
		$http.get(`/rest/orders/status/5`).then(resp => {
			$scope.cancelleds = resp.data;
		});
	}

    //cập nhật sản phẩm
    $scope.update = function(){
    	var order = angular.copy($scope.form);
    	$http.patch(`/rest/orders/${order.order_id}`, order).then(resp =>{
    		var index = $scope.orders.findIndex(p => p.order_id == order.order_id);
    		$scope.orders[index] = order;
    		$('.modal-backdrop').hide();
    	}).catch(error =>{  
    		console.log("Error", error);
    	});
    }

    //xóa sản phẩm
    $scope.delete = function(order){
    	$http.delete(`/rest/orders/${order.order_id}`,order).then(resp =>{
    		var index = $scope.orders.findIndex(p => p.order_id == order.order_id);
    		$scope.orders.splice(index,1); //splice xóa một phần tử trong mảng
    		alter("xóa sản phẩm thành công");
		}).catch(error =>{
    		alert("xóa sản phẩm thất bại");
    		console.log("Error", error);
    	});
    }
    
    //view so order
    $scope.total = function() {
		$http.get("/rest/orders/total-order").then(resp => {
				$scope.total = resp.data;
		});
	}
	$scope.totalPending = function() {
		$http.get("/rest/orders/total-status/1").then(resp => {
				$scope.totalPending = resp.data;
		});
	}
	$scope.totalReady = function() {
		$http.get("/rest/orders/total-status/2").then(resp => {
				$scope.totalReady = resp.data;
		});
	}
	$scope.totalshipping = function() {
		$http.get("/rest/orders/total-status/3").then(resp => {
				$scope.totalshipping = resp.data;
		});
	}
	$scope.totalDelivered = function() {
		$http.get("/rest/orders/total-status/4").then(resp => {
				$scope.totalDelivered = resp.data;
		});
	}
	$scope.totalCancel = function() {
		$http.get("/rest/orders/total-status/5").then(resp => {
				$scope.totalCancel = resp.data;
		});
	}
	//khởi đầu
	$scope.total();
	$scope.totalPending();
	$scope.totalReady();
	$scope.totalshipping();
	$scope.totalDelivered();
	$scope.totalCancel();

    
    $scope.pager = {
    	page:0,
    	size:6,
    	get orders(){
    		var start = this.page * this.size;
    		return $scope.orders.slice(start,start + this.size);
    	},
    	get count(){
    		return Math.ceil(1.0 * $scope.orders.length / this.size)
    	},
    	first(){
    		this.page=0;
    	},
    	prev(){
    		this.page--;
    		if(this.page<0){
    			this.last();
    		}
    	},
    	next(){
    		this.page++;
    		if(this.page>= this.count){
    			this.first();
    		}
    	},
    	last(){
    		this.page= this.count-1;
    	}
    }
});