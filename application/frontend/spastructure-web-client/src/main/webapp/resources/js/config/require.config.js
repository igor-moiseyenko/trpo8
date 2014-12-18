/**
 * 
 */
requirejs.config({

	baseUrl: "resources/js",

	paths: {

		"angular": "lib/angular",
		"angular-ui-router": "lib/angular-ui-router",
		"angular-resource": "lib/angular-resource",
		"angular-translate": "lib/angular-translate",
		"angular-translate-loader": "lib/angular-translate-loader-static-files",
		"text": "lib/text"
	},

	shim: {

		"angular": {
			exports: "angular"
		},

		"angular-ui-router": {
			deps: ["angular"],
			exports: "angular-ui-router"
		},

		"angular-resource": {
			deps: ["angular"],
			exports: "angular-resource"
		},

		"angular-translate": {
			deps: ["angular"],
			exports: "angular-translate"
		},

		"angular-translate-loader": {
			deps: ["angular-translate"],
			exports: "angular-translate-loader"
		}
	},

	deps: ["app/main"]
});
