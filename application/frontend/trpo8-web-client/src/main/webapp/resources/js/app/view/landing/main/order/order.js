/**
 * Order view module.
 */
define(["angular", "text!app/view/landing/main/order/order.html", "app/service/order/orderService",
		"app/view/landing/main/order/list/orderList", "app/view/landing/main/order/details/orderDetails"], function (
		angular, orderTemplate, orderServiceModule, orderListModule, orderDetailsModule) {

	var orderModule = angular.module("orderModule", ["orderServiceModule", "orderListModule", "orderDetailsModule"]);

	orderModule.constant("orderView", {
		template: orderTemplate
	});

	orderModule.config(["$stateProvider", "orderListView", "orderDetailsView",
			function ($stateProvider, orderListView, orderDetailsView) {

				$stateProvider.state("app.main.order.list", {
					url: "/list",
					views: {
						"": orderListView
					}
				}).state("app.main.order.details", {
					url: "/:id",
					views: {
						"": orderDetailsView
					}
				});
			}]);

	return orderModule;
});
