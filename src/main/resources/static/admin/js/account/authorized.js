app.controller("authorized-ctrl", function($scope, $http) {

	$http.get("/rest/authorities").then(resp => {
		$scope.db = resp.data;
		console.log(resp.data);
	})

	$scope.index_of = function(username, role) {
		return $scope.db.authorities
			.findIndex(a => a.authorize.username == username && a.role.role_id == role)
	}

	$scope.update = function(username, role) {
		alert(role);
		var index = $scope.index_of(username, role);
		if (index >= 0) {
			var id = $scope.db.authorities[index].authorized_id;
			$http.delete(`/rest/authorities/${id}`).then(resp => {
				$scope.db.authorities.splice(index, 1);
			})
		}
		else {
			var authority = {
				authorize: { username: username },
				role: { role_id: role }
			};
			$http.post('/rest/authorities', authority).then(resp => {
				$scope.db.authorities.push(resp.data);
			});
		}
	}
});