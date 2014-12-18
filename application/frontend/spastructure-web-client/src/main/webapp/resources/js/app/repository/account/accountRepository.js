/**
 * Account repository module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "angular-resource"], function (angular, ngResource) {

	var accountRepositoryModule = angular.module("accountRepositoryModule", ["ngResource"]);

	accountRepositoryModule.factory("accountRepository", ["$resource", function ($resource) {

		var apiHost = "http://localhost:8080/spastructure-api";

		return {

			findAccountByUsername: function (username) {

				var accountResource = $resource(apiHost + "/api/v1/accounts/:username");

				return accountResource.get({
					username: username
				});
			}
		};
	}]);

	return accountRepositoryModule;
});
