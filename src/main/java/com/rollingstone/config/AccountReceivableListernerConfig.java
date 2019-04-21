package com.rollingstone.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class AccountReceivableListernerConfig {

	@Value("${accounts-receivable.exchange.name}")
	private String accountReceivableExchangeName;
	
	@Value("${accounts-receivable.queue.name}")
	private String accountReceivableQueueName;
	
	@Value("${accounts-receivable.routing.name.key}")
	private String accountReceivableRoutingKeyName;
	
	@Bean
	public FanoutExchange getAccountSalesOrderFanoutExchange() {
		return new FanoutExchange(accountReceivableExchangeName);
	}
	
	@Bean
	public Queue getAccountReceivableQueue() {
		return new Queue(accountReceivableQueueName);
	}
	
	@Bean
	public Binding bindAccountQueueForExchange() {
		return BindingBuilder.bind(getAccountReceivableQueue()).to(getAccountSalesOrderFanoutExchange());
	}
	
	@Bean
	public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
	@Bean 
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFacotry() {
		DefaultMessageHandlerMethodFactory factory  = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}
	
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFacotry());
	}
}
