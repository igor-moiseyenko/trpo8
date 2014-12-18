/**
 * Login view module controller.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	return [
			"$scope",
			"$rootScope",
			"$state",
			"$filter",
			"authService",
			"lsService",
			function ($scope, $rootScope, $state, $filter, authService, lsService) {

				/** Errors directive model */
				$scope.errors = [];

				var successHandler = function (data) {

					console.log(data);
					lsService.saveToken(data.accessToken);
					lsService.saveDeviceId($scope.model.deviceId);
					$state.go("app.main.profile.details");
				};

				var errorHandler = function (error) {

					console.log(error);
					$scope.errors.push(error.data.error);
				};

				$scope.model = {

					email: "",
					password: "",

					login: function () {

						// Generate device id in the case if it wasn't found in
						// the local storage.

						$scope.submitted = true;
						$scope.model.deviceId = lsService.getDeviceId();
						if (!$scope.model.deviceId) {
							$scope.model.deviceId = navigator.platform + navigator.vendor
									+ $filter("date")(new Date(), "yyyy-MM-dd HH:mm:ss");
						}

						authService.signIn($scope.model.email, $scope.model.password, successHandler, errorHandler);
					}
				};
			}];
});
