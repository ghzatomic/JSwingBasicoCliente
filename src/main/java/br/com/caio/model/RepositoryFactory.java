package br.com.caio.model;

public class RepositoryFactory {

	public static ClienteRepositoryInterface criaClienteRepository(){
		return new ClienteRepository();
	}
	
}
