import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAlteraCliente {
    private JPanel telaAlteraCliente;
    private JTextField txtAlteraNome;
    private JTextField txtAlteraRg;
    private JTextField txtAlteraNascimento;
    private JTextField txtAlteraTelefone;
    private JTextField txtAlteraEndereco;
    private JButton alterarButton;

    public frmAlteraCliente() {
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }
}
