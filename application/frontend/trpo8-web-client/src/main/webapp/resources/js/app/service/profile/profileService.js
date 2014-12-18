/**
 * Profile service module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/repository/profile/profileRepository"], function (angular, profileRepositoryModule) {

	var profileServiceModule = angular.module("profileServiceModule", ["profileRepositoryModule"]);

	profileServiceModule.factory("profileService", ["profileRepository", function (profileRepository) {

		return {

			getProfileByProfileId: function (profileId) {

				return profileRepository.findProfileByProfileId(profileId);
			},

			getProfile: function (tokenData, successHandler, errorHandler) {

				if (!tokenData) {
					tokenData = "";
				}

				return profileRepository.findProfile(tokenData, successHandler, errorHandler);
			},

			updateProfile: function (accessToken, profile, successHandler, errorHandler) {

				return profileRepository.updateProfile(accessToken, profile, successHandler, errorHandler);
			}
		};
	}]);

	return profileServiceModule;
});
