/**
 * Order details view module.
 */
define(["angular", "text!app/view/landing/main/order/details/orderDetails.html",
		"app/view/landing/main/order/details/orderDetailsController"], function (angular, orderDetailsTemplate,
		orderDetailsController) {

	var orderDetailsModule = angular.module("orderDetailsModule", []);

	orderDetailsModule.controller("orderDetailsController", orderDetailsController);

	orderDetailsModule.constant("orderDetailsView", {
		template: orderDetailsTemplate,
		controller: orderDetailsController
	});

	return orderDetailsModule;
});
