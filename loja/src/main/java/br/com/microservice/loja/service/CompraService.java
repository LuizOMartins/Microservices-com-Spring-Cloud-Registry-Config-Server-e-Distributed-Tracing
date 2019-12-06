package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	//processamento da compra
	// fornecedor == destino entrega/compr
	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClielt;
	
	public void realizaCompra(CompraDTO compra) {
				
		ResponseEntity<InfoFornecedorDTO> exchange =  
				client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
						HttpMethod.GET, null, InfoFornecedorDTO.class);
				
//		eurekaClielt.getInstances("fornecedor").stream()
//		.forEach(fornecedor -> {
//			System.out.println("localhost:" + fornecedor.getPort());
//		});

		eurekaClielt.getInstances("fornecedor").stream()
		.forEach( (forne)  -> System.out.println("localhost: " + forne.getPort()));
		
		System.out.println(exchange.getBody().getEndereco());
		
	}	

}
