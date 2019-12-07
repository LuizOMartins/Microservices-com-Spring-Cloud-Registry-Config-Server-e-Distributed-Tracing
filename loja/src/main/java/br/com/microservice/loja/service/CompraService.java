package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

	@Service
	public class CompraService {
		
		@Autowired
		private FornecedorClient forncedorClient;
		
		//processamento da compra
		// fornecedor == destino entrega/compra		
//		@Autowired
//		private RestTemplate client;
		
//		@Autowired
//		private DiscoveryClient eurekaClient; //client eureka 
		
		public void realizaCompra(CompraDTO compra) {
			
			InfoFornecedorDTO info = forncedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
					
//			ResponseEntity<InfoFornecedorDTO> exchange =  
//					client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
//							HttpMethod.GET, null, InfoFornecedorDTO.class);
//			
//			eurekaClient.getInstances("fornecedor").stream().forEach((forne) ->  System.out.println("localhost: " + forne.getPort()));
//			
			System.out.println(info.getEndereco());	
		}
	}