package com.rollingstone.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.model.AccountRceivable;

public interface AccountReceivableDaoRepository extends PagingAndSortingRepository<AccountRceivable, Long> {

	Page<AccountRceivable> findAll(Pageable pageable);
	
	//@Query(name = "AccountReceivableDaoRepository.getAccountRceivableByID", nativeQuery = true)
	//AccountRceivable getAccountRceivableByID(@Param("id") long id);
}
