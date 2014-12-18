/**
 * Service module to work with HTML5 local storage.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/repository/localStorage/lsRepository"], function (angular, lsRepositoryModule) {

	var lsServiceModule = angular.module("lsServiceModule", ["lsRepositoryModule"]);

	lsServiceModule.factory("lsService", ["lsRepository", function (lsRepository) {

		var TOKEN_STORAGE_ID = "spastructure.access_token";
		var DEVICE_ID = "spastructure.deviceId";

		/**
		 * Put string as it is to the local storage repository. Implemented as
		 * private method angular's factory.
		 */
		var putString = function (key, value) {

			lsRepository.putString(key, value);
		};

		/**
		 * Get string from the local storage repository. Implemented as private
		 * method angular's factory.
		 */
		var getString = function (key) {

			return lsRepository.getString(key);
		};

		/**
		 * Put object as JSON string to the local storage repository.
		 * Implemented as private method angular's factory.
		 */
		var putObject = function (key, value) {

			lsRepository.putObject(key, value);
		};

		/**
		 * Get deserialized object from the local storage repository.
		 * Implemented as private method angular's factory.
		 */
		var getObject = function (key) {

			return lsRepository.getObject(key);
		};

		/**
		 * Remove item from the local storage with specified key. Implemented as
		 * private method angular's factory.
		 */
		var removeItem = function (key) {

			lsRepository.removeItem(key);
		}

		return {

			/**
			 * Save Viadeo Events access token to the local storage.
			 */
			saveToken: function (tokenData) {

				putString(TOKEN_STORAGE_ID, tokenData);
			},

			/**
			 * Get Viadeo Events access token from the local storage.
			 */
			getToken: function () {

				return getString(TOKEN_STORAGE_ID);
			},

			/**
			 * Remove Viadeo Events access token from the local storage.
			 */
			removeToken: function () {

				removeItem(TOKEN_STORAGE_ID);
			},

			/**
			 * Save device id to the local storage.
			 */
			saveDeviceId: function (deviceId) {

				putString(DEVICE_ID, deviceId);
			},

			/**
			 * Get device id from the local storage.
			 */
			getDeviceId: function () {

				return getString(DEVICE_ID);
			}
		};
	}]);

	return lsServiceModule;
});
