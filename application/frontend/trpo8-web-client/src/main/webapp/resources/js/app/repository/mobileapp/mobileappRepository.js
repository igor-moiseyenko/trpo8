/**
 * Mobile application repository module.
 */
define(["angular", "angular-resource"], function (angular, ngResource) {

	var mobileappRepositoryModule = angular.module("mobileappRepositoryModule", []);

	mobileappRepositoryModule.factory("mobileappRepository", ["$resource", function ($resource) {

		var apiHost = "http://localhost:8080/trpo8-api";

		return {

			findMobileAppById: function (accessToken, id, successHandler, errorHandler) {

				var mobileAppResource = $resource(apiHost + "/api/v1/mobileapps/:id", {}, {
					findMobileAppById: {
						method: "GET",
						headers: {
							"access_token": accessToken
						},
						params: {
							"id": id
						}
					}
				});

				return mobileAppResource.findMobileAppById(successHandler, errorHandler);
			},

			findAllMobileApps: function (accessToken, successHandler, errorHandler) {

				var mobileAppResource = $resource(apiHost + "/api/v1/mobileapps", {}, {
					findAllMobileApps: {
						method: "GET",
						isArray: true,
						headers: {
							"access_token": accessToken
						}
					}
				});

				return mobileAppResource.findAllMobileApps(successHandler, errorHandler);
			}
		};
	}]);

	return mobileappRepositoryModule;
});
