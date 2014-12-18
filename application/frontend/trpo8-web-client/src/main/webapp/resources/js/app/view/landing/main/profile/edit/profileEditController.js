/**
 * Profile edit controller.
 */
define(["angular"], function (angular) {

	return ["$scope", function ($scope) {

		$scope.model = {

			updateProfile: function () {

				console.log("Edited profile: " + $scope.$parent.model.profile);
			}
		};
	}];
});
