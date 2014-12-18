/**
 * SPA global view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "angular-ui-router", "angular-translate", "angular-translate-loader",
		"app/service/auth/authService", "app/service/account/accountService", "app/directive/error/error",
		"app/view/login/login", "app/view/register/register", "app/view/landing/landing",
		"app/service/localStorage/lsService", "app/module/dateFormatter"], function (angular, uiRouter,
		angularTranslate, angularTranslateLoader, authServiceModule, accountServiceModule, errorModule, loginModule,
		registerModule, landingModule, lsServiceModule, dateFormatterModule) {

	var applicationModule = angular.module("applicationModule", ["ui.router", "pascalprecht.translate",
			"authServiceModule", "accountServiceModule", "errorModule", "loginModule", "registerModule",
			"landingModule", "lsServiceModule", "dateFormatterModule"]);

	applicationModule.init = function () {
		angular.bootstrap(document, ["applicationModule"]);
	};

	applicationModule.config(["$stateProvider", "$translateProvider", "loginView", "registerView", "landingView",
			function ($stateProvider, $translateProvider, loginView, registerView, landingView) {

				/** Set initial language to English */
				$translateProvider.preferredLanguage("en");

				$stateProvider.state("app", {
					url: "",
					views: {
						"": {
							templateUrl: "resources/js/app/view/application.html"
						},
						"@app": landingView
					}
				}).state("login", {
					url: "/login",
					views: {
						"": loginView
					}
				}).state("register", {
					url: "/register",
					views: {
						"": registerView
					}
				});
			}]);

	// applicationModule.run(["$rootScope", "$state", "accountService", function
	// ($rootScope, $state, accountService) {
	//
	// $rootScope.$on("$stateChangeStart", function (event, nextState,
	// currentState) {
	//
	// if ("login" !== nextState.name && "register" !== nextState.name) {
	//				
	// }
	// });
	// }]);

	return applicationModule;
});
