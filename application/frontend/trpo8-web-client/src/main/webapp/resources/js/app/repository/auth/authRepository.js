/**
 * Authentication module repository.
 * 
 * @author imoiseyenko@gmail.com
 */
define([ "angular", "angular-resource" ], function(angular, ngResource) {

	var authRepositoryModule = angular.module("authRepositoryModule",
			[ "ngResource" ]);

	authRepositoryModule.factory("authRepository", [
			"$resource",
			function($resource) {

				var apiHost = "http://localhost:8080/trpo8-api";

				return {

					signUp : function(email, password, successHandler,
							errorHandler) {

						var tokenResource = $resource(apiHost
								+ "/api/v1/signup", {}, {
							register : {
								method : "POST",
								params : {
									email : email,
									password : password
								}
							}
						});

						return tokenResource.register(successHandler,
								errorHandler);
					},

					signIn : function(email, password, successHandler,
							errorHandler) {

						var tokenResource = $resource(apiHost
								+ "/api/v1/signin", {}, {
							login : {
								method : "POST",
								params : {
									email : email,
									password : password
								}
							}
						});

						return tokenResource
								.login(successHandler, errorHandler);
					},

					signOut : function(eventsTokenData, successHandler,
							errorHandler) {

						var logoutResource = $resource(apiHost
								+ "/api/v1/signout", {}, {
							logout : {
								method : "POST",
								headers : {
									"access_token" : eventsTokenData
								}
							}
						});

						return logoutResource.logout(successHandler,
								errorHandler);
					}
				};
			} ]);

	return authRepositoryModule;
});
