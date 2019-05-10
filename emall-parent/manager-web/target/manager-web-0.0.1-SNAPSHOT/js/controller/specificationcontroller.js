// 设置app模块的控制器specificationController
app.controller('specificationController', function($scope, specificationservice, $controller) {

	$controller('baseController',{$scope:$scope})
	
	// 分页
	$scope.findPage = function(page, size) {
		specificationservice.findPage(page, size, $scope.serachEntity).success(
				function(response) {
					$scope.list = response.data.rows;// 显示当前行数
					$scope.paginationConf.totalItems = response.data.total;// 显示当前行数
				}

		)

	}

/*	// 新增与删除
	$scope.save = function() {
		var obj = null
		if ($scope.entity.id != null) {
			obj = specificationService.update($scope.entity);
		} else {
			obj = specificationService.save($scope.entity);
			
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
		specificationService.queryid(id).success(function(response) {
			$scope.entity = response;

		})
	}

	// 删除二
	$scope.deletes = function() {
		if (confirm("确定删除吗？")) {
			specificationService.deletes($scope.ids).success(function(response) {
				if (response.status == 200) {
					$scope.reloadList();
				} else {
					alert(response.msg);
				}

			}

			)

		}
	}*/

})