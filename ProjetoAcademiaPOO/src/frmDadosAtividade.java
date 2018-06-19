import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosAtividade {
    private JLabel lblNomeAtividade;
    private JTextField txtNomeAtividade;
    private JLabel lblPrecoAtividade;
    private JTextField txtPrecoAtividade;
    private JButton btnSalvarAtividade;
    private JPanel telaDadosAtividade;

    public frmDadosAtividade() {
        btnSalvarAtividade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaDadosAtividade() {
        return telaDadosAtividade;
    }
}
