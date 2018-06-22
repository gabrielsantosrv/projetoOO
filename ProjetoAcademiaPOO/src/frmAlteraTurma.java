import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAlteraTurma {
    private JPanel telaAlteraTurma;
    private JButton alterarButton;
    private JTextField txtAlteraHorario;
    private JTextField txtAlteraMaxPessoas;
    private JTextField txtAlteraAtividade;

    public frmAlteraTurma() {
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String horario = txtAlteraHorario.getText();
                String maxPessoas = txtAlteraMaxPessoas.getText();
                String atividade = txtAlteraAtividade.getText();
                if(!horario.isEmpty() && !maxPessoas.isEmpty() && !atividade.isEmpty()){
                    Gerenciador.alterarTurma(atividade, horario, Integer.parseInt(maxPessoas));
                    txtAlteraHorario.setText("");
                    txtAlteraAtividade.setText("");
                    txtAlteraMaxPessoas.setText("");
                }
            }
        });
    }
}
