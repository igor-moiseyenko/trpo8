/**
 * Order details controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "$stateParams", "lsService", "orderService",
			function ($scope, $stateParams, lsService, orderService) {

				$scope.model = {

					order: orderService.getOrderById(lsService.getToken(), $stateParams.id, null, null),
					
					getTotal: function () {
					}
				};
			}];
});
