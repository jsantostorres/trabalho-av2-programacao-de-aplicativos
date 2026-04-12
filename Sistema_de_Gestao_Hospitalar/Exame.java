public class Exame {
    private String nomeExame;
    private Paciente paciente;
    private String resultado;

    public Exame(String nomeExame, Paciente paciente, String resultado){
        this.nomeExame = nomeExame;
        this.paciente = paciente;
        this.resultado = resultado;
    }

    public void setNomeExame(String nomeExame){
        this.nomeExame = nomeExame;
    }

    public String getNomeExame(){
        return this.nomeExame;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Paciente getPaciente(){
        return this.paciente;
    }

    public void setResultado(String resultado){
        this.resultado = resultado;
    }

    public String getResultado(){
        return this.resultado;
    }

    public String showDados(){
        return "Nome do exame: " + this.nomeExame + "\nPaciente: \n" + this.paciente.showDados() + "\nResultado do exame: " + this.resultado;
    }
}
