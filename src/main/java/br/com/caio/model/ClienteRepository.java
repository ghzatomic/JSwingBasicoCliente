package br.com.caio.model;

import java.util.List;

import br.com.caio.dto.ClienteDTO;
import br.com.caio.dto.ClienteListaDTO;

public class ClienteRepository implements ClienteRepositoryInterface {

	/* (non-Javadoc)
	 * @see br.com.caio.service.ClienteServiceInterface#salvar(br.com.caio.dto.ClienteDTO)
	 */
	public void salvar(ClienteDTO dto) {
		System.out.println("AQUI");
	}

	/* (non-Javadoc)
	 * @see br.com.caio.service.ClienteServiceInterface#excluir(java.lang.Long)
	 */
	public void excluir(Long id) {
	}

	/* (non-Javadoc)
	 * @see br.com.caio.service.ClienteServiceInterface#buscarTodos()
	 */
	public List<ClienteListaDTO> buscarTodos() {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.caio.service.ClienteServiceInterface#buscarCliente(java.lang.Long)
	 */
	public ClienteDTO buscarCliente(Long id) {
		return null;
	}

}
