import java.util.Scanner;

class Paciente extends Pessoa {
    private String susCard;
    private String historicoMedico;

    Scanner sc = new Scanner(System.in);

    Paciente(String nome, int idade, String cpf, String susCard, String historicoMedico){
        super(nome, idade, cpf);
        this.susCard = susCard;
        this.historicoMedico = historicoMedico;
    }

    public void setSusCard(){
        System.out.println("Informe o número do cartão do SUS:");
        this.susCard = sc.next();
    }

    public String getSusCard(){
        return this.susCard;
    }

    public void setHistorico(){
        System.out.println("Informe o histórico médico:");
        this.historicoMedico = sc.next();
    }

    public String getHistorico(){
        return this.historicoMedico;
    }

    @Override
    public String showDados(){
        return("Nome do paciente: " + this.getNome() + "\nIdade do paciente: " + this.getIdade() + "\nCPF do Paciente: " + this.getCPF() + "\nCartão do SUS do Paciente: " + this.getSusCard() + "\nHistórico Médico do Paciente: " + this.getHistorico());
    }

    @Override
    public String pegarClasse(){
        return "Paciente";
    }

    @Override
    public String toString(){
        return "nomePaciente=" + this.getNome() + ";" + "idadePaciente=" + this.getIdade() + ";" + "cpfPaciente=" + this.getCPF() + ";"
        + "susPaciente=" + this.getSusCard() + ";" + "historicoPaciente=" + this.getHistorico() + ";";
    }
}
