/**
 * Cart view module.
 */
define(["angular", "text!app/view/landing/main/cart/cart.html", "app/view/landing/main/cart/cartController",
		"app/service/order/orderService"], function (angular, cartTemplate, cartController, orderServiceModule) {

	var cartModule = angular.module("cartModule", ["orderServiceModule"]);

	cartModule.controller("cartController", cartController);

	cartModule.constant("cartView", {
		template: cartTemplate,
		controller: "cartController"
	});

	return cartModule;
});
