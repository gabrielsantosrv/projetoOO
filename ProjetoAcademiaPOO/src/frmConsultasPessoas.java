import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmConsultasPessoas {
    private JPanel panelTelaConsultasPessoas;
    private JTextField atividadeTextField;
    private JTextField turmaTextField;
    private JTextField quantidadeTextField;
    private JButton consultarButton;
    private JList list;
    private JButton limparFiltrosButton;
    private JLabel filtrarPorAtividadeLabel;
    private JLabel filtrarPorTurmaLabel;
    private JLabel quantidadeLabel;

    public frmConsultasPessoas() {
        list.addMouseListener(new MouseAdapter() {
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

    public JPanel getPanelTelaConsultasPessoas() {
        return panelTelaConsultasPessoas;
    }
}
