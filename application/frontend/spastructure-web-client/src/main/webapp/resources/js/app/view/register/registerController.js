/**
 * Register view module controller.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	return [
			"$scope",
			"$rootScope",
			"$state",
			"authService",
			"lsService",
			"dateFormatter",
			"dateFormatterConstant",
			function ($scope, $rootScope, $state, authService, lsService, dateFormatter, dateFormatterConstant) {

				$scope.errors = [];

				var successHandler = function (data) {

					console.log(data);
					lsService.saveToken(data.accessToken);
					lsService.saveDeviceId($scope.model.deviceId);
					$state.go("app.main.profile");
				};

				var errorHandler = function (error) {

					console.log(error);
					$scope.errors.push(error.data.error);
				};

				$scope.model = {

					email: "",
					password: "",
					deviceId: "",

					register: function () {

						// Generate device id in the case if it wasn't found
						// in the local storage.
						$scope.model.deviceId = lsService.getDeviceId();
						if (!$scope.model.deviceId) {
							$scope.model.deviceId = navigator.platform
													+ navigator.vendor
													+ dateFormatter.formatDateValue(new Date(),
														dateFormatterConstant.apiDateTimePattern);
						}

						authService.signUp($scope.model.email, $scope.model.password, successHandler, errorHandler);
					}
				};
			}];
});
