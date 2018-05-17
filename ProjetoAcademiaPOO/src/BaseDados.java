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

    public void incluirCliente(Cliente cliente){
        boolean clienteExistente = false;

        for(Cliente c: this.clientes){
            if(c.equals(cliente)){
                clienteExistente = true;
                break;
            }
        }

        if (!clienteExistente) {
            this.clientes.add(cliente);
        }
    }

    public void excluirCliente(Cliente cliente){
        cliente.setAtivo(false);
    }

    public void alterarCliente(Cliente clienteAnt, Cliente clienteNovo){
        for(int i=0; i< this.clientes.size(); i++){
            Cliente c = this.clientes.get(i);

            //troca quando achar o cliente antigo
            if(clienteAnt.equals(c) && clienteAnt.isAtivo()){
              clientes.set(i, clienteNovo);
            }
        }
    }

    public void incluirInstrutor(Instrutor instrutor){
        boolean instrutorExistente = false;

        for(Instrutor i: this.instrutores){
            if(i.equals(instrutor)){
                instrutorExistente = true;
                break;
            }
        }

        if (!instrutorExistente) {
            this.instrutores.add(instrutor);
        }
    }

    public void excluirInstrutor(Instrutor instrutor){
        instrutor.setAtivo(false);
    }

    public void alterarInstutor(Instrutor instrutorAnt, Instrutor instrutorNovo){
        for(int i=0; i< this.instrutores.size(); i++){
            Instrutor inst = this.instrutores.get(i);

            //troca quando achar o cliente antigo
            if(instrutorAnt.equals(inst) && instrutorAnt.isAtivo()){
                this.instrutores.set(i, instrutorNovo);
            }
        }
    }

    public void incluirAtividade(Atividade atividade){
        boolean atividadeExistente = false;

        for(Atividade a: this.atividades){
            if(a.equals(atividade)){
                atividadeExistente = true;
                break;
            }
        }

        if (!atividadeExistente) {
            this.atividades.add(atividade);
        }
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
