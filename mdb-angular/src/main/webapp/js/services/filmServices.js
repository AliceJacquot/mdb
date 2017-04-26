(function() {
	var app = angular.module("filmServices",[]);

	app.service('filmServices', function () { 
		
		
		var stop=false;
		
		filmServices.filmForBase=function(film){
	   	 	var f={};
	   	 	f.titre=film.title;
	   	 // f.description= film.overview;
	   	 	f.id=film.id;
	   	 	f.posterPath=film.poster_path;
	   	 	return f;
	    };
	    
		filmServices.filmFromBase=function(film){
	   	 	var f={};
	   	 	f.title=film.titre;
	   	    f.overview= film.description;
	   	 	f.id=film.id;
	   	 	f.poster_path=film.posterPath;
	   	 	return f;
	    };
	    
		filmServices.saveBase=function(film){
	   	 if(!stop){
	   		 console.log("sauvegarde du film en base")
	   		 stop=!stop;
	   		 var f =formatteFilm(film);
	   		 $http({
	   			 method : 'POST',
	   			 url : 'services/savefilm/',
	   			 data : f
	   		 });
	   	 }
	    };
		
		
	})
	
 })();

     