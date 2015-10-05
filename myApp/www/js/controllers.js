angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout , $ionicLoading,User) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});
  
  $scope.doLogin = function(){
  	
  	var res = User.authenticate();
  	res.success(function(data, status, headers, config) {
$ionicLoading.show({ template: 'Logon Successful!', noBackdrop: true, duration: 2000 });
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});	
  }

});
