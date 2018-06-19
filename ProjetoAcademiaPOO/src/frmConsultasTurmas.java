import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmConsultasTurmas {
    private JPanel telaConsultasTurmas;
    private JTextField atividadeTextField;
    private JTextField clienteTextField;
    private JButton consultarButton;
    private JButton limparFiltrosButton;
    private JTextField instrutorTextField;
    private JLabel atividadeLabel;
    private JLabel filtrarPorClienteLabel;
    private JLabel filtrarPorInstrutorLabel;
    private JList list1;

    public frmConsultasTurmas() {
        telaConsultasTurmas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        consultarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        limparFiltrosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaConsultasTurmas() {
        return telaConsultasTurmas;
    }
}
