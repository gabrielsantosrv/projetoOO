import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosCliente {
    public JPanel principalDadosCliente;
    private JTextField txtNome;
    private JTextField txtRg;
    private JTextField txtNascimento;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JButton salvarButton;

    public frmDadosCliente() {
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String nome = txtNome.getText();
                String rg = txtRg.getText();
                String nascimento = txtNascimento.getText();
                String telefone= txtTelefone.getText();
                String endereco = txtEndereco.getText();
                if(!nome.isEmpty() && !rg.isEmpty() && !nascimento.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty()){
                    Gerenciador.incluirCliente(rg, nome, endereco, telefone, nascimento, null);
                    txtEndereco.setText("");
                    txtNascimento.setText("");
                    txtNome.setText("");
                    txtRg.setText("");
                    txtTelefone.setText("");
                }

            }
        });
    }

    public JPanel getPrincipalDadosCliente() {
        return principalDadosCliente;
    }
}
