import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

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
                            Gerenciador.incluirInstrutorDiario(Gerenciador.getLoginAtual(), rg, nome, endereco, telefone, nascimento, Float.valueOf(salario), 0, new ArrayList<>(Arrays.asList(areas)));
                        break;
                        case "Horário":
                            Gerenciador.incluirInstrutorHorario(Gerenciador.getLoginAtual(), rg, nome, endereco, telefone, nascimento, Float.valueOf(salario), 0, new ArrayList<>(Arrays.asList(areas)));
                        break;
                        case "Personal":
                            Gerenciador.incluirInstrutorPersonal(Gerenciador.getLoginAtual(), rg, nome, endereco, telefone, nascimento, Float.valueOf(salario), new ArrayList<>(Arrays.asList(areas)));
                        break;
                    }
                    txtNome.setText("");
                    txtRg.setText("");
                    txtNascimento.setText("");
                    txtTelefone.setText("");
                    txtEndereco.setText("");
                    txtSalario.setText("");
                    listaAreas.setText("");
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
