package br.com.caio.model;

import java.util.List;

import br.com.caio.dto.ClienteDTO;
import br.com.caio.dto.ClienteListaDTO;

public interface ClienteRepositoryInterface {

	void salvar(ClienteDTO dto);

	void excluir(Long id);

	List<ClienteListaDTO> buscarTodos();

	ClienteDTO buscarCliente(Long id);

}