/**
 * Navigation view module controller.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	return ["$scope", "$state", "authService", "lsService", "authService",
			function ($scope, $state, authService, lsService, authService) {

				var successHandler = function (data) {
					lsService.removeToken();
					$state.go("login");
				};

				$scope.model = {

					signOut: function () {
						authService.signOut(lsService.getToken(), successHandler, successHandler);
					}
				};
			}];
});
