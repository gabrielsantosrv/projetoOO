import java.util.ArrayList;

public class BaseDados {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Atividade> atividades;

    public BaseDados(){
        clientes = new ArrayList<>();
        instrutores = new ArrayList<>();
        atividades = new ArrayList<>();
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public ArrayList<Cliente> getClientes() { return clientes; }

    public ArrayList<Instrutor> getInstrutores() { return instrutores; }

    public  Atividade atividadeComMaisInscritos() {
        int inscritos = 0;
        Atividade comMaisInscritos = new Atividade("", 0);
        for (Atividade a : atividades) {
            if (a.quantosInscritos() > inscritos) {
                inscritos = a.quantosInscritos();
                comMaisInscritos = a;
            }
        }
        return comMaisInscritos;
    }

    public  Atividade atividadeComMenosInscritos() {
        //TODO
        return new Atividade("", 0);
    }

    public  Atividade atividadeComMaiorPreco() {
        //TODO
        return new Atividade("", 0);
    }

    public  Atividade atividadeComMenorPreco() {
        //TODO
        return new Atividade("", 0);
    }

    public void exibirAtividades() {
        System.out.println("EXIBIÇÃO DE ATIVIDADES");
        for (Atividade a : atividades) {
            System.out.println(a.toString());
        }
    }

    public void exibirClientes() {
        System.out.println("EXIBIÇÃO DE CLIENTES");
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    public void exibirInstrutores() {
        System.out.println("EXIBIÇÃO DE INSTRUTORES");
        for (Instrutor i : instrutores) {
            System.out.println(i.toString());
        }
    }

    public void exibirTurmasPorAtividade() {
        System.out.println("EXIBIÇÃO DE TURMAS POR ATIVIDADE");
        for (Atividade a : atividades) {
            System.out.println(a.toString());
            System.out.println("Turmas:");
            for (Turma t : a.getTurmas()) {
                System.out.println(t.toString());
            }
        }
    }

    public boolean clienteExistente(Cliente cliente) {
        for(Cliente c: this.clientes){
            if(c.equals(cliente)){
                return true;
            }
        }
        return false;
    }

    public Cliente encontrarCliente(String rg) {
        for(Cliente c: this.clientes){
            if(c.getRg().equals(rg)){
                return c;
            }
        }
        return null;
    }

    public boolean incluirCliente(Cliente cliente){
        if (!clienteExistente(cliente)) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean desativarCliente(Cliente cliente){
        if (cliente != null) {
            cliente.setAtivo(false);
            return true;
        }
        return false;
    }

    public boolean alterarCliente(Cliente clienteAnt, Cliente clienteNovo){
        if (clienteAnt == null || clienteNovo == null)
            return false;

        for(int i=0; i< this.clientes.size(); i++){
            Cliente c = this.clientes.get(i);

            //troca quando achar o cliente antigo
            if(clienteAnt.equals(c) && clienteAnt.isAtivo()){
              clientes.set(i, clienteNovo);
              return true;
            }
        }
        return false;
    }

    public boolean instrutorExistente(Instrutor instrutor) {
        for(Instrutor i: this.instrutores){
            if(i.equals(instrutor)){
                return true;
            }
        }
        return false;
    }

    public Instrutor encontrarInstrutor(String rg) {
        for(Instrutor i: this.instrutores){
            if(i.getRg().equals(rg)){
                return i;
            }
        }
        return null;
    }

    public boolean incluirInstrutor(Instrutor instrutor){
        if (!instrutorExistente(instrutor)) {
            this.instrutores.add(instrutor);
            return true;
        }
        return false;
    }

    public boolean desativarInstrutor(Instrutor instrutor){
        if (instrutor!=null) {
            instrutor.setAtivo(false);
            return true;
        }
        return false;
    }

    public boolean alterarInstutor(Instrutor instrutorAnt, Instrutor instrutorNovo){
        if (instrutorAnt == null || instrutorNovo == null)
            return false;

        for(int i=0; i< this.instrutores.size(); i++){
            Instrutor inst = this.instrutores.get(i);

            //troca quando achar o cliente antigo
            if(instrutorAnt.equals(inst) && instrutorAnt.isAtivo()){
                this.instrutores.set(i, instrutorNovo);
                return true;
            }
        }
        return false;
    }

    public boolean incluirAtividade(Atividade atividade){
        boolean atividadeExistente = false;

        for(Atividade a: this.atividades){
            if(a.equals(atividade)){
                atividadeExistente = true;
                break;
            }
        }

        if (!atividadeExistente) {
            this.atividades.add(atividade);
            return true;
        }
        return false;
    }

    public void excluirAtividade(Atividade atividade){
        //exclui todas as turmas da atividade antes de excluí-la
        for(Turma t : atividade.getTurmas()){
            excluirTurma(t, atividade);
        }

        this.atividades.remove(atividade);
    }

    public void alterarAtividade(Atividade atividadeAnt, Atividade atividadeNova){
        for(int i=0; i< this.clientes.size(); i++){
            Atividade a = this.atividades.get(i);

            //troca quando achar o cliente antigo
            if(atividadeAnt.equals(a)){
                this.atividades.set(i, atividadeNova);
            }
        }
    }

    public void incluirTurma(Turma turma, Atividade atividade){
        atividade.adicionarTurma(turma);
    }

    public void excluirTurma(Turma turma, Atividade atividade){
        for(Cliente c: turma.getClientes()){
            c.removerTurma(turma);
        }

        for(Instrutor i: turma.getInstrutores()){
            i.removerTurma(turma);
        }

        atividade.removerTurma(turma);
    }

    public void alterarTurma(Turma turmaAnt, Turma turmaNova, Atividade atividade){
        for(int i=0; i< atividade.getTurmas().size(); i++){
            Turma t = atividade.getTurmas().get(i);

            //troca quando achar o cliente antigo
            if(turmaAnt.equals(t)){
                atividade.getTurmas().set(i, turmaNova);
            }
        }
    }
}
