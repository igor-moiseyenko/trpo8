/**
 * Mobile application list view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/list/mobileappList.html",
		"app/view/landing/main/mobileapp/list/mobileappListController"], function (angular, mobileappListTemplate,
		mobileappListController) {

	var mobileappListModule = angular.module("mobileappListModule", []);

	mobileappListModule.controller("mobileappListController", mobileappListController);

	mobileappListModule.constant("mobileappListView", {
		template: mobileappListTemplate,
		controller: "mobileappListController"
	});

	return mobileappListModule;
});
