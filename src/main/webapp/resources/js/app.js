define([
    'angular',
    'angular-route',
    './controllers/index',
    './services/index',
    'angular-resource'
], function (angular) {
    'use strict';

    return angular.module('app', [
        'app.controllers',
        'app.services',
        'ngRoute',
        'ngResource'
    ]);
});