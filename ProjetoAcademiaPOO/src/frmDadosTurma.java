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
                }
            });
        }

        public JPanel getTelaDadosTurma() {
        return telaDadosTurma;
    }
}
