/**
 * Cart view module.
 */
define(["angular", "text!app/view/landing/main/cart/cart.html", "app/view/landing/main/cart/cartController"], function (
		angular, cartTemplate, cartController) {

	var cartModule = angular.module("cartModule", []);

	cartModule.controller("cartController", cartController);

	cartModule.constant("cartView", {
		template: cartTemplate,
		controller: "cartController"
	});

	return cartModule;
});
