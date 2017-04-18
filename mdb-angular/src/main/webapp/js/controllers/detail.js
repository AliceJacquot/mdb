(function() {
	var app = angular.module("detail",[]);

		app.controller('DetailController', ['filmServices',function($scope, $http,  $routeParams, $rootScope, filmServices) {


	    // $scope.id = $routeParams.id;
	    $scope.film=$rootScope.film;
	    var stop=0;
	   
	    var init=function(){
	    	$http.get("https://api.themoviedb.org/3/movie/550?api_key=ab353a44dc07496c08cc90436fca0e27")
	    	.then(function(body){
	    		console.log(body)
	    		$scope.film = body.data;
	    		$rootScope.film=$scope.film;
	    	})
	    	.catch(function(error){
	    	});
	    };
	    	    
	    var getData=function(){
	    	console.log($scope.film);
	    	if (!$rootScope.film){
	    	    init();	    		
	    	}
	    	else {
	    		$scope.film=$rootScope.film;
	    	}
	    };
	     getData();
	     
	     var formatteFilm=function(film){
	    	 var f={};
	    	 f.titre=film.title;
	    	 //f.description= film.overview;
	    	 f.id=film.id;
	    	 f.posterPath=film.poster_path;
	    	 return f;
	     }
	     
	     $scope.saveBase=function(){
	    	 if(!stop){
	    		 console.log("sauvegarde du film en base")
	    		 stop=!stop;
	    		 var f =formatteFilm($scope.film);
	    		 $http({
	    			 method : 'POST',
	    			 url : 'services/savefilm/',
	    			 data : f
	    		 });
	    	 }
	    	 
	     }; 
	     

	}]);
	
 })();

     