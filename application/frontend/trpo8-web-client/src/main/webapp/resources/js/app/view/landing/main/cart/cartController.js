/**
 * Cart view controller.
 */
define(["angular"], function (angular) {

	return [
			"$scope",
			"$state",
			"lsService",
			"sessionService",
			"orderService",
			function ($scope, $state, lsService, sessionService, orderService) {

				var successHandler = function () {

					sessionService.cleanCart();
					$state.go("app.main.order.list");
				};

				var errorHandler = function (error) {
					console.log(error.data.error);
				};

				var convertCartToOrder = function (cart) {

					var orderItemVOs = [];
					angular.forEach(cart.items, function (cartItem) {
						orderItemVOs.push({
							mobileAppVO: {
								id: cartItem.mobileApp.id
							},
							quantity: cartItem.quantity
						});
					});

					return {
						orderItemVOs: orderItemVOs
					};
				};

				$scope.model = {

					cart: sessionService.getCart(),

					deleteFromCart: function (item) {
						sessionService.getCart().deleteItem(item);
					},

					makeOrder: function () {

						orderService.createOrder(lsService.getToken, convertCartToOrder($scope.model.cart),
								successHandler, errorHandler)
					}
				};
			}];
});
