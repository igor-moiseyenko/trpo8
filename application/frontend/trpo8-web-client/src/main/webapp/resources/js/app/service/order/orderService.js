/**
 * Order service module.
 */
define(["angular", "app/repository/order/orderRepository"], function (angular, orderRepositoryModule) {

	var orderServiceModule = angular.module("orderServiceModule", ["orderRepositoryModule"]);

	orderServiceModule.factory("orderService", ["orderRepository", function (orderRepository) {

		return {

			createOrder: function (accessToken, order, successHandler, errorHandler) {

				return orderRepository.createOrder(accessToken, order, successHandler, errorHandler);
			},

			getOrderById: function (accessToken, id, successHandler, errorHandler) {

				return orderRepository.findOrderById(accessToken, id, successHandler, errorHandler);
			},

			getMyOrders: function (accessToken, successHandler, errorHandler) {

				return orderRepository.findMyOrders(accessToken, successHandler, errorHandler);
			}
		};
	}]);

	return orderServiceModule;
});
