/**
 * Session service module.
 */
define(["angular"], function (angular) {

	var sessionServiceModule = angular.module("sessionServiceModule", []);

	sessionServiceModule.factory("sessionService", function () {

		var item = {
			mobileApp: null,
			quantity: 0,
			total: 0
		};

		var cart = {

			items: [],

			addMobileApp: function (mobileApp) {

				var cartItem = this.getItemByMobileAppId(mobileApp.id);

				if (!cartItem) {
					cartItem = angular.copy(item);
					cartItem.mobileApp = mobileApp;
					cart.items.push(cartItem);
				}
				cartItem.quantity += 1;
				cartItem.total += mobileApp.price;
				this.total += mobileApp.price;
			},

			deleteItem: function (item) {

				var indexToDelete = this.items.indexOf(item);
				if (indexToDelete !== -1) {
					this.total -= item.total;
					this.items.splice(indexToDelete, 1);
				}
			},

			getItemByMobileAppId: function (mobileAppId) {

				var item = null;

				this.items.every(function (element, index, array) {
					if (element.mobileApp.id === mobileAppId) {
						item = element;
						return false
					} else {
						return true;
					}
				});

				return item;
			},

			total: 0
		};

		return {

			getCart: function () {
				return cart;
			},

			addMobileAppToCart: function (mobileApp) {

				cart.addMobileApp(mobileApp);
			}
		};
	});

	return sessionServiceModule;
});
