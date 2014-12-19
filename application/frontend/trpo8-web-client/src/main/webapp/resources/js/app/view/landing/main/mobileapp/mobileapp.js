/**
 * Mobile application view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/mobileapp.html", "app/service/mobileapp/mobileappService",
		"app/view/landing/main/mobileapp/list/mobileappList"], function (angular, mobileappTemplate,
		mobileappServiceModule, mobileappListModule) {

	var mobileappModule = angular.module("mobileappModule", ["mobileappServiceModule", "mobileappListModule"]);

	mobileappModule.constant("mobileappView", {
		template: mobileappTemplate
	});

	mobileappModule.config(["$stateProvider", "mobileappListView", function ($stateProvider, mobileappListView) {

		$stateProvider.state("app.main.mobileapp.list", {
			url: "/list",
			views: {
				"": mobileappListView
			}
		});
	}]);

	return mobileappModule;
});
