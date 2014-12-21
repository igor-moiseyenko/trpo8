/**
 * Landing view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "app/service/sessionService/sessionService", "app/view/landing/navigation/navigation",
		"app/view/landing/sidebar/sidebar", "app/view/landing/main/main", "text!app/view/landing/landing.html"],
		function (angular, sessionServiceModule, navigationModule, sidebarModule, mainModule, landingTemplate) {

			var landingModule = angular.module("landingModule", ["sessionServiceModule", "navigationModule",
					"sidebarModule", "mainModule"]);

			landingModule.config(["$stateProvider", "navigationView", "sidebarView", "mainView",
					function ($stateProvider, navigationView, sidebarView, mainView) {

						$stateProvider.state("app.main", {
							url: "/app",
							views: {
								"navigation": navigationView,
								"sidebar": sidebarView,
								"main": mainView
							}
						});
					}]);

			landingModule.constant("landingView", {
				template: landingTemplate
			});

			return landingModule;
		});
