/**
 * Profile details view module.
 */
define(["angular", "text!app/view/landing/main/profile/details/profileDetails.html",
		"app/view/landing/main/profile/details/profileDetailsController"], function (angular, profileDetailsTemplate,
		profileDetailsController) {

	var profileDetailsModule = angular.module("profileDetailsModule", []);

	profileDetailsModule.controller("profileDetailsController", profileDetailsController);

	profileDetailsModule.constant("profileDetailsView", {
		template: profileDetailsTemplate,
		controller: "profileDetailsController"
	});

	return profileDetailsModule;
});
