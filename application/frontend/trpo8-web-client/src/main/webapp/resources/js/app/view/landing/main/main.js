/**
 * Main view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "text!app/view/landing/main/main.html", "app/view/landing/main/profile/profile",
		"app/view/landing/main/mobileapp/mobileapp", "app/view/landing/main/cart/cart"], function (angular,
		mainTemplate, profileModule, mobileappModule, cartModule) {

	var mainModule = angular.module("mainModule", ["profileModule", "mobileappModule", "cartModule"]);

	mainModule.config(["$stateProvider", "profileView", "mobileappView", "cartView",
			function ($stateProvider, profileView, mobileappView, cartView) {

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
				}).state("app.main.cart", {
					url: "/cart",
					views: {
						"": cartView
					}
				});
			}]);

	mainModule.constant("mainView", {
		template: mainTemplate
	});

	return mainModule;
});
