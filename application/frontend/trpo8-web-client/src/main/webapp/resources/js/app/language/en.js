/**
 * English.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/view/application"], function (angular, applicationModule) {

	applicationModule.config(["$translateProvider", function ($translateProvider) {

		$translateProvider.translations("en", {

			/** Common */
			"common.ok": "Ok",
			"common.cancel": "Cancel",
			"common.next": "Next",
			"common.back": "Back",
			"common.title": "Mobile App Store",
			"common.save": "Save",
			"common.add": "Add",
			"common.details": "Details",
			"common.edit": "Edit",
			"common.delete": "Delete",

			/** Login */
			"login.email": "Email",
			"login.password": "Password",
			"login.login": "Login",

			/** Register */
			"register.email": "Email",
			"register.password": "Password",
			"register.register": "Register",

			/** Navigation */
			"navigation.people": "People",
			"navigation.news": "News",
			"navigation.communities": "Communities",
			"navigation.logout": "Logout",

			/** Sidebar */
			"sidebar.my.profile": "My profile",
			"sidebar.mobileapps": "Mobile Apps",
			"sidebar.cart": "My cart",
			"sidebar.orders": "Orders",

			/** Profile */
			"profile.firstname": "First name",
			"profile.lastname": "Last name",
			"profile.email": "Email",
			"profile.address": "Address",

			/** Mobile App */
			"mobile.app.name": "Name",
			"mobile.app.price": "Price",
			"mobile.app.type": "Type",
			"mobile.app.raiting": "Rating",
			"mobile.app.description": "Description",

			/** Mobile app list */
			"mobileapp.list.mobile.apps": "Applications",

			/** Mobile app details */
			"mobileapp.details.add.to.cart": "Add to cart",

			/** Profile details */
			"profile.details.my": "My profile details",

			/** Profile edit */
			"profile.edit.my": "My profile edition",

			/** Cart */
			"cart.my": "My cart",
			"cart.order": "Order",
			"cart.item.quantity": "Quantity",
			"cart.item.total": "Item total",
			"cart.total": "Total",

			/** Order */
			"order.orders": "Orders",

			/** Order list */
			"order.list.item.name": "Item name",
			"order.list.item.quantity": "Quantity",

			/** Order details */
			"order.details.order": "Order"
		});
	}]);
});
