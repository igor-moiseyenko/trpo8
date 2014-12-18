/**
 * Login view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/service/account/accountService", "app/view/login/loginController",
		"text!app/view/login/login.html"], function (angular, accountServiceModule, loginController, loginTemplate) {

	var loginModule = angular.module("loginModule", ["accountServiceModule"]);

	loginModule.controller("loginController", loginController);

	loginModule.constant("loginView", {
		template: loginTemplate,
		controller: "loginController"
	});

	return loginModule;
});
