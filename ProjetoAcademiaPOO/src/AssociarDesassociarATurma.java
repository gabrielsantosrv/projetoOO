import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AssociarDesassociarATurma {
    private JPanel telaAcoesTurma;
    private JList listTurmas;
    private JList listAssociados;
    private JList listDesassociados;
    private JButton associarButton;
    private JButton desassociarButton;

    public AssociarDesassociarATurma() {
        associarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        desassociarButton.addMouseListener(new MouseAdapter() {
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
