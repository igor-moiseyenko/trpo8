/**
 * Sidebar view module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular", "text!app/view/landing/sidebar/sidebar.html"], function (angular, sidebarTemplate) {

	var sidebarModule = angular.module("sidebarModule", []);

	sidebarModule.constant("sidebarView", {
		template: sidebarTemplate
	});

	return sidebarModule;
});
