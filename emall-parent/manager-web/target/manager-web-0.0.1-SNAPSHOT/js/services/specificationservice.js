//app模块的服务层
app.service('specificationservice', function($http) {
	this.findPage = function(page, size, serachEntity) {
		return $http.post('../specification/querypager?page=' + page + '&size=' + size,
				serachEntity);
	}

	this.update = function(entity) {
		return $http.post('../specification/update', entity);
	}

	this.save = function(entity) {
		return $http.post('../specification/add', entity);
	}

	this.queryid = function(id) {
		return $http.get('../specification/queryid?id=' + id);
	}

	this.deletes = function(ids) {
		return $http.get('../specification/delete?ids=' + ids);
	}
})