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

    public Atividade encontrarAtividade(String nome) {
        for(Atividade a : this.atividades) {
            if (a.getNome().equalsIgnoreCase(nome))
                return a;
        }
        return null;
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

    public boolean excluirAtividade(Atividade atividade){
        if (atividade == null)
            return false;
        //exclui todas as turmas da atividade antes de excluí-la
        for(Turma t : atividade.getTurmas()){
            excluirTurma(t, atividade);
        }

        this.atividades.remove(atividade);
        return true;
    }

    public boolean alterarAtividade(Atividade atividadeAnt, Atividade atividadeNova){
        if (atividadeAnt == null || atividadeNova == null)
            return false;

        for(int i=0; i< this.clientes.size(); i++){
            Atividade a = this.atividades.get(i);

            //troca quando achar o cliente antigo
            if(atividadeAnt.equals(a)){
                this.atividades.set(i, atividadeNova);
                return true;
            }
        }
        return false;
    }

    public Turma encontrarTurma(String id, Atividade atividade) {
        if (atividade == null)
            return null;
        for (Turma t : atividade.getTurmas())
            if (t.getId().equalsIgnoreCase(id))
                return t;
        return null;
    }

    public boolean incluirTurma(Turma turma, Atividade atividade){
        if (atividade == null || turma == null)
            return false;

        return atividade.adicionarTurma(turma);
    }

    public boolean excluirTurma(Turma turma, Atividade atividade){
        if (turma == null || atividade == null)
            return false;

        for(Cliente c: turma.getClientes()){
            c.removerTurma(turma);
        }

        for(Instrutor i: turma.getInstrutores()){
            i.removerTurma(turma);
        }

        atividade.removerTurma(turma);
        return true;
    }

    public boolean alterarTurma(Turma turmaAnt, Turma turmaNova, Atividade atividade){
        if (turmaAnt == null || turmaNova == null || atividade == null)
            return false;

        for(int i=0; i< atividade.getTurmas().size(); i++){
            Turma t = atividade.getTurmas().get(i);

            //troca quando achar o cliente antigo
            if(turmaAnt.equals(t)){
                turmaNova.setPrecoAtividade(atividade.getPreco());
                atividade.getTurmas().set(i, turmaNova);
                return true;
            }
        }
        return false;
    }
}
