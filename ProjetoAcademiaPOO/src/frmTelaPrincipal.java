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
    private JButton deslogarButton;
    private JButton associarPersonalButton;
    private static JFrame framePrincipal = new JFrame("Academia");

    public JPanel getTelaPrincipal() {
        return telaPrincipal;
    }

    public static JFrame getFramePrincipal() {
        return framePrincipal;
    }

    public frmTelaPrincipal() {
        cadastrarClienteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("CadastrarClientes");
                frame.setContentPane(new frmDadosCliente().getPrincipalDadosCliente());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        consultarPessoasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("ConsultarPessoas");
                frame.setContentPane(new frmConsultasPessoas().getPanelTelaConsultasPessoas());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        cadastrarAtividadeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("CadastrarAtividade");
                frame.setContentPane(new frmDadosAtividade().getTelaDadosAtividade());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        cadastrarInstrutorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("CadastrarInstrutor");
                frame.setContentPane(new frmDadosInstrutor().getTelaDadosInstrutor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        cadastrarTurmaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("CadastrarTurma");
                frame.setContentPane(new frmDadosTurma().getTelaDadosTurma());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        consultarAtividadesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("ConsultarAtividades");
                frame.setContentPane(new frmConsultasAtividades().getTelaConsultasAtividades());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        consultarTurmasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("ConsultarTurmas");
                frame.setContentPane(new frmConsultasTurmas().getTelaConsultasTurmas());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        associarDesassociarATurmaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("AssociarDesassociar");
                frame.setContentPane(new AssociarDesassociarATurma().getTelaAcoesTurma());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        deslogarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                Gerenciador.deslogar();
                frmLogin.openFrame();
                framePrincipal.setVisible(false);
            }
        });
        associarPersonalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                JFrame frame = new JFrame("AssociarPersonal");
                frame.setContentPane(new frmAssociaPersonal().getTelaPersonal());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
