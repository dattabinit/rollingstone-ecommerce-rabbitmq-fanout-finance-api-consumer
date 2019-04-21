package com.rollingstone.rabbitmq.consumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rollingstone.model.AccountRceivable;
import com.rollingstone.model.SalesOrderDTO;
import com.rollingstone.service.AccountReceivableService;

@Service
public class SalesOrderRabbitMQMessageConsumerListerner {

	final static Logger logger  = LoggerFactory.getLogger(SalesOrderRabbitMQMessageConsumerListerner.class);
	
	private AccountReceivableService accountReceivableService;
	
	public SalesOrderRabbitMQMessageConsumerListerner(AccountReceivableService accountReceivableService) {
		this.accountReceivableService = accountReceivableService;
	}
	
	@RabbitListener(queues = "${accounts-receivable.queue.name}")
	public void receiveMessageForFinanceConsumerFromSalesProducer(final SalesOrderDTO salesOrderDTO) {
		logger.info("Received message from Sales Order Producer Application :"+salesOrderDTO.toString());
		
		try {
			retrieveDataForAccountReceivavleAndSave(salesOrderDTO);
		}
		catch(Exception e) {
			logger.info("Exception occured during message receipt and processing : "+e.getLocalizedMessage());
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
	
	private void retrieveDataForAccountReceivavleAndSave(SalesOrderDTO salesOrderDTO) {
		
		String transactionNumber = "TRNSLS"+salesOrderDTO.getOrderNumber();
		
		long accountId = salesOrderDTO.getAccount().getId();
		
		long userId = salesOrderDTO.getAccount().getUser().getId();
		
		long salesOrderId = salesOrderDTO.getId();
		
		Date transactionDate  = salesOrderDTO.getSalesDate();
		
		double transactionAmount = salesOrderDTO.getTotalOrderAmount();
		
		long salesRepId = salesOrderDTO.getEmployee().getId();
		
		AccountRceivable accountRceivable = new AccountRceivable(transactionNumber,accountId,userId,salesOrderId,transactionDate,transactionAmount,salesRepId);
		
		accountReceivableService.save(accountRceivable);
	}

}
