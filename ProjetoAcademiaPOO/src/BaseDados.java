import java.util.ArrayList;

public class BaseDados {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Atividade> atividades;
    private ArrayList<Logavel> logins;
    
    public BaseDados(){
        clientes = new ArrayList<>();
        instrutores = new ArrayList<>();
        atividades = new ArrayList<>();
        logins = new ArrayList<>();
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
        if(this.atividades.size() == 0) //nenhuma atividade registrada
            return null;

        int inscritos = 0;
        Atividade comMenosInscritos = new Atividade("", 0);
        inscritos = this.atividades.get(0).quantosInscritos();
        comMenosInscritos = this.atividades.get(0);

        for (Atividade a : atividades) {
            if (a.quantosInscritos() < inscritos) {
                inscritos = a.quantosInscritos();
                comMenosInscritos = a;
            }
        }

        return comMenosInscritos;
    }

    public Atividade atividadeComMaiorPreco(){
        if(this.atividades.size() == 0) //nenhuma atividade registrada
            return null;

        float preco = 0;
        Atividade maiorPreco = new Atividade("", 0);
        for (Atividade a : atividades) {
            if (a.getPreco() > preco) {
                preco = a.getPreco();
                maiorPreco = a;
            }
        }

        return maiorPreco;
    }

    public Atividade atividadeComMenorPreco(){
        if(this.atividades.size() == 0) //nenhuma atividade registrada
            return null;

        float preco = 0;
        Atividade menorPreco = new Atividade("", 0);
        preco = this.atividades.get(0).getPreco();
        menorPreco = this.atividades.get(0);
        for (Atividade a : atividades) {
            if (a.getPreco() < preco) {
                preco = a.getPreco();
                menorPreco = a;
            }
        }

        return menorPreco;
    }

    public boolean clienteExistente(Cliente cliente) {
        return this.clientes.stream().filter(c -> c.equals(cliente)).findAny().isPresent();
    }

    public Cliente encontrarCliente(String rg) {
    	try{
    		return this.clientes.stream().filter(c -> c.getRg().equals(rg)).findFirst().get();    		
    	}catch(Exception e){
    		return null;
    	}
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
    	return this.instrutores.stream().filter(i -> i.equals(instrutor)).findAny().isPresent();
    }

    public Instrutor encontrarInstrutor(String rg) {
    	try{
    		return this.instrutores.stream().filter(i -> i.getRg().equals(rg)).findFirst().get();    		
    	}catch(Exception e){
    		return null;
    	}
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
    	try{
    		return this.atividades.stream().filter(a -> a.getNome().equals(nome)).findFirst().get();    		
    	}catch(Exception e){
    		return null;
    	}
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

        for(int i=0; i< this.atividades.size(); i++){
            Atividade a = this.atividades.get(i);

            //troca quando achar o cliente antigo
            if(atividadeAnt.equals(a)){
                this.atividades.set(i, atividadeNova);
                return true;
            }
        }
        return false;
    }

    public Turma encontrarTurma(String horario, Atividade atividade) {
        if (atividade == null)
            return null;
        for (Turma t : atividade.getTurmas())
            if (t.getAtividade().equals(atividade) && t.getHorario().equals(horario))
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
                //turmaNova.setPrecoAtividade(atividade.getPreco());
                atividade.getTurmas().set(i, turmaNova);
                return true;
            }
        }
        return false;
    }

    public boolean relacionarTurmaInstrutor(Turma t, Instrutor i) {
        if (t == null || i == null)
            return false;
        t.adicionarInstrutor(i);
        i.adicionarTurma(t);
        return true;
    }

    public boolean desrelacionarTurmaInstrutor(Turma t, Instrutor i) {
        if (t == null || i == null)
            return false;
        t.removerInstrutor(i);
        i.removerTurma(t);
        return true;
    }

    public boolean relacionarTurmaCliente(Turma t, Cliente c) {
        if (t == null || c == null)
            return false;
        t.adicionarCliente(c);
        c.adicionarTurma(t);
        return true;
    }

    public boolean desrelacionarTurmaCliente(Turma t, Cliente c) {
        if (t == null || c == null)
            return false;
        t.removerCliente(c);
        c.removerTurma(t);
        return true;
    }
    
    public boolean insereLogin(Logavel login){
    	return this.logins.add(login);
    }

	public ArrayList<Logavel> getLogins() {
		return logins;
	}
	
	public boolean removeLogin(Logavel login){
		return this.logins.remove(login);
	}
}
