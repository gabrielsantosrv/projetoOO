import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosUsuario {
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JTextField txtUsuario;
    private JTextField txtSenha;

    public frmDadosUsuario() {
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }
}
