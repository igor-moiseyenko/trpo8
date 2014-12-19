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

				var editSuccessHandler = function () {
					$state.go("app.main.mobileapp.details", {
						"id": $scope.model.mobileApp.id
					});
				};

				var createSuccessHandler = function () {
					$state.go("app.main.mobileapp.list");
				};

				var errorHandler = function (error) {
					console.log(error)
				};

				$scope.model = {

					mobileApp: mobileappService.getMobileAppById(lsService.getToken(), $stateParams.id, null, null),

					updateMobileApp: function () {

						mobileappService.updateMobileApp(lsService.getToken(), $scope.model.mobileApp,
								editSuccessHandler, errorHandler);
					},

					createMobileApp: function () {

						mobileappService.createMobileApp(lsService.getToken(), $scope.model.mobileApp,
								createSuccessHandler, errorHandler);
					},

					action: null
				};

				// Create OR Update
				if ("new" === $stateParams.id) {
					$scope.model.action = $scope.model.createMobileApp;
				} else {
					$scope.model.action = $scope.model.updateMobileApp;
				}
			}];
});
