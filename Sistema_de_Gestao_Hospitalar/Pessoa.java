import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;
    private String cpf;

    Scanner sc = new Scanner(System.in);

    Pessoa(String nome, int idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void setNome(){
        System.out.println("Informe o nome:");
        this.nome = sc.next();
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(){
        System.out.println("Informe a idade:");
        this.idade = sc.nextInt();
    }

    public int getIdade(){
        return this.idade;
    }

    public void setCPF(){
        System.out.println("Informe o CPF:");
        this.cpf = sc.next();
    }

    public String getCPF(){
        return this.cpf;
    }

    public String showDados(){
        return ("Nome: " + this.nome + "  Idade: " + this.idade + "  CPF: " + this.cpf);
    }

    public String pegarClasse(){
        return "Pessoa";
    }
}
