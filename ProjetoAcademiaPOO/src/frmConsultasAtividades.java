import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmConsultasAtividades {
    private JPanel telaConsultasAtividades;
    private JTextField atividadeComMaisClientesTextField;
    private JTextField atividadeComMenosClientesTextField;
    private JTextField atividadeComMaiorPrecoTextField;
    private JTextField atividadeComMenorPrecoTextField;
    private JList listaDeAtividadesList;
    private JLabel atividadeComMaisClientesLabel;
    private JLabel atividadeComMenosClientesLabel;
    private JLabel atividadeComMaiorPrecoLabel;
    private JLabel atividadeComMenorPrecoLabel;
    private JLabel listaDeAtividadesLabel;

    public frmConsultasAtividades() {
        listaDeAtividadesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
    }

    public JPanel getTelaConsultasAtividades() {
        return telaConsultasAtividades;
    }
}
