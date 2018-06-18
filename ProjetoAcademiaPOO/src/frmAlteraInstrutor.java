import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAlteraInstrutor {
    private JPanel telaAlteraInstrutor;
    private JList list1;
    private JTextField txtAlteraNome;
    private JTextField txtAlteraRg;
    private JTextField txtAlteraNascimento;
    private JTextField txtAlteraTelefone;
    private JTextField txtAlteraEndereco;
    private JTextField txtAlteraSalario;
    private JButton alterarButton;

    public frmAlteraInstrutor() {
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }
}
