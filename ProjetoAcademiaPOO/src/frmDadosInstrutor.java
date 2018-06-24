import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDadosInstrutor {
    private JPanel telaDadosInstrutor;
    private JTextField txtNome;
    private JTextField txtRg;
    private JTextField txtNascimento;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtSalario;
    private JButton salvarButton;
    private JTextArea listaAreas;
    private JComboBox comboTipo;

    public frmDadosInstrutor() {
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String nome = txtNome.getText();
                String rg = txtRg.getText();
                String nascimento = txtNascimento.getText();
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();
                String salario = txtSalario.getText();
                String[] areas = listaAreas.getText().split(";");
                String tipoInstrutor = (String) comboTipo.getSelectedItem();
                if(!nome.isEmpty() && !rg.isEmpty() && !nascimento.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty() && !salario.isEmpty() && areas.length != 0 && !tipoInstrutor.isEmpty()){
                    switch (tipoInstrutor){
                        case "Diário":
                            Gerenciador.incluirInstrutorDiario(Gerenciador.getLoginAtual(), rg, nome, endereco, telefone, nascimento, Float.valueOf(salario), areas);

                        break;

                    }
                }
            }
        });
    }

    public JPanel getTelaDadosInstrutor() {
        return telaDadosInstrutor;
    }

    public void populaAreasNaLista(){

    }
}
