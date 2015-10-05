/**
 * 
 */
angular.module('starter.services', []).
  factory('User', function($http) {

    var user = {};

	
return {
    authenticate : function() {
   	
		var dataObj = $.param({
            json: JSON.stringify({
                email : "test@abc.com",
				password : "password"
            })
    });
      return $http({
        method: "POST", 
        url: 'http://ec2-52-29-21-51.eu-central-1.compute.amazonaws.com:8080/UserService/rest/login/',
        data: dataObj,
        headers: {'Content-Type': 'application/json' , 'Accept' : 'application/json'}
      });
      
    }
};
    
  });