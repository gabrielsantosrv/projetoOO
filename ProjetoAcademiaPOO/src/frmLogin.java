import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmLogin {
    private JPanel telaLogin;
    private JPasswordField txtPassword;
    private JTextField txtUsername;
    private JButton logarButton;
    private static JFrame frameLogin = new JFrame("Login");

    public frmLogin() {
        logarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (Gerenciador.logar(txtUsername.getText(), txtPassword.getText())) {
                    abrirTelaPrincipal();
                    limpaCampos();
                    closeFrame();
                }
            }
        });
    }

    public JPanel getTelaLogin() {
        return telaLogin;
    }

    public JFrame getFrameLogin() {
        return frameLogin;
    }

    public static void openFrame(){
        frameLogin.setVisible(true);
    }

    public static void closeFrame(){
        frameLogin.setVisible(false);
    }

    public void abrirTelaPrincipal(){
        JFrame frame = frmTelaPrincipal.getFramePrincipal();
        frame.setContentPane(new frmTelaPrincipal().getTelaPrincipal());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void limpaCampos(){
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public static void main(String args[]){
        frameLogin.setContentPane(new frmLogin().getTelaLogin());
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.pack();
        frameLogin.setVisible(true);
        //Abaixo sera na tela de login
        Admin admin = new Admin();
        Gerenciador.incluirUsuario(admin ,"admin", "admin", Permissoes.ADMIN);
    }
}
