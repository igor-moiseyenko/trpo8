/**
 * Register view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/service/profile/profileService", "app/view/register/registerController",
		"text!app/view/register/register.html"], function (angular, profileServiceModule, registerController,
		registerTemplate) {

	var registerModule = angular.module("registerModule", ["profileServiceModule"]);

	registerModule.controller("registerController", registerController);

	registerModule.constant("registerView", {
		template: registerTemplate,
		controller: "registerController"
	});

	return registerModule;
});
