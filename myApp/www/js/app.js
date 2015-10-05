// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider,$httpProvider) {
  $stateProvider

    .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html',
    controller: 'AppCtrl'
  })
   .state('app.logIn', {
  	url: '/logIn',
  	views: {
    	'menuContent': {
          templateUrl: 'templates/login.html',
          controller: 'AppCtrl'
        }
      }
    })
  .state('app.ourList', {
  	url: '/ourList',
  	views: {
    	'menuContent': {
          templateUrl: 'templates/ourList.html'
        }
      }
    })
	.state('app.articles', {
	  url: '/articles',
	  views: {
	    'menuContent': {
	      templateUrl: 'templates/articles.html'
	    }
	  }
	})
	.state('app.categories', {
	  url: '/categories',
	  views: {
	    'menuContent': {
	      templateUrl: 'templates/categories.html'
	    }
	  }
	})
	.state('app.myProfile', {
	  url: '/myProfile',
	  views: {
	    'menuContent': {
	      templateUrl: 'templates/myProfile.html'
	    }
	  }
	})
	.state('app.settings', {
	  url: '/settings',
	  views: {
	    'menuContent': {
	      templateUrl: 'templates/settings.html'
	    }
	  }
	});

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/app/ourList');
  $httpProvider.defaults.useXDomain = true;
delete $httpProvider.defaults.headers.common['X-Requested-With'];

});
