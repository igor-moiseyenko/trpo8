/**
 * Profile view module controller.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	return ["$scope", "$rootScope", "accountService", "profileService", "lsService",
			function ($scope, $rootScope, accountService, profileService, lsService) {

				$scope.errors = [];

				var successHandler = function (data) {

				};

				var errorHandler = function (error) {
					$scope.errors.push(error.data.error);
				};

				$scope.model = {

					profile: profileService.getProfile(lsService.getToken(), successHandler, errorHandler)
				};
			}];
});
