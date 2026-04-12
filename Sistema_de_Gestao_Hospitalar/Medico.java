import java.util.Scanner;

class Medico extends Pessoa {
    //colocar crm
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
        return ("Nome do médico: " + this.getNome() + "  Idade: " + this.getIdade() + "  CPF: " + this.getCPF() + "  Especialidade: " + this.especialidade + "  Salário: " + this.salario);
    }

    @Override
    public String pegarClasse(){
        return "Medico";
    }
}
