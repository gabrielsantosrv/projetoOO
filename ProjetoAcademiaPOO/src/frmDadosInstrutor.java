import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosInstrutor {
    private JPanel telaDadosInstrutor;
    private JTextField txtNome;
    private JTextField txtRg;
    private JTextField txtNascimento;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtSalario;
    private JButton salvarButton;
    private JTextArea listaAreas;

    public frmDadosInstrutor() {
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaDadosInstrutor() {
        return telaDadosInstrutor;
    }
}
