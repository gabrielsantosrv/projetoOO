import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmTelaPrincipal {
    private JButton cadastrarClienteButton;
    private JButton consultarClientesButton;
    private JButton associarClientesÀTurmaButton;
    private JButton cadastrarInstrutorButton;
    private JButton cadastrarAtividadeButton;
    private JButton cadastrarTurmaButton;
    private JButton consultarInstrutoresButton;
    private JButton consultarAtividadesButton;
    private JButton consultarTurmasButton;
    private JButton associarInstrutoresÀTurmaButton;
    private JButton turmasPorAtividadeButton;
    private JButton clientesPorAtividadeButton;
    private JButton instrutoresPorAtividadeButton;
    private JButton clientesPorTurmaButton;
    private JButton turmasPorClienteButton;
    private JButton turmasPorInstrutorButton;
    private JButton desassociarClienteETurmaButton;
    private JButton desassociarInstrutorETurmaButton;
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
