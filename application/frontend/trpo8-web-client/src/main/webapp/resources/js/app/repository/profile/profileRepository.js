/**
 * Profile repository module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "angular-resource"], function (angular, ngResource) {

	var profileRepositoryModule = angular.module("profileRepositoryModule", ["ngResource"]);

	profileRepositoryModule.factory("profileRepository", ["$resource", function ($resource) {

		var apiHost = "http://localhost:8080/trpo8-api";

		return {

			findProfileByProfileId: function (profileId) {

				var profileResource = $resource(apiHost + "/api/v1/profiles/:id");

				return profileResource.get({
					id: profileId
				});
			},

			findProfile: function (tokenData, successHandler, errorHandler) {

				var profileResource = $resource(apiHost + "/api/v1/profiles", {}, {
					findProfile: {
						method: "GET",
						headers: {
							"access_token": tokenData
						}
					}
				});

				return profileResource.findProfile(successHandler, errorHandler);
			},

			updateProfile: function (accessToken, profile, successHandler, errorHandler) {

				var profileResource = $resource(apiHost + "/api/v1/profiles", {}, {
					updateProfile: {
						method: "POST",
						headers: {
							"access_token": accessToken
						}
					}
				});

				return profileResource.updateProfile(profile, successHandler, errorHandler);
			}
		};
	}]);

	return profileRepositoryModule;
});
