(function() {
	var app = angular.module("produit", []);

	this.produitCtrl = function($http) {
		var self = this;

		self.produits = [];

		self.produit = null;
		self.titres = [];
		self.panierVisible = false;

		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/produit/'
			}).then(function successCallback(response) {
				self.produits = response.data;
			}, function errorCallback(response) {

			});
		};

		self.add = function() {

			self.produit = {};

		};

		self.save = function() {
			if (self.produit.id) {
				$http({
					method : 'PUT',
					url : 'services/produit/' + self.produit.id,
					data : self.produit
				}).then(function successCallback(response) {
					self.list();
					self.produit = null;
				}, function errorCallback(response) {

				});
			} else {
				$http({
					method : 'POST',
					url : 'services/produit/',
					data : self.produit
				}).then(function successCallback(response) {
					self.list();
					self.produit = null;
				}, function errorCallback(response) {

				});
			}

		};

		self.edit = function(id) {

			$http({
				method : 'GET',
				url : 'services/produit/' + id
			}).then(function successCallback(response) {
				self.produit = response.data;
			}, function errorCallback(response) {

			});

		};

		self.remove = function(id) {
			$http({
				method : 'DELETE',
				url : 'services/produit/' + id
			}).then(function successCallback(response) {
				self.list();
			}, function errorCallback(response) {

			});
		};

		self.voirPanier = function() {
			self.panierVisible = true;
		}

		
		self.prodPourCat= function (categorie){
			//produits = findbycat(categorie.id);
			//"/produitparcat/{id}"
			$http({
				method : 'GET',
				url : 'services/produitparcat/'+categorie.id
			}).then(function successCallback(response) {
				self.produits = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.list();
	};

	app.directive("produit", function() {
		return {
			restrict : 'E',
			templateUrl : 'produit.html',
			controller : produitCtrl,
			controllerAs : "produitCtrl"
		};

	}

	);

})();