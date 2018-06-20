    import javax.swing.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;

    public class frmDadosTurma {
    private JLabel lblHorarioTurma;
    private JTextField txtHorarioTurma;
    private JTextField txtMaxPessoas;
    private JLabel lblMaxPessoas;
    private JTextField txtAtividadeTurma;
    private JLabel lblAtividadeTurma;
    private JButton btnSalvarTurma;
    private JPanel telaDadosTurma;

        public frmDadosTurma() {
            btnSalvarTurma.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    super.mouseClicked(mouseEvent);
                    String horario = txtHorarioTurma.getText();
                    String atividade = txtAtividadeTurma.getText();
                    String maxPessoas = txtMaxPessoas.getText();
                    if(!horario.isEmpty() && !atividade.isEmpty() && !maxPessoas.isEmpty()){
                        Gerenciador.incluirTurma(atividade, horario, Integer.parseInt(maxPessoas));
                        txtAtividadeTurma.setText("");
                        txtHorarioTurma.setText("");
                        txtMaxPessoas.setText("");
                    }
                }
            });
        }

        public JPanel getTelaDadosTurma() {
        return telaDadosTurma;
    }
}
