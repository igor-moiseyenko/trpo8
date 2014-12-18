/**
 * Main view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/view/landing/main/profile/profile", "text!app/view/landing/main/main.html"], function (angular,
		profileModule, mainTemplate) {

	var mainModule = angular.module("mainModule", ["profileModule"]);

	mainModule.config(["$stateProvider", "profileView", function ($stateProvider, profileView) {

		$stateProvider.state("app.main.profile", {
			url: "/profile",
			views: {
				"": profileView
			}
		});
	}]);

	mainModule.constant("mainView", {
		template: mainTemplate
	});

	return mainModule;
});
