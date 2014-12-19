/**
 * Mobile application edit view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/edit/mobileappEdit.html",
		"app/view/landing/main/mobileapp/edit/mobileappEditController"], function (angular, mobileappEditTemplate,
		mobileappEditController) {

	var mobileappEditModule = angular.module("mobileappEditModule", []);

	mobileappEditModule.controller("mobileappEditController", mobileappEditController);

	mobileappEditModule.constant("mobileappEditView", {
		template: mobileappEditTemplate,
		controller: "mobileappEditController"
	});

	return mobileappEditModule;
});
