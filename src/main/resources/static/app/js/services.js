(function(angular) {
	var ItemFactory = function($resource) {
		return {
            items: $resource('/merchandise/items/:id', {id: '@id'}),
            featured: $resource('/merchandise/items/featured'),
          };
	};

	ItemFactory.$inject = [ '$resource'];

	angular.module("myApp.services").factory("Item", ItemFactory);
}(angular));