// 设置app模块的控制器brandController
app.controller('baseController', function($scope) {

//分页控件配置
$scope.paginationConf = {
	currentPage : 1,
	totalItems : 10,
	itemsPerPage : 10,
	perPageOptions : [ 10, 20, 30, 40, 50 ],
	onChange : function() {
		$scope.reloadList();
	}

}

// 刷新列表
$scope.reloadList = function() {
	$scope.findPage($scope.paginationConf.currentPage,
			$scope.paginationConf.itemsPerPage);
}

$scope.serachEntity = {};

// 删除一
$scope.ids = [];// 勾选的id集合

// 勾选或取消是对集合进行操作
$scope.updateselecttion = function($event, id) {
	if ($event.target.checked) {
		$scope.ids.push(id);// 勾选时添加
	} else {
		var index = $scope.ids.indexOf(id);
		$scope.ids.splice(index, 1);// 参数一 下标 参数二 数量
	}

}

})