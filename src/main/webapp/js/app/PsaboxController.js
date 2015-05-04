function PsaboxNewController($scope, $location,$http,$rootScope){
	if(!$rootScope.contacts){
	$http.get('rest/contact/all').
    	  success(function(data, status, headers, config) {
    	    $scope.contacts = data;
    	  }).
    	  error(function(data, status, headers, config) {
    	    alert(data);
    	    alert(status);
    	  });
	}
	
	$scope.submit = function () {
		$scope.psaBox.etapesDone = [];
    	$http.post('rest/psabox/save',$scope.psaBox).
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

function PsaboxUpdateController($scope, $location,$http,$rootScope) {
	
	if($rootScope.psaBox){
	$scope.psaBox = $rootScope.psaBox; 
	}
	  $scope.modifier = function (psaBox) {
	    	$http.post('rest/psabox/update',psaBox).
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

function PsaboxListController($scope, $location,$http,$rootScope) {
	$http.get('rest/psabox/all').
    	  success(function(data, status, headers, config) {
    	    $scope.psaBoxs =data;
    	  }).
    	  error(function(data, status, headers, config) {
    	    alert(data);
    	    alert(status);
    	  });
	
    $scope.modifier = function (psaBox) {
    	$rootScope.psaBox = psaBox;
        $location.path("/psaBox/detail")
    }
    
    $scope.retour = function(){
    	$location.path('/homepage');
    }
}
