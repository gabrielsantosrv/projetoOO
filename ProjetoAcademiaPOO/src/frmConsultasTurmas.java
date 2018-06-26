import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class frmConsultasTurmas {
    private JPanel telaConsultasTurmas;
    private JTextField atividadeTextField;
    private JTextField clienteTextField;
    private JButton consultarButton;
    private JButton limparFiltrosButton;
    private JTextField instrutorTextField;
    private JLabel atividadeLabel;
    private JLabel filtrarPorClienteLabel;
    private JLabel filtrarPorInstrutorLabel;
    private JList<Turma> list1;

    public frmConsultasTurmas() {

        telaConsultasTurmas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        consultarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String txtAtividade = atividadeTextField.getText();
                Atividade atividade = Gerenciador.buscaAtividadePorNome(txtAtividade).get(0);
                ArrayList<Turma> turmasPorAtividade = Gerenciador.exibirTurmasPorAtividade(atividade);
                int sizeArrayTurma = Gerenciador.exibirTurmasPorAtividade(Gerenciador.buscaAtividadePorNome(txtAtividade).get(0)).size();
                if(!atividadeTextField.getText().isEmpty()){
                    Turma[] arrayTurma = new Turma[sizeArrayTurma];
                    list1.setListData(turmasPorAtividade.toArray(arrayTurma));
                }
            }
        });
        limparFiltrosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaConsultasTurmas() {
        return telaConsultasTurmas;
    }
}
