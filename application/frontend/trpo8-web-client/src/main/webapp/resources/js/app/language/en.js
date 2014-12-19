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
			"common.title": "SPA Structure",
			"common.save": "Save",
			"common.add": "Add",
			"common.details": "Details",
			"common.edit": "Edit",

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
			"mobile.app.description": "Description"
		});
	}]);
});
