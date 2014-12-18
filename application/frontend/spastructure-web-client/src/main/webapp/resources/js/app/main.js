/**
 * SPA single entry point.
 * 
 * @author imoiseyenko93@gmail.com
 */
require(["app/view/application", "app/language/en"], function (application) {

	console.log("init app");
	application.init();
}, function (error) {

	console.log("Failed to load scripts: " + error.requireModules + ", error: " + error.message);
});
