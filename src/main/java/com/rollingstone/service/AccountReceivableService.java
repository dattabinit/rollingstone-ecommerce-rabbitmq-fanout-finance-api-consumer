package com.rollingstone.service;

import org.springframework.data.domain.Page;

import com.rollingstone.model.AccountRceivable;

public interface AccountReceivableService {

	AccountRceivable save(AccountRceivable accountRceivable); 
	AccountRceivable getAccountRceivable(long id);
	Page<AccountRceivable> getAccountRceivableByPage(Integer pageNumber, Integer pageSize);
	void update(AccountRceivable accountReceivable);
	void delete(long id);
}
