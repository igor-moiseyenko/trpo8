/**
 * Mobile application details controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "$stateParams", "lsService", "mobileappService",
			function ($scope, $stateParams, lsService, mobileappService) {

				$scope.model = {

					mobileApp: mobileappService.getMobileAppById(lsService.getToken(), $stateParams.id, null, null)
				};
			}];
});
