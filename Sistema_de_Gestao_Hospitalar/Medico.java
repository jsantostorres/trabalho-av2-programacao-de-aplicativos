
import java.util.Scanner;

class Medico extends Pessoa {
    
    private String especialidade;
    private double salario; 

    Scanner sc = new Scanner(System.in);

    Medico(String nome, int idade, String cpf, String especialidade, double salario){
        super(nome, idade, cpf);
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public void setEspecialidade(){
        System.out.println("Informe a especialidade do médico:");
        this.especialidade = sc.next();
    }

    public String getEspecialidade(){
        return this.especialidade;
    }

    public void setSalario(){
        System.out.println("Informe o salário do médico:");
        this.salario = sc.nextDouble();
    }

    public double getSalario(){
        return this.salario;
    }

    @Override
    public String showDados(){
        return ("Nome do médico: " + this.getNome() + "\nIdade do médico: " + this.getIdade() + "\nCPF do médico: " + this.getCPF() + "\nEspecialidade do médico: " + this.getEspecialidade() + "\nSalário do médico: " + this.getSalario());
    }

    @Override
    public String pegarClasse(){
        return "Medico";
    }

    @Override
    public String toString(){
        return "nomeMedico=" + this.getNome() + ";" + "idadeMedico=" + this.getIdade() + ";" + "cpfMedico=" + this.getCPF() + ";"
        + "especialidadeMedico=" + this.getEspecialidade() + ";" + "salarioMedico=" + this.getSalario() + ";";
    }
}
