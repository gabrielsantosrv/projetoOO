import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosUsuario {
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JPanel telaLogin;

    public frmDadosUsuario() {
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if(!txtSenha.getText().isEmpty() && !txtUsuario.getText().isEmpty()){
                	Gerenciador.incluirUsuario(Gerenciador.getLoginAtual(), txtUsuario.getText(), txtSenha.getText(), comboBox1.getSelectedIndex() == 1 ? Permissoes.ADMIN : Permissoes.COMUM);
                	txtSenha.setText("");
                	txtUsuario.setText("");
                }
            }
        });
    }

    public JPanel getTelaLogin() {
        return telaLogin;
    }
}
