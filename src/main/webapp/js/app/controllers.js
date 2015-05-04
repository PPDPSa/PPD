'use strict';

function ContactNewController($scope, $location,$http){
    
	$scope.droits = [];
	$scope.droits.push("admin");
	$scope.droits.push("lecteur");
	$scope.droits.push("modificateur");
	alert($scope.droits);
	$scope.submit = function () {
    	$http.post('rest/contact/save',$scope.contact).
    	  success(function(data, status, headers, config) {
    		  
    	  }).
    	  error(function(data, status, headers, config) {
    	    alert("erreur d'enregistrement")
    	  });
    };
    $scope.retour = function(){
    	$location.path('/homepage');
    }
}    

function ContactUpdateController($scope, $location,$http,$rootScope) {
	
	$scope.contact = $rootScope.contact; 
	
	  $scope.modifierContact = function (contact) {
	    	$http.post('rest/contact/update',contact).
	  	  success(function(data, status, headers, config) {
	  	    
	  	  }).
	  	  error(function(data, status, headers, config) {
	  	    alert("erreur d'enregistrement")
	  	  });
	    };
	    $scope.retour = function(){
	    	$location.path('/homepage');
	    }
}

function ContactListController($scope, $location,$http,$rootScope) {
 
	if(!$rootScope.empty){
		$rootScope.empty = true;
	$http.get('rest/contact/all').
    	  success(function(data, status, headers, config) {
    	    $scope.contacts =data;
    	  }).
    	  error(function(data, status, headers, config) {
    	    alert(data);
    	    alert(status);
    	  });
	}	
    $scope.modifier = function (contact) {
    	alert(contact);
    	$rootScope.contact = contact;
        $location.path("/contact/detail")
    }
    
    $scope.retour = function(){
    	$location.path('/homepage');
    }
    
  
}

function redirectController($scope, $location) {
	 
	$scope.gotoCreateContact = function(){
		$location.path('/contact/new')
	}
	$scope.gotoCreateMailType = function(){
		$location.path('/mail/new')
	}
	$scope.gotoCreatePsabox = function(){
		$location.path('/psaBox/new')
	}
	$scope.gotoCreateCampagne = function(){
		$location.path('/campagne/new')
	}
}
