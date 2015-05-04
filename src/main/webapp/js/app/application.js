'use strict';

var todoApp = angular.module('todoApp', []).
        config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
            when('/contact/new', {templateUrl:'views/Contact-new.html', controller:ContactNewController}).
            when('/contact/detail', {templateUrl:'views/Contact-detail.html', controller:ContactUpdateController}).
            when('/contact/list', {templateUrl:'views/Contact-list.html', controller:ContactListController}).
            when('/psaBox/new', {templateUrl:'views/Psabox-new.html', controller:PsaboxNewController}).
            when('/psaBox/detail', {templateUrl:'views/Psabox-detail.html', controller:PsaboxUpdateController}).
            when('/psaBox/list', {templateUrl:'views/Psabox-list.html', controller:PsaboxListController}).
            when('/mail/list', {templateUrl:'views/MailType-list.html', controller:MailListController}).
            when('/mail/new', {templateUrl:'views/MailType-new.html', controller:MailNewController}).
            when('/campagne/new', {templateUrl:'views/Campagne-new.html', controller:CampagneNewController}).
            when('/campagne/list', {templateUrl:'views/Campagne-list.html', controller:campagneListController}).
            when('/campagne/detail', {templateUrl:'views/Campagne-detail.html', controller:campagneDetailController}).
            when('/homepage', {templateUrl:'views/mainPage.html', controller:redirectController}).
            otherwise({redirectTo:'/homepage'});
}]);


todoApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


