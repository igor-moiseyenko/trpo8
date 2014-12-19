/**
 * Mobile application view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/mobileapp.html", "app/service/mobileapp/mobileappService",
		"app/view/landing/main/mobileapp/list/mobileappList",
		"app/view/landing/main/mobileapp/details/mobileappDetails"], function (angular, mobileappTemplate,
		mobileappServiceModule, mobileappListModule, mobileappDetailsModule) {

	var mobileappModule = angular.module("mobileappModule", ["mobileappServiceModule", "mobileappListModule",
			"mobileappDetailsModule"]);

	mobileappModule.constant("mobileappView", {
		template: mobileappTemplate
	});

	mobileappModule.config(["$stateProvider", "mobileappListView", "mobileappDetailsView",
			function ($stateProvider, mobileappListView, mobileappDetailsView) {

				$stateProvider.state("app.main.mobileapp.list", {
					url: "/list",
					views: {
						"": mobileappListView
					}
				}).state("app.main.mobileapp.details", {
					url: "/:id",
					views: {
						"": mobileappDetailsView
					}
				});
			}]);

	return mobileappModule;
});
