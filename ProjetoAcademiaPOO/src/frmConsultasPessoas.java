import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class frmConsultasPessoas {
    private JPanel panelTelaConsultasPessoas;
    private JTextField atividadeTextField;
    private JTextField turmaTextField;
    private JTextField quantidadeTextField;
    private JButton consultarButton;
    private JList<Pessoa> list;
    private JButton limparFiltrosButton;
    private JLabel filtrarPorAtividadeLabel;
    private JLabel filtrarPorTurmaLabel;
    private JLabel quantidadeLabel;

    public frmConsultasPessoas() {
    	
    	ArrayList<Pessoa> pessoas = new ArrayList<>();
    	pessoas.addAll(Gerenciador.exibirClientes());
    	pessoas.addAll(Gerenciador.exibirInstrutores());
    	Pessoa[] arrayPessoa = new Pessoa[pessoas.size()];
    	
    	list.setListData(pessoas.toArray(arrayPessoa));
    	quantidadeTextField.setText(""+pessoas.size());
    	
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        consultarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String atividade = atividadeTextField.getText();
                String turma = turmaTextField.getText();
                ArrayList<Pessoa> filtro = Gerenciador.verificarPessoasPorAtividadeTurma(atividade, turma);
                Pessoa[] arrayPessoas = new Pessoa[filtro.size()];
            	list.setListData(filtro.toArray(arrayPessoas));
            	quantidadeTextField.setText(""+filtro.size());
            }
        });
        limparFiltrosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                atividadeTextField.setText("");
                turmaTextField.setText("");
            }
        });
    }

    public JPanel getPanelTelaConsultasPessoas() {
        return panelTelaConsultasPessoas;
    }
}
