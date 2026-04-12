public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private String data;
    private String descricao;

    Consulta(Paciente paciente, Medico medico, String data, String descricao){
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.descricao = descricao;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Paciente getPaciente(){
        return this.paciente;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }

    public Medico getMedico(){
        return this.medico;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String showDados(){
        return ("Paciente: \n" + this.paciente.showDados() + "\nMedico: \n" + this.medico.showDados() + "\nData do atendimento: " + "\nData: " + this.data + "\nDescrição: " + this.descricao);
    }

}
