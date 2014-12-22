/**
 * Order repository module.
 */
define(["angular", "angular-resource"], function (angular, ngResource) {

	var orderRepositoryModule = angular.module("orderRepositoryModule", []);

	orderRepositoryModule.factory("orderRepository", ["$resource", function ($resource) {

		var apiHost = "http://localhost:8080/trpo8-api";

		return {

			createOrder: function (accessToken, order, successHandler, errorHandler) {

				var orderResource = $resource(apiHost + "/api/v1/orders", {}, {
					createOrder: {
						method: "PUT",
						headers: {
							"access_token": accessToken
						}
					}
				});

				return orderResource.createOrder(order, successHandler, errorHandler);
			},

			findOrderById: function (accessToken, id, successHandler, errorHandler) {

				var orderResource = $resource(apiHost + "/api/v1/orders/:id", {}, {
					findOrderById: {
						method: "GET",
						headers: {
							"access_token": accessToken
						},
						params: {
							"id": id
						}
					}
				});

				return orderResource.findOrderById(successHandler, errorHandler);
			},

			findMyOrders: function (accessToken, successHandler, errorHandler) {

				var orderResource = $resource(apiHost + "/api/v1/orders/my", {}, {
					findOrderById: {
						method: "GET",
						isArray: true,
						headers: {
							"access_token": accessToken
						}
					}
				});

				return orderResource.findOrderById(successHandler, errorHandler);
			}
		};
	}]);

	return orderRepositoryModule;
});
