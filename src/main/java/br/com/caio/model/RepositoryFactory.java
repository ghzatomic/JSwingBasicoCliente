package br.com.caio.model;

public class RepositoryFactory {

	public static ClienteRepositoryInterface criaClienteService(){
		return new ClienteRepository();
	}
	
}
