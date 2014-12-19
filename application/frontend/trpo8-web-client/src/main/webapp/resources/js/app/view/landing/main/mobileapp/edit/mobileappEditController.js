/**
 * Mobile application edit controller.
 */
define(["angular"], function (angular) {

	return [
			"$scope",
			"$state",
			"$stateParams",
			"lsService",
			"mobileappService",
			function ($scope, $state, $stateParams, lsService, mobileappService) {

				var successHandler = function () {
					$state.go("app.main.mobileapp.details", {
						"id": $scope.model.mobileApp.id
					});
				};

				var errorHandler = function (error) {
					console.log(error)
				};

				$scope.model = {

					mobileApp: mobileappService.getMobileAppById(lsService.getToken(), $stateParams.id, null, null),

					updateMobileApp: function () {

						mobileappService.updateMobileApp(lsService.getToken(), $scope.model.mobileApp, successHandler,
								errorHandler);
					}
				};
			}];
});
