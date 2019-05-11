package com.rollingstone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.AccountReceivableDaoRepository;
import com.rollingstone.model.AccountRceivable;

@Service
public class AccountRceivableServiceImpl implements AccountReceivableService {

	final static Logger logger  = LoggerFactory.getLogger(AccountRceivableServiceImpl.class);
	
	private AccountReceivableDaoRepository accountReceivableDaoRepository;
	
	public AccountRceivableServiceImpl(AccountReceivableDaoRepository accountReceivableDaoRepository) {
		this.accountReceivableDaoRepository = accountReceivableDaoRepository;
	}
	
	@Override
	public AccountRceivable save(AccountRceivable accountRceivable) {
		logger.info("This is the save method of AccountRceivableServiceImpl");
		logger.info("Account Model Received from SalesOrder Producer :"+ accountRceivable.toString());
		return accountReceivableDaoRepository.save(accountRceivable);
	}

	@Override
	public AccountRceivable getAccountRceivable(long id) {
	
		//AccountRceivable accountRceivable = accountReceivableDaoRepository.getAccountRceivableByID(id);
		
		Optional<AccountRceivable> accountRceivableOptional = accountReceivableDaoRepository.findById(id);
		
		AccountRceivable accountRceivable = accountRceivableOptional.get();

		return accountRceivable;
	}

	@Override
	public Page<AccountRceivable> getAccountRceivableByPage(Integer pageNumber, Integer pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("accountNumber").descending());
		return accountReceivableDaoRepository.findAll(pageable);
	}

	@Override
	public void update(AccountRceivable accountReceivable) {
		accountReceivableDaoRepository.save(accountReceivable);
		
	}

	@Override
	public void delete(long id) {
		accountReceivableDaoRepository.deleteById(id);
		
	}

}
