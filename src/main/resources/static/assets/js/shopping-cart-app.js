const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {

	/*
	QUẢN LÝ GIỎ HÀNG
	*/
	$scope.cart = {
		items: [],
		//them san pham vao gio hang

		add(id) {
			var item = this.items.find(item => item.food_id == id);
			if (item) {
				item.qty++;
				this.saveToLocalStorage();
			}
			else {
				id = parseInt(id);
				$http.get(`/rest/food/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},

		tang(id) {
			var item = this.items.find(item => item.food_id == id);
			if (item) {			
					item.qty++;
				this.saveToLocalStorage();	
			}
		},
		giam(id) {
			var item = this.items.find(item => item.food_id == id);
			if (item) {
				if(item.qty>1){			
				item.qty--;
				this.saveToLocalStorage();}
			}
		},
		//xoa san pham khoi gio hang
		remove(id) {
			var index = this.items.findIndex(item => item.food_id == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},
		//xoa sach cac mat hang trong gio
		clear() {
			this.items = []
			this.saveToLocalStorage();
		},
		//tinh thanh tien cua 1 san pham
		amt_of(item) { },
		//tinh tong so luong cua mat hang trong gio
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		//tong thanh tien cac mat hang trong gio
		get amount() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},
		get amount1() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty * 0.2, 0);
		},
		//luu gio hang vao local storage
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
		//doc gio hang tu local storage
		loadFromLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.cart.loadFromLocalStorage();
	
	
	$scope.orders = {
		orderdate: new Date(),
		status:1,
		address: "",
		note:"",
		custo: {username_custo:$("#username").text()},
		get orderDetails(){
			return $scope.cart.items.map(item =>{
				return{
					food:{food_id:item.food_id},
					price:item.price,
					quantity:item.qty
				}
			});
		},
		purchase(){
			//thực hiện đặt hàng
			$http.post("/rest/orders", this).then(resp =>{
			alert("đặt hàng thành công");
			$scope.cart.clear();
			location.href = "/home/checkout-detail/"+resp.data.order_id;
		}).catch(error => {
		alert("Đặt hàng lỗi")
		console.log(error)
		})
	}
	}
});


