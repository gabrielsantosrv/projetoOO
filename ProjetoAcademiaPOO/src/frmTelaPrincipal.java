import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmTelaPrincipal {
    private JButton cadastrarClienteButton;
    private JButton consultarPessoasButton;
    private JButton associarDesassociarATurmaButton;
    private JButton cadastrarInstrutorButton;
    private JButton cadastrarAtividadeButton;
    private JButton cadastrarTurmaButton;
    private JButton consultarAtividadesButton;
    private JButton consultarTurmasButton;
    private JPanel telaPrincipal;

    public static void main(String args[]){
        JFrame frame = new JFrame("Academia");
        frame.setContentPane(new frmTelaPrincipal().telaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public frmTelaPrincipal() {
        cadastrarClienteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                frmDadosCliente cliente = new frmDadosCliente();
                //cliente.principalDadosCliente.setVisible(true);
            }
        });
    }
}
