/**
 * Mobile application service module.
 */
define(["angular", "app/repository/mobileapp/mobileappRepository"], function (angular, mobileappRepositoryModule) {

	var mobileappServiceModule = angular.module("mobileappServiceModule", ["mobileappRepositoryModule"]);

	mobileappServiceModule.factory("mobileappService", ["mobileappRepository", function (mobileappRepository) {

		return {

			getMobileAppById: function (accessToken, id, successHandler, errorHandler) {

				return mobileappRepository.findMobileAppById(accessToken, id, successHandler, errorHandler);
			},

			getAllMobileApps: function (accessToken, successHandler, errorHandler) {

				return mobileappRepository.findAllMobileApps(accessToken, successHandler, errorHandler);
			},

			updateMobileApp: function (accessToken, mobileApp, successHandler, errorHandler) {

				return mobileappRepository.updateMobileApp(accessToken, mobileApp, successHandler, errorHandler);
			},

			deleteMobileAppById: function (accessToken, id, successHandler, errorHandler) {

				return mobileappRepository.deleteMobileAppById(accessToken, id, successHandler, errorHandler);
			}
		};
	}]);

	return mobileappServiceModule;
});
