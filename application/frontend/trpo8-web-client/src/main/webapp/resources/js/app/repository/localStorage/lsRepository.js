/**
 * Repository module to work with HTML5 local storage.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	var lsRepositoryModule = angular.module("lsRepositoryModule", []);

	lsRepositoryModule.factory("lsRepository", [function () {

		return {

			/**
			 * Put string as it is to the local storage.
			 */
			putString: function (key, value) {

				localStorage.setItem(key, value);
			},

			/**
			 * Get string from the local storage.
			 */
			getString: function (key) {

				return localStorage.getItem(key);
			},

			/**
			 * Put object as JSON string to the local storage.
			 */
			putObject: function (key, value) {

				localStorage.setItem(key, JSON.stringify(value));
			},

			/**
			 * Get deserialized object from the local storage.
			 */
			getObject: function (key) {

				return JSON.parse(localStorage.getItem(key));
			},

			/**
			 * Remove item from the local storage with specified key.
			 */
			removeItem: function (key) {

				localStorage.removeItem(key);
			}
		};
	}]);

	return lsRepositoryModule;
});
