import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAlteraCliente {
    private JPanel telaAlteraCliente;
    private JTextField txtAlteraNome;
    private JTextField txtAlteraRg;
    private JTextField txtAlteraNascimento;
    private JTextField txtAlteraTelefone;
    private JTextField txtAlteraEndereco;
    private JButton alterarButton;

    public frmAlteraCliente() {
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String nome = txtAlteraNome.getText();
                String rg = txtAlteraRg.getText();
                String nascimento = txtAlteraNascimento.getText();
                String telefone = txtAlteraTelefone.getText();
                String endereco = txtAlteraEndereco.getText();
                if(!nome.isEmpty() && !rg.isEmpty() && !nascimento.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty()){
                    Gerenciador.alterarCliente(rg, nome, endereco, telefone, nascimento, null);
                    txtAlteraNome.setText("");
                    txtAlteraEndereco.setText("");
                    txtAlteraNascimento.setText("");
                    txtAlteraRg.setText("");
                    txtAlteraTelefone.setText("");
                }
            }
        });
    }
}
