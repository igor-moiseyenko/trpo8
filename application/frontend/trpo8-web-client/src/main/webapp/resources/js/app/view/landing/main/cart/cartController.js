/**
 * Cart view controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "sessionService", function ($scope, sessionService) {

		$scope.model = {

			cart: sessionService.getCart(),

			deleteFromCart: function (item) {
				sessionService.getCart().deleteItem(item);
			}
		};
	}];
});
