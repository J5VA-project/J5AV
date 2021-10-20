app.controller("order-list-ctrl", function($scope, $http){
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function(){
        //load products
        $http.get("/rest/food").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })  
        });
        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
        //load group cate
        $http.get("/rest/groupprod").then(resp => {
            $scope.gprod = resp.data;
        });
    }

    //khởi đầu
    $scope.initialize();


    //xóa form
    $scope.reset = function(){
		$scope.form = {
			createDate: new Date(),
			hinhAnh:'',
			trangThai: true,
		};
    }

    //hiển thị lên form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //thêm sản phẩm mới
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/products`, item).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới thành công");
		}).catch(error =>{
			alert("Thêm mới thất bại");
			console.log("Error", error);
		});
    }

    //cập nhật sản phẩm
    $scope.update = function(){
    	var item = angular.copy($scope.form);
    	$http.put(`/rest/products/${item.id}`, item).then(resp =>{
    		var index = $scope.items.findIndex(p => p.id == item.id);
    		$scope.items[index] = item;
    		alert("Cập nhật sản phẩm thất bại");
    	}).catch(error =>{
    		alter("cập nhật sản phẩm thành công");
    		console.log("Error", error);
    	});
    }

    //xóa sản phẩm
    $scope.delete = function(item){
    	$http.delete(`/rest/products/${item.id}`,item).then(resp =>{
    		var index = $scope.items.findIndex(p => p.id == item.id);
    		$scope.items.splice(index,1); //splice xóa một phần tử trong mảng
    		$scope.reset();
    		alert("xóa sản phẩm thất bại");
		}).catch(error =>{
    		alter("xóa sản phẩm thành công");
    		console.log("Error", error);
    	});
    }

    //Upload image
    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/product', data,{
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.hinhAnh = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        })
    }
    
    $scope.pager = {
    	page:0,
    	size:10,
    	get items(){
    		var start = this.page * this.size;
    		return $scope.items.slice(start,start + this.size);
    	},
    	get count(){
    		return Math.ceil(1.0 * $scope.items.length / this.size)
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