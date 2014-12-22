package com.imoiseyenko.spastructure.backend.webservice.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imoiseyenko.spastructure.backend.service.mobileapp.OrderService;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.OrderVO;
import com.imoiseyenko.spastructure.backend.service.profile.SessionService;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

/**
 * Order REST API controller.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
@RestController
@RequestMapping("/v1/orders")
public class OrderRestController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private OrderService orderService;

	/**
	 * Create order.
	 * 
	 * @param accessToken
	 * @param orderVO
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createOrder (@RequestHeader("access_token") String accessToken, @RequestBody OrderVO orderVO)
			throws SpastructureException {

		TokenInfoVO tokenInfoVO = sessionService.verifySession(accessToken);
		orderService.createOrder(orderVO, tokenInfoVO.getUsername());
	}

	/**
	 * Get order with specified id.
	 * 
	 * @param accessToken
	 * @param id
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public OrderVO getOrderById (@RequestHeader("access_token") String accessToken, @PathVariable("id") Long id)
			throws SpastructureException {

		sessionService.verifySession(accessToken);

		return orderService.getOrder(id);
	}

	/**
	 * Get orders with specified account id.
	 * 
	 * @param accessToken
	 * @param accountId
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/my")
	public List<OrderVO> getOrdersByAccountId (@RequestHeader("access_token") String accessToken)
			throws SpastructureException {

		TokenInfoVO tokenInfoVO = sessionService.verifySession(accessToken);

		return orderService.getOrdersByEmail(tokenInfoVO.getUsername());
	}
}
