/**
 * Mobile application details controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "$state", "$stateParams", "lsService", "sessionService", "mobileappService",
			function ($scope, $state, $stateParams, lsService, sessionService, mobileappService) {

				$scope.model = {

					mobileApp: mobileappService.getMobileAppById(lsService.getToken(), $stateParams.id, null, null),

					addToCart: function () {
						sessionService.addMobileAppToCart($scope.model.mobileApp);
						$state.go("app.main.cart");
					}
				};
			}];
});
