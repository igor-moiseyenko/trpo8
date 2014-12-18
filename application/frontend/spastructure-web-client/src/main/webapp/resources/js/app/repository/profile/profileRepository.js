/**
 * Profile repository module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "angular-resource"], function (angular, ngResource) {

	var profileRepositoryModule = angular.module("profileRepositoryModule", ["ngResource"]);

	profileRepositoryModule.factory("profileRepository", ["$resource", function ($resource) {

		var apiHost = "http://localhost:8080/spastructure-api";

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
							"token_data": tokenData
						}
					}
				});

				return profileResource.findProfile(successHandler, errorHandler);
			}
		};
	}]);

	return profileRepositoryModule;
});
