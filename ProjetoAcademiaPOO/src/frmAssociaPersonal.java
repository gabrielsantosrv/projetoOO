import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAssociaPersonal {
    private JTextField txtCliente;
    private JTextField txtPersonal;
    private JButton associarButton;
    private JPanel telaPersonal;

    public frmAssociaPersonal() {

        associarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaPersonal() {
        return telaPersonal;
    }
}
