package com.imoiseyenko.spastructure.backend.webservice.account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imoiseyenko.spastructure.backend.service.profile.AccountService;
import com.imoiseyenko.spastructure.backend.service.profile.vo.AccountVO;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

/**
 * Account REST Controller.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
@RestController
@RequestMapping(value = "/v1/accounts")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	/**
	 * Create {@link AccountVO} instance.
	 * 
	 * @param accountVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createAccount (@RequestBody AccountVO accountVO) throws SpastructureException {

		accountService.createAccount(accountVO);
	}

	/**
	 * Get {@link AccountVO} instance with specified id.
	 * 
	 * @param id
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	// @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	// public AccountVO getAccountById (@PathVariable("id") String id) {
	//
	// return accountService.getAccountById(Long.parseLong(id));
	// }

	/**
	 * Update {@link AccountVO} instance.
	 * 
	 * @param accountVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAccount (@RequestBody AccountVO accountVO) throws SpastructureException {

		accountService.updateAccount(accountVO);
	}

	/**
	 * Delete {@link AccountVO} instance.
	 * 
	 * @param accountVO
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount (@RequestBody AccountVO accountVO) throws SpastructureException {

		accountService.deleteAccount(accountVO);
	}

	/**
	 * Delete {@link AccountVO} instance by id.
	 * 
	 * @param id
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAccountById (@PathVariable("id") String id) throws SpastructureException {

		accountService.deleteAccountById(Long.parseLong(id));
	}

	/**
	 * Get {@link AccountVO} instance with specified user name.
	 * 
	 * @param username
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{username}")
	public AccountVO getAccountByUsername (@PathVariable("username") String username) throws SpastructureException {

		return accountService.getAccountByUsername(username);
	}

	/**
	 * Get all {@link AccountVO} instances.
	 * 
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<AccountVO> getAllAccounts () throws SpastructureException {

		return accountService.getAllAccounts();
	}
}
