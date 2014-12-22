/**
 * Order list view module.
 */
define(["angular", "text!app/view/landing/main/order/list/orderList.html",
		"app/view/landing/main/order/list/orderListController"], function (angular, orderListTemplate,
		orderListController) {

	var orderListModule = angular.module("orderListModule", []);

	orderListModule.controller("orderListController", orderListController);

	orderListModule.constant("orderListView", {
		template: orderListTemplate,
		controller: "orderListController"
	});

	return orderListModule;
});
