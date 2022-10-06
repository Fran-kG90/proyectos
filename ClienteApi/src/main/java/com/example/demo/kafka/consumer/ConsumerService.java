//package com.example.demo.kafka.consumer;
//
//import java.io.IOException;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.Dao.IClienteRepository;
//import com.example.demo.kafka.producer.Producer;
//import com.example.demo.model.Cliente;
//
//
//@Service
//public final class ConsumerService {
//
//	private final IClienteRepository clienteRepository;
//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
//	public ConsumerService(IClienteRepository clienteRepository) {
//		this.clienteRepository = clienteRepository;
//	}
//
//	@KafkaListener(topics = "rest-spring-boot-integration", containerFactory = "kafkaListenerContainerFactory")
//	public void consume(String message) {
//		Cliente cliente = new Cliente();
//		cliente.setApellidos(message);
//		cliente.setCorreo_electronico(message);
//		cliente.setNombre(message);
//		cliente.setNombre_usuario(message);
//		cliente.setPassword(message);
//		clienteRepository.save(cliente);
//	}
//
//	
//	 @KafkaListener(topics = "rest-spring-boot-integration", groupId = "kafkaListenerContainerFactory")
//	    public void consumeUpdate(String message) throws IOException {
//	        logger.info(String.format("#### -> Consumed message -> %s", message));
//	    }
//
//}
