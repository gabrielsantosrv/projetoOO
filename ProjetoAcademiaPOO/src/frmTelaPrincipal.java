import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmTelaPrincipal {
    private JButton cadastrarClienteButton;
    private JButton consultarClientesButton;
    private JButton matricularClientesButton;
    private JButton cadastrarInstrutorButton;
    private JButton cadastrarAtividadeButton;
    private JButton cadastrarTurmaButton;
    private JButton consultarInstrutoresButton;
    private JButton consultarAtividadesButton;
    private JButton consultarTurmasButton;
    private JButton button1;

    private Gerenciador gerenciador = new Gerenciador("admin", "admin");


    public frmTelaPrincipal() {
        cadastrarClienteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                gerenciador.
            }
        });
    }
}
