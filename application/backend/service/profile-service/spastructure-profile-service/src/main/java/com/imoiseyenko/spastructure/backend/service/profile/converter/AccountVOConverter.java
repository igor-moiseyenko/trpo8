package com.imoiseyenko.spastructure.backend.service.profile.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.service.profile.vo.AccountVO;

/**
 * Converter for the {@link AccountVO} value object to the {@link Account} entity instance and vice
 * versa.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
@Component
public class AccountVOConverter {

	/**
	 * Convert {@link Account} entity instance to the {@link AccountVO} value object.
	 * 
	 * @param account
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public AccountVO convertAccountToVO (Account account) {

		AccountVO accountVO = null;

		if (account != null) {

			accountVO = new AccountVO();
			accountVO.setId(account.getId());
			accountVO.setUsername(account.getUsername());
			accountVO.setPassword(account.getPassword());
		}

		return accountVO;
	}

	/**
	 * Convert list of {@link Account} entity instances to the list of {@link AccountVO} value
	 * objects.
	 * 
	 * @param accounts
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<AccountVO> convertAccountsToVO (List<Account> accounts) {

		List<AccountVO> accountsVO = new ArrayList<>();

		if (accounts != null && accounts.size() > 0) {
			for (Account account : accounts) {
				accountsVO.add(convertAccountToVO(account));
			}
		}

		return accountsVO;
	}

	/**
	 * Convert {@link AccountVO} value object to the {@link Account} entity instance.
	 * 
	 * @param accountVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public Account convertAccountVOToEntity (AccountVO accountVO) {

		Account account = null;

		if (accountVO != null) {

			account = new Account();
			account.setId(accountVO.getId());
			account.setUsername(accountVO.getUsername());
			account.setPassword(accountVO.getPassword());
		}

		return account;
	}

	/**
	 * Convert list of {@link AccountVO} value objects to the list of {@link Account} entity
	 * instances.
	 * 
	 * @param accountsVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Account> convertAccountsVOToEntities (List<AccountVO> accountsVO) {

		List<Account> accounts = new ArrayList<>();

		if (accountsVO != null && accountsVO.size() > 0) {
			for (AccountVO accountVO : accountsVO) {
				accounts.add(convertAccountVOToEntity(accountVO));
			}
		}

		return accounts;
	}
}
