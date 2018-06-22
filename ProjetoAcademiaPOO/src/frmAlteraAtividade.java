import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAlteraAtividade {
    private JPanel telaAlteraAtividade;
    private JLabel lblNome;
    private JTextField txtAlteraNome;
    private JLabel lblPreco;
    private JTextField txtAlteraPreco;
    private JButton alterarButton;

    public frmAlteraAtividade() {
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String nome = txtAlteraNome.getText();
                String preco = txtAlteraPreco.getText();
                if(!preco.isEmpty() && !nome.isEmpty()){
                    Gerenciador.alterarAtividade(nome, Float.valueOf(preco));
                    txtAlteraNome.setText("");
                    txtAlteraPreco.setText("");
                }
                
            }
        });
    }
}
