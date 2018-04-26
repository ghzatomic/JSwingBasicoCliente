package br.com.caio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import br.com.caio.dto.ClienteListaDTO;

public class ClienteView implements ClienteViewInterface {

	JFrame janela = new JFrame("Cadastro de Cliente");

	JPanel panelLista = new JPanel();
	JPanel panelCadastro = new JPanel();
	JPanel panelBotoes = new JPanel();
	JTable table = new JTable();
	
	private JPanel desenhaPanelLista() {
		
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		
		JScrollPane scroll = new JScrollPane(); 
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(table); 
		scroll.setSize(450, 450);

		
		// TESTE
		List<ClienteListaDTO> clientesTeste = new ArrayList<ClienteListaDTO>();
		clientesTeste.add(new ClienteListaDTO(1L, "Caio"));
		
		atualizaTabelaLista(clientesTeste);
		
		panelLista.add(scroll);
		return panelLista;
	}
	
	private void atualizaTabelaLista(List<ClienteListaDTO> lista){
		table.setModel(new ClientesTableModel(lista));
	}

	private JPanel desenhaPanelBotoes() {
		JButton btnSalvar = new JButton("Salvar");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnLimpar = new JButton("Limpar");

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(janela, "CLIQUEI NO SALVAR !!");
			}
		});

		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(janela, "CLIQUEI NO EXCLUIR !!");
			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(janela, "CLIQUEI NO LIMPAR !!");
			}
		});

		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnExcluir);
		panelBotoes.add(btnLimpar);

		return panelBotoes;
	}

	private JPanel desenhaPanelCadastro() {
		return panelCadastro;
	}

	private void desenhaTela() {
		//janela.setLayout(new GridLayout(3,0));
		janela.add(desenhaPanelLista(),BorderLayout.NORTH);
		janela.add(desenhaPanelCadastro(),BorderLayout.CENTER);
		janela.add(desenhaPanelBotoes(),BorderLayout.SOUTH);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		janela.setSize(500, 500);
	}

	public ClienteView() {
		desenhaTela();
	}

}
