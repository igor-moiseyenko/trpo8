/**
 * Profile edit view module.
 */
define(["angular", "text!app/view/landing/main/profile/edit/profileEdit.html",
		"app/view/landing/main/profile/edit/profileEditController"], function (angular, profileEditTemplate,
		profileEditController) {

	var profileEditModule = angular.module("profileEditModule", []);

	profileEditModule.controller("profileEditController", profileEditController);

	profileEditModule.constant("profileEditView", {
		template: profileEditTemplate,
		controller: "profileEditController"
	});

	return profileEditModule;
});
