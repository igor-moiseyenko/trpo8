/**
 * Main view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "text!app/view/landing/main/main.html", "app/view/landing/main/profile/profile",
		"app/view/landing/main/mobileapp/mobileapp"], function (angular, mainTemplate, profileModule, mobileappModule) {

	var mainModule = angular.module("mainModule", ["profileModule", "mobileappModule"]);

	mainModule.config(["$stateProvider", "profileView", "mobileappView",
			function ($stateProvider, profileView, mobileappView) {

				$stateProvider.state("app.main.profile", {
					url: "/profile",
					views: {
						"": profileView
					}
				}).state("app.main.mobileapp", {
					url: "/mobileapp",
					views: {
						"": mobileappView
					}
				});
			}]);

	mainModule.constant("mainView", {
		template: mainTemplate
	});

	return mainModule;
});
