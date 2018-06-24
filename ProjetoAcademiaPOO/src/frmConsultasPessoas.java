import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmConsultasPessoas {
    private JPanel panelTelaConsultasPessoas;
    private JTextField atividadeTextField;
    private JTextField turmaTextField;
    private JTextField quantidadeTextField;
    private JButton consultarButton;
    private JList list;
    private JButton limparFiltrosButton;
    private JLabel filtrarPorAtividadeLabel;
    private JLabel filtrarPorTurmaLabel;
    private JLabel quantidadeLabel;

    public frmConsultasPessoas() {
        String quantidadePessoas = Integer.toString(Gerenciador.exibirClientes().size());
        quantidadeTextField.setText(quantidadePessoas);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        consultarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                String filtroAtividade = atividadeTextField.getText();
                String filtroTurma = turmaTextField.getText();
                //Buscar as turmas e atividades aqui
            }
        });
        limparFiltrosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                turmaTextField.setText("");
                atividadeTextField.setText("");
            }
        });
    }

    public JPanel getPanelTelaConsultasPessoas() {
        return panelTelaConsultasPessoas;
    }
}
