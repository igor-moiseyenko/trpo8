/**
 * Profile view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/service/account/accountService", "app/service/profile/profileService",
		"app/view/landing/main/profile/profileController", "text!app/view/landing/main/profile/profile.html"],
	function (angular, accountServiceModule, profileServiceModule, profileController, profileTemplate) {

		var profileModule = angular.module("profileModule", ["accountServiceModule", "profileServiceModule"]);

		profileModule.controller("profileController", profileController);

		profileModule.constant("profileView", {
			template: profileTemplate,
			controller: "profileController"
		});

		return profileModule;
	});
