/**
 * Mobile application details view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/details/mobileappDetails.html",
		"app/view/landing/main/mobileapp/details/mobileappDetailsController"], function (angular,
		mobileappDetailsTemplate, mobileappDetailsController) {

	var mobileappDetailsModule = angular.module("mobileappDetailsModule", []);

	mobileappDetailsModule.controller("mobileappDetailsController", mobileappDetailsController);

	mobileappDetailsModule.constant("mobileappDetailsView", {
		template: mobileappDetailsTemplate,
		controller: "mobileappDetailsController"
	});

	return mobileappDetailsModule;
});
