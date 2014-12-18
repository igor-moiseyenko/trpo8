/**
 * Authentication service module
 * 
 * @author imoiseyenko@gmail.com
 */
define(["angular", "app/repository/auth/authRepository"], function (angular, authRepositoryModule) {

	var authServiceModule = angular.module("authServiceModule", ["authRepositoryModule"]);

	authServiceModule.factory("authService", ["authRepository", "lsService", function (authRepository, lsService) {

		return {

			// check if user have access token
			isLoggedIn: function () {

				return lsService.getToken() ? true : false;
			},

			signUp: function (email, password, successHandler, errorHandler) {

				return authRepository.signUp(email, password, successHandler, errorHandler);
			},

			signIn: function (email, password, successHandler, errorHandler) {

				return authRepository.signIn(email, password, successHandler, errorHandler);
			},

			// Sign out user from application
			signOut: function (eventsTokenData, successHandler, errorHandler) {

				return authRepository.signOut(eventsTokenData, successHandler, errorHandler);
			}
		};
	}]);

	return authServiceModule;
});
