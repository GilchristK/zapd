'use strict';

angular.module('zapd',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/PersonWithDisabilities',{templateUrl:'views/PersonWithDisability/search.html',controller:'SearchPersonWithDisabilityController'})
      .when('/PersonWithDisabilities/new',{templateUrl:'views/PersonWithDisability/detail.html',controller:'NewPersonWithDisabilityController'})
      .when('/PersonWithDisabilities/edit/:PersonWithDisabilityId',{templateUrl:'views/PersonWithDisability/detail.html',controller:'EditPersonWithDisabilityController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
