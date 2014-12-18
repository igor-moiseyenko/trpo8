/**
 * Date formatter module.
 * 
 * @author imoiseyenko93@gmail.com
 */
define(["angular"], function (angular) {

	var dateFormatterModule = angular.module("dateFormatterModule", []);

	dateFormatterModule.constant("dateFormatterConstant", {

		/** WEB client patterns. */
		datePattern: "yyyy-MM-dd",
		timePattern: "HH:mm",
		dateTimePattern: "yyyy-MM-dd HH:mm",

		/** API patterns. */
		apiDatePattern: "yyyy-MM-dd",
		apiDateTimePattern: "yyyy-MM-dd HH:mm:ss"
	});

	/**
	 * Date formatter service to work with date & its string representations.
	 */
	dateFormatterModule.service("dateFormatter", [
			"dateFormatterConstant",
			"$filter",
			function (dateFormatterConstant, $filter) {

				return {

					/**
					 * ECMA format functions.
					 */

					/**
					 * Format date value to the format supported by the API -
					 * add time delimiter. ECMA: T "T" appears literally in the
					 * string, to indicate the beginning of the time element.
					 */
					formatDateValueToECMAFormat: function (dateValue) {

						return dateValue.replace(" ", "T");
					},

					/**
					 * Format date value (or valid JS Date object) to the
					 * formatted value according to the specified pattern.
					 */
					formatDateValue: function (dateValue, pattern) {

						return $filter("date")(dateValue, pattern);
					},

					stringToDate: function (dateString) {
						var year = $filter("date")(dateString, "yyyy");
						var month = $filter("date")(dateString, "M");
						var day = $filter("date")(dateString, "d");
						var hour = $filter("date")(dateString, "H");
						var minute = $filter("date")(dateString, "m");
						var second = $filter("date")(dateString, "s");
						return new Date(parseInt(year), parseInt(month) - 1, parseInt(day), parseInt(hour),
								parseInt(minute), parseInt(second));
					},

					/**
					 * Convert UTC date to local date.
					 */
					convertUTCDateToLocalDate: function (UTCDate) {

						return new Date(UTCDate.getTime() + UTCDate.getTimezoneOffset() * 60 * 1000);
					},

					/**
					 * Convert UTC date value to local date.
					 */
					convertUTCDateValueToLocalDate: function (UTCDateValue) {

						var self = this;
						var UTCDate = new Date(UTCDateValue);
						return self.convertUTCDateToLocalDate(UTCDate);
					},

					/**
					 * Convert local date to UTC date.
					 */
					convertLocalDateToUTC: function (localDate) {

						return new Date(localDate.getTime() - localDate.getTimezoneOffset() * 60 * 1000);
					}
				};
			}]);

	return dateFormatterModule;
});
