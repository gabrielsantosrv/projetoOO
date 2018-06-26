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
            }
        });
    }

    public JPanel getTelaAcoesTurma() {
        return telaAcoesTurma;
    }
}
