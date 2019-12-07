package br.com.microservice.loja.model;

public class Compra {
	
	private Long pedidoID;
	private Integer tempoDePreparo; 
	private String enderecoDestino;
	public Long getPedidoID() {
		return pedidoID;
	}
	public void setPedidoID(Long pedidoID) {
		this.pedidoID = pedidoID;
	}
	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}
	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}
	public String getEnderecoDestino() {
		return enderecoDestino;
	}
	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

}
