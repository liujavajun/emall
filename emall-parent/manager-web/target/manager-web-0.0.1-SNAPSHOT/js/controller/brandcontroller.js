// 设置app模块的控制器brandController
app.controller('brandController', function($scope, brandService, $controller) {

	$controller('baseController',{$scope:$scope})
	
	// 分页
	$scope.findPage = function(page, size) {
		brandService.findPage(page, size, $scope.serachEntity).success(
				function(response) {
					$scope.list = response.data.rows;// 显示当前行数
					$scope.paginationConf.totalItems = response.data.total;// 显示当前行数
				}

		)

	}

	// 新增与删除
	$scope.save = function() {
		var obj = null
		if ($scope.entity.id != null) {
			obj = brandService.update($scope.entity);
		} else {
			obj = brandService.save($scope.entity);
			
		}

		obj.success(function(response) {
			if (response.status == 200) {
				$scope.reloadList();
			} else {
				alert(response.msg);
			}

		})
	}

	// 修改前查询
	$scope.queryid = function(id) {
		brandService.queryid(id).success(function(response) {
			$scope.entity = response;

		})
	}

	// 删除二
	$scope.deletes = function() {
		if (confirm("确定删除吗？")) {
			brandService.deletes($scope.ids).success(function(response) {
				if (response.status == 200) {
					$scope.reloadList();
				} else {
					alert(response.msg);
				}

			}

			)

		}
	}

})