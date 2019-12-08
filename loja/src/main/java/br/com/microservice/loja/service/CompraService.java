package br.com.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.microservice.loja.model.Compra;

	@Service
	public class CompraService {
		
		private static final Logger LOG  = LoggerFactory.getLogger(CompraService.class);
		
	    
		
		@Autowired
		private FornecedorClient fornecedorClient;
		
		//processamento da compra
		// fornecedor == destino entrega/compra		
//		@Autowired
//		private RestTemplate client;
		
//		@Autowired
//		private DiscoveryClient eurekaClient; //client eureka 
		
		public Compra realizaCompra(CompraDTO compra) {
			final String estado = compra.getEndereco().getEstado();
			
			LOG.info("Buscando informações do fornecedor de {}", estado);
			InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
			
			LOG.info("realizando um pedido");
			InfoPedidoDTO pedido  = fornecedorClient.realizaPedido(compra.getItens());					
//			ResponseEntity<InfoFornecedorDTO> exchange =  
//					client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
//							HttpMethod.GET, null, InfoFornecedorDTO.class);
//			
//			eurekaClient.getInstances("fornecedor").stream().forEach((forne) ->  System.out.println("localhost: " + forne.getPort()));
			System.out.println(info.getEndereco());	
			
			Compra  compraSalva  = new Compra();
			compraSalva.setPedidoID(pedido.getId());
			compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
			compraSalva.setEnderecoDestino(compra.getEndereco().toString());
			
			return compraSalva;
		}
	}