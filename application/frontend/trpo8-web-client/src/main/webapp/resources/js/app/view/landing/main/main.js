/**
 * Main view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "text!app/view/landing/main/main.html", "app/view/landing/main/profile/profile",
		"app/view/landing/main/mobileapp/mobileapp", "app/view/landing/main/cart/cart",
		"app/view/landing/main/order/order"], function (angular, mainTemplate, profileModule, mobileappModule,
		cartModule, orderModule) {

	var mainModule = angular.module("mainModule", ["profileModule", "mobileappModule", "cartModule", "orderModule"]);

	mainModule.config(["$stateProvider", "profileView", "mobileappView", "cartView", "orderView",
			function ($stateProvider, profileView, mobileappView, cartView, orderView) {

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
				}).state("app.main.order", {
					url: "/order",
					views: {
						"": orderView
					}
				});
			}]);

	mainModule.constant("mainView", {
		template: mainTemplate
	});

	return mainModule;
});
