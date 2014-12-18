/**
 * Account service module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/repository/account/accountRepository"], function (angular, accountRepositoryModule) {

	var accountServiceModule = angular.module("accountServiceModule", ["accountRepositoryModule"]);

	accountServiceModule.factory("accountService", ["accountRepository", function (accountRepository) {

		return {

			getAccountByUsername: function (username) {

				return accountRepository.findAccountByUsername(username);
			}
		};
	}]);

	return accountServiceModule;
});
