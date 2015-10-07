angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout , $ionicLoading,User) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});
  
  $scope.doLogin = function(email , password){
  	
  	var res = User.authenticate(email , password);
  	res.success(function(data, status, headers, config) {
		if(data.responseCode == 001){
			$ionicLoading.show({ template: data.responseMessage, noBackdrop: true, duration: 2000 });
		}else{
			$ionicLoading.show({ template: 'Logon Successful!', noBackdrop: true, duration: 2000 })	;
		}
	});
	
	res.error(function(data, status, headers, config) {
		$ionicLoading.show({ template: 'Logon failed', noBackdrop: true, duration: 2000 });
	});	
  }

});
