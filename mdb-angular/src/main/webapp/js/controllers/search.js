(function() {
	var app = angular.module("film",[]);

		app.controller('SearchController', function($scope, $http, $rootScope) {

		//$scope.imgpath="http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
		$scope.searchTerm="";
		$scope.resp=null;
        
		$scope.discover=function(n){
			$http.get("https://api.themoviedb.org/3/discover/movie?api_key=ab353a44dc07496c08cc90436fca0e27&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page="+n)
			.then(function(body){
				console.log(body)
				$scope.resp = body.data.results;
			})
			.catch(function(error){
			});
			
//			$http({
//				method : 'GET',
//				url : 'services/film/'
//			})
//			.then(function successCallback(response) {
//				console.log(response.data);
//				self.produit = response.data;
//			}, function errorCallback(response) {
//
//			});
			
	   }
	   
		$scope.discover(1);
        
	   $scope.maj=function(n) {
		   if ($scope.searchTerm){
		   $http.get("https://api.themoviedb.org/3/search/movie?api_key=ab353a44dc07496c08cc90436fca0e27&query="+$scope.searchTerm+"&page="+n)
		   .then(function(body){
			   console.log(body)
			   $scope.resp = body.data.results;
		   })
		   .catch(function(error){
            
		   });
		   }
		   else {
			   console.log("discover"+n);
			   $scope.discover(n);
		   }
	   };
        
        
	   $scope.srcImg=function(poster_path){
		   console.log("fr")
		   return "http://image.tmdb.org/t/p/w185/"+poster_path;
	   }
	   
	   
	   $scope.detail=function(film){
		   console.log("film detail :"+film.title);
		   $rootScope.film=film;
		   return "#/filmex";
	   }
	   
  
   
	   
	});
		
	
 })();

     