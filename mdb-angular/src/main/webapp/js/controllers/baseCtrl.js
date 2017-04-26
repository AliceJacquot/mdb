(function() {
	var app = angular.module("base",[]);

		app.controller('BaseController', function($scope, $http) {

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
					//value=filmServices.filmFromBase(value);
					value.title=value.titre;
					value.poster_path="http://image.tmdb.org/t/p/w185/"+value.posterPath;
				});
			}, function errorCallback(response) {

			});
			
	   }

		
		$scope.discover(1);
        
	   $scope.maj=function(n) {
		  
	   };
        
        
	   $scope.srcImg=function(poster_path){
		   console.log("fr")
		   return poster_path;
	   }
	   
	   
	   $scope.detail=function(film){
		   console.log("film detail :"+film.title);
		   $rootScope.film.id=film.id;
		   return "#/filmex";
	   }
	   

	   
	var stop=false;
//	var filmServices= {}; 
//		
//		filmServices.filmForBase=function(film){
//	   	 	var f={};
//	   	 	f.titre=film.title;
//	   	 // f.description= film.overview;
//	   	 	f.id=film.id;
//	   	 	f.posterPath=film.poster_path;
//	   	 	return f;
//	    };
//	    
//		filmServices.filmFromBase=function(film){
//	   	 	var f={};
//	   	 	f.title=film.titre;
//	   	    f.overview= film.description;
//	   	 	f.id=film.id;
//	   	 	f.poster_path=film.posterPath;
//	   	 	return f;
//	    };
//	    
//		filmServices.saveBase=function(film){
//	   	 if(!stop){
//	   		 console.log("sauvegarde du film en base")
//	   		 stop=!stop;
//	   		 var f =formatteFilm(film);
//	   		 $http({
//	   			 method : 'POST',
//	   			 url : 'services/savefilm/',
//	   			 data : f
//	   		 });
//	   	 }
//	    };
		
	   
	   
	});
		
	
 })();

     