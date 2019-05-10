//app模块的服务层
app.service('brandService', function($http) {
	this.findPage = function(page, size, serachEntity) {
		return $http.post('../brand/querypager?page=' + page + '&size=' + size,
				serachEntity);
	}

	this.update = function(entity) {
		return $http.post('../brand/update', entity);
	}

	this.save = function(entity) {
		return $http.post('../brand/add', entity);
	}

	this.queryid = function(id) {
		return $http.get('../brand/queryid?id=' + id);
	}

	this.deletes = function(ids) {
		return $http.get('../brand/delete?ids=' + ids);
	}
})