 
function MailNewController($scope,$http,$rootScope,$location){
	 $scope.hidden = true;	
	 $scope.uploadOk =  true;	
	 $scope.sauver = function(){
	
	$http.post('rest/mail/saveMail',$scope.mail).
	  success(function(data, status, headers, config) {
		  $rootScope.nom = $scope.mail.nom;
		  $scope.hidden = false;
	  }).
	  error(function(data, status, headers, config) {
	    alert("erreur d'enregistrement")
	  });
		}
		
	
	$scope.uploadFile = function(){
        var file = $scope.myFile;
        var uploadUrl = "rest/mail/saveFile";
        var fd = new FormData();
        fd.append('file', file);
        fd.append('nom', $rootScope.nom);
        $http.post(uploadUrl, fd,{
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        	$scope.uploadOk = false; 
        })
        .error(function(){
        });
    };
    
    $scope.retour = function(){
    	$location.path('/homepage');
    }
}
	




function MailListController($scope, $location,$http,$rootScope) {
	$http.get('rest/mail/all').
    	  success(function(data, status, headers, config) {
    	    $scope.mails =data;
    	  }).
    	  error(function(data, status, headers, config) {
    	    alert(data);
    	    alert(status);
    	  });    
	 $scope.retour = function(){
	    	$location.path('/homepage');
	    }
}