(function() {
	var app = angular.module("base",[]);

		app.controller('BaseController', ['filmServices', function($scope, $http, filmServices) {

		//$scope.imgpath="http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
		$scope.searchTerm="";
		$scope.resp=null;
        
		$scope.discover=function(n){
	
			$http({
				method : 'GET',
				url : 'services/films/'
			})
			.then(function successCallback(response) {
				console.log(response.data);
				$scope.resp = response.data;
				angular.forEach($scope.resp, function(value, key){
					console.log("Boucle :"+value.titre);
					value=filmServices.filmFromBase(value);
//					value.title=value.titre;
//					value.poster_path=value.posterPath;
				});
			}, function errorCallback(response) {

			});
			
	   }

		
		$scope.discover(1);
        
	   $scope.maj=function(n) {
		  
	   };
        
        
	   $scope.srcImg=function(poster_path){
		   console.log("fr")
		   return "http://image.tmdb.org/t/p/w185/"+poster_path;
	   }
	   
	   
	   $scope.detail=function(id){

	   }
	   
	   
	}]);
		
	
 })();

     