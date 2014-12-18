/**
 * Navigation view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/view/landing/navigation/navigationController",
		"text!app/view/landing/navigation/navigation.html"], function (angular, navigationController,
		navigationTemplate) {

	var navigationModule = angular.module("navigationModule", []);

	navigationModule.controller("navigationController", navigationController);

	navigationModule.constant("navigationView", {
		template: navigationTemplate,
		controller: "navigationController"
	});

	return navigationModule;
});
