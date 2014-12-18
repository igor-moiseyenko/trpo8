/**
 * Profile view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/service/account/accountService", "app/service/profile/profileService",
		"app/view/landing/main/profile/profileController", "text!app/view/landing/main/profile/profile.html",
		"app/view/landing/main/profile/details/profileDetails", "app/view/landing/main/profile/edit/profileEdit"],
		function (angular, accountServiceModule, profileServiceModule, profileController, profileTemplate,
				profileDetailsModule, profileEditModule) {

			var profileModule = angular.module("profileModule", ["accountServiceModule", "profileServiceModule",
					"profileDetailsModule", "profileEditModule"]);

			profileModule.controller("profileController", profileController);

			profileModule.constant("profileView", {
				template: profileTemplate,
				controller: "profileController"
			});

			profileModule.config(["$stateProvider", "profileDetailsView", "profileEditView",
					function ($stateProvider, profileDetailsView, profileEditView) {

						$stateProvider.state("app.main.profile.details", {
							url: "/details",
							views: {
								"": profileDetailsView
							}
						}).state("app.main.profile.edit", {
							url: "/edit",
							views: {
								"": profileEditView
							}
						});
					}]);

			return profileModule;
		});
