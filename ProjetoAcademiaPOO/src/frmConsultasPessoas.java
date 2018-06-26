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
    	
    	Cliente[] arrayClientes = new Cliente[Gerenciador.exibirClientes().size()];
    	list.setListData(Gerenciador.exibirClientes().toArray(arrayClientes));
    	
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
                ArrayList<Cliente> filtro = Gerenciador.verificarClientesPorAtividadeTurma(atividade, turma);
                Cliente[] arrayClientes = new Cliente[filtro.size()];
            	list.setListData(filtro.toArray(arrayClientes));
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
