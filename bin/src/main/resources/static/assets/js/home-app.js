
const app = angular.module("home-app",[]);
app.controller("home-ctrl",function($scope,$http){
	/* QUẢN LÝ GIỎ HÀNG*/
	$scope.cart = {
        items: [],
        // add new product
        add(id) {
            var item = this.items.find(item => item.id == id);
			alert("Đã thêm vào giỏ hàng")
            if (item) { //neu co sp r thi tang sl them 1
                item.qty++;
                this.saveToLocalStorage();
            } else {
                //Chua co thi tai sp tren sẻver thông qua API
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
       //Luu vao danh sach cac hang da chon
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
		//Xóa sản phẩm khỏi giỏ hàng
		remove(id){
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
		},
		//Xóa sạch các mặt hàng trong giỏ
		clear(){
			this.items =[]
			this.saveToLocalStorage();
		},
		//Tính thành tiền cua 1 sản phẩm
		amt_of(item){},
		//Tính tổng số lượng các mặt hàng trong giỏ
		get count(){
			return this.items
			.map(item => item.qty)
			.reduce((total,qty)=> total +=qty,0);
		},
		//Tổng thành tiền các mặt hàng trong giỏ
		get amount(){
			return this.items
			.map(item => item.qty * item.giamGia)
			.reduce((total,qty) => total += qty,0);
		},
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart",json);
		},
		//Đọc giỏ hàng từ local storage
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.cart.loadFromLocalStorage();
	
		
	//Whistlist
	$scope.list = {
        items: [],
        // add new product
        add(id) {
            var item = this.items.find(item => item.id == id);
			alert("Đã thêm vào yêu thích")
            if (item) { //neu co sp r thi tang sl them 1
                item.qty++;
                this.saveToLocalStorage();
            } else {
                //Chua co thi tai sp tren sẻver thông qua API
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
       //Luu vao danh sach cac hang da chon
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
		//Xóa sản phẩm khỏi giỏ hàng
		remove(id){
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
		},
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("list",json);
		},
		//Đọc giỏ hàng từ local storage
		loadFromLocalStorage(){
			var json = localStorage.getItem("list");
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.list.loadFromLocalStorage();
	
	$scope.order = {
		createDate: new Date(),
		address: "",
		account: {tenTK:$("#username").text()},
		get orderDetails(){
			return $scope.cart.items.map(item =>{
				return{
					product:{id:item.id},
					price:item.giamGia,
					quantity:item.qty
				}
			});
		},
		purchase(){
			var order = angular.copy(this);
			//thực hiện đặt hàng
			$http.post("/rest/orders", order).then(resp =>{
			alert("đặt hàng thành công");
			$scope.cart.clear();
			location.href = "/order/detail/"+resp.data.id;
		}).catch(error => {
		alert("Đặt hàng lỗi")
		console.log(error)
		})
	}
	}
});