package br.com.caio.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClienteView implements ClienteViewInterface {

	JFrame janela = new JFrame("Cadastro de Cliente");

	JPanel panelLista = new JPanel();
	JPanel panelCadastro = new JPanel();
	JPanel panelBotoes = new JPanel();
	
	
	private JPanel desenhaPanelLista(){
		return panelLista;
	}
	
	private JPanel desenhaPanelBotoes(){
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
	
	private JPanel desenhaPanelCadastro(){
		return panelCadastro;
	}
	
	private void desenhaTela(){
		janela.add(desenhaPanelLista());
		janela.add(desenhaPanelCadastro());
		janela.add(desenhaPanelBotoes());
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//janela.pack();
		janela.setVisible(true);
		janela.setSize(500, 500);
	}
	
	public ClienteView() {
		desenhaTela();
	}
	
}
