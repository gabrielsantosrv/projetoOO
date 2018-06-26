import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AssociarDesassociarATurma {
    private JPanel telaAcoesTurma;
    private JButton associarButton;
    private JTextField txtRg;
    private JTextField txtTurma;
    private JTextField txtHorario;
    private JButton desassociarButton;

    public AssociarDesassociarATurma() {
        associarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String rg = txtRg.getText();
                String atividade = txtTurma.getText();
                String horario = txtHorario.getText();
                Gerenciador.relacionarTurmaCliente(rg, atividade, horario);
                Gerenciador.relacionarTurmaInstrutor(rg, atividade, horario);
            }
        });
    }

    public JPanel getTelaAcoesTurma() {
        return telaAcoesTurma;
    }
}
