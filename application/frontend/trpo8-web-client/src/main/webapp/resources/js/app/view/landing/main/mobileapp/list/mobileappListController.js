/**
 * Mobile applications list controller.
 */
define(["angular"], function (angular) {

	return ["$scope", "lsService", "mobileappService", function ($scope, lsService, mobileappService) {

		$scope.model = {

			mobileApps: mobileappService.getAllMobileApps(lsService.getToken(), null, null)
		};
	}];
});
