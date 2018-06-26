import javax.swing.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmConsultasAtividades {
    private JPanel telaConsultasAtividades;
    private JTextField atividadeComMaisClientesTextField;
    private JTextField atividadeComMenosClientesTextField;
    private JTextField atividadeComMaiorPrecoTextField;
    private JTextField atividadeComMenorPrecoTextField;
    private JList<Atividade> listaDeAtividadesList;
    private JLabel atividadeComMaisClientesLabel;
    private JLabel atividadeComMenosClientesLabel;
    private JLabel atividadeComMaiorPrecoLabel;
    private JLabel atividadeComMenorPrecoLabel;
    private JLabel listaDeAtividadesLabel;

    public frmConsultasAtividades() {
    	
    	Atividade atividadeComMaiorPreco = Gerenciador.atividadeComMaiorPreco();
    	Atividade atividadeComMaisClientes = Gerenciador.atividadeComMaisClientes();
    	Atividade atividadeComMenorPreco = Gerenciador.atividadeComMenorPreco();
    	Atividade atividadeComMenosClientes = Gerenciador.atividadeComMenosClientes();
		atividadeComMaiorPrecoTextField.setText(atividadeComMaiorPreco != null ? atividadeComMaiorPreco.getNome() : "");
		atividadeComMenosClientesTextField.setText(atividadeComMenosClientes != null ? atividadeComMenosClientes.getNome() : "");
		atividadeComMaisClientesTextField.setText(atividadeComMaisClientes != null ? atividadeComMaisClientes.getNome() : "");
		atividadeComMenorPrecoTextField.setText(atividadeComMenorPreco != null ? atividadeComMenorPreco.getNome() : "");
		Atividade[] arrayAtividade = new Atividade[Gerenciador.exibirAtividades().size()];
		listaDeAtividadesList.setListData(Gerenciador.exibirAtividades().toArray(arrayAtividade));
		listaDeAtividadesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

            }
        });
    }

    public JPanel getTelaConsultasAtividades() {
        return telaConsultasAtividades;
    }
}
