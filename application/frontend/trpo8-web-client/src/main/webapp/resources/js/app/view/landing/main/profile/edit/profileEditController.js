/**
 * Profile edit controller.
 */
define(["angular"], function (angular) {

	return [
			"$scope",
			"$state",
			"lsService",
			"profileService",
			function ($scope, $state, lsService, profileService) {

				var successHandler = function () {
					$state.go("app.main.profile.details");
				};

				var errorHandler = function (error) {
					console.log(error)
				};

				$scope.model = {

					updateProfile: function () {

						profileService.updateProfile(lsService.getToken(), $scope.$parent.model.profile,
								successHandler, errorHandler);
					}
				};
			}];
});
