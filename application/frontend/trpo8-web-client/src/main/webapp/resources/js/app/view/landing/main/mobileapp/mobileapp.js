/**
 * Mobile application view module.
 */
define(["angular", "text!app/view/landing/main/mobileapp/mobileapp.html", "app/service/mobileapp/mobileappService",
		"app/view/landing/main/mobileapp/list/mobileappList",
		"app/view/landing/main/mobileapp/details/mobileappDetails",
		"app/view/landing/main/mobileapp/edit/mobileappEdit"], function (angular, mobileappTemplate,
		mobileappServiceModule, mobileappListModule, mobileappDetailsModule, mobileappEditModule) {

	var mobileappModule = angular.module("mobileappModule", ["mobileappServiceModule", "mobileappListModule",
			"mobileappDetailsModule", "mobileappEditModule"]);

	mobileappModule.constant("mobileappView", {
		template: mobileappTemplate
	});

	mobileappModule.config(["$stateProvider", "mobileappListView", "mobileappDetailsView", "mobileappEditView",
			function ($stateProvider, mobileappListView, mobileappDetailsView, mobileappEditView) {

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
				}).state("app.main.mobileapp.edit", {
					url: "/edit/:id",
					views: {
						"": mobileappEditView
					}
				});
			}]);

	return mobileappModule;
});
