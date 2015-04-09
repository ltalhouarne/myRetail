(function(angular) {
  var AppController = function($scope, Item) {
    Item.items.query(function(response) {
      $scope.items = response ? response : [];
      var categoryArray = [];
      //Populate an array of categories
      for (var i = 0, j = 0; i < $scope.items.length; i++) {
    	  if(categoryArray.indexOf($scope.items[i].merchandiseCategory) < 0) {
    		  categoryArray[j++] = $scope.items[i].merchandiseCategory;
    	  }
      }
      $scope.categories = categoryArray;
    });
    
    //Default category
    $scope.category="All";
    
    //Category filter for array of merchandise items
    $scope.customFilter = function (data) {
        if($scope.category==="All") return true;
        if (data.merchandiseCategory.toString().indexOf($scope.category)>-1) return true;
        return false;
    };
    
    //Featured item
    Item.featured.get(function(responseFeatured){
      $scope.featured = responseFeatured;
    });
    
    //Default cart count
    $scope.cartCount = 0;
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));