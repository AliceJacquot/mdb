(function() {
	var app = angular.module("mdb", [ "film", "ngRoute", "detail", "base" ]);

	app.controller("rien", function() {
		console.log("rien");
		//$rootScope.film=null;
	});

	app.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "templates/menu.html",
			controller : "rien"
		}).when("/search", {
			templateUrl : "templates/search.html",
			controller : "SearchController"
		}).when("/base", {
			templateUrl : "templates/search.html",
			controller : "BaseController"
		}).when("/filmex", {
			templateUrl : "templates/detail.html",
			controller : "DetailController"
		})
		.when("/film", {
			templateUrl : "templates/detail.html",
			controller : "DetailController"
		})
		.otherwise({
			redirectTo : "/"
		})
	});
})();