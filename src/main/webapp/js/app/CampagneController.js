function CampagneNewController($scope, $location, $http, $rootScope) {

	if (!$rootScope.psaboxs) {
		$scope.campagne = {};
		$scope.campagne.etapes = [];
		$http.get('rest/psabox/all').success(
				function(data, status, headers, config) {
					$scope.Allpsaboxs = data;
				}).error(function(data, status, headers, config) {
			alert(data);
			alert(status);
		});
	}

	if (!$rootScope.mails) {
		$http.get('rest/mail/all').success(
				function(data, status, headers, config) {
					$scope.mails = data;
				}).error(function(data, status, headers, config) {
			alert(data);
			alert(status);
		});
	}
	if (!$rootScope.ttEtapes) {
		$http.get('rest/etape/all').success(
				function(data, status, headers, config) {
					$scope.ttEtapes = data;
					if ($scope.ttEtapes == "") {
						$scope.ttEtapes = [];
					}
				}).error(function(data, status, headers, config) {
			alert(data);
			alert(status);
		});
	}

	$scope.submit = function() {
		$http.post('rest/campagne/save', $scope.campagne).success(
				function(data, status, headers, config) {

				}).error(function(data, status, headers, config) {
			alert("erreur d'enregistrement")
		});
	};

	$scope.addEtapes = function() {
		var act = {};

		if ($scope.etapeSelected != "" && $scope.mail != "") {
			act.priorite = $scope.numero;
			act.mailType = $scope.mail;
			act.nom = $scope.etapeSelected;
			$scope.campagne.etapes.push(act);
			$scope.ttEtapes.push(act.nom)
			alert($scope.ttEtapes)
			$scope.numero = "";
			$scope.mail = "";
			$scope.etapeSelected = "";
			// alert($scope.campagne.etapes);
		}
	}

	$scope.retour = function() {
		$location.path('/homepage');
	}
}

function campagneListController($scope, $location, $http, $rootScope) {
	$http.get('rest/campagne/all').success(
			function(data, status, headers, config) {
				$scope.campagnes = data;
			}).error(function(data, status, headers, config) {
		alert(data);
		alert(status);
	});
	$scope.retour = function() {
		$location.path('/homepage');
	}

	$scope.detail = function(campagne) {
		$rootScope.detail = campagne;
		$location.path('/campagne/detail');
	}
}

function campagneDetailController($scope, $location, $http, $rootScope) {

	$scope.campagne = $rootScope.detail;
	$scope.updateEtape = function(action,nouvelleEtape) {
	
			var isDone = false;
			var i;
			alert(nouvelleEtape);
			alert(nouvelleEtape.priorite);
			if (nouvelleEtape.priorite == null) {
				isDone = true;
			} else {
				for (i = 0; i < action.psaBox.etapeDone.length; i++) {
					if (angular.equals(action.psaBox.etapeDone[i].nom,
							nouvelleEtape)) {
						alert(action.psaBox.etapeDone[i].nom)
						isDone = true;
					}
				}
			}
			if (isDone == false) {
				alert("les prerequis n'ont pas ete realiser"
						+ nouvelleEtape.numero)
			}
			if (isDone == true) {
				action.encours = nouvelleEtape;
				$http.post('rest/action/save', action).success(
						function(data, status, headers, config) {
							$scope.campagnes = data;
						}).error(function(data, status, headers, config) {
					alert(data);
					alert(status);
				});
				$scope.retour = function() {
					$location.path('/homepage');
				}
			}
	
	}
	$scope.retour = function() {
		$location.path('/homepage');
	}
}
