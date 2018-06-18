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
            }
        });
    }
}
