/**
 * Mobile applications list controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "$state", "lsService", "mobileappService",
			function ($scope, $state, lsService, mobileappService) {

				var successHandler = function (data) {
					console.log("lalala");
				};

				var errorHandler = function (error) {
					console.log(error);
				};

				$scope.model = {

					mobileApps: mobileappService.getAllMobileApps(lsService.getToken(), null, null),

					deleteMobileApp: function (mobileApp) {

						mobileappService.deleteMobileAppById(lsService.getToken(), mobileApp.id, function () {
							$state.go("app.main.profile.details")
						}, errorHandler);
					}
				};
			}];
});
