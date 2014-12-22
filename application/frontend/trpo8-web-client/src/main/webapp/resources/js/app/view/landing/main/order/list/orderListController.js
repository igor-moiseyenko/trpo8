/**
 * Order list controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "lsService", "orderService", function ($scope, lsService, orderService) {

		$scope.model = {

			orders: orderService.getMyOrders(lsService.getToken, null, null)
		};
	}];
});
