import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        ArrayList<Exame> exames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op;
        int qtdPacientes = 0;
        int qtdMedicos = 0;

        do {
                      
            System.out.println("Menu Principal:");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Registrar Consulta");
            System.out.println("4. Registrar Exame");
            System.out.println("5. Listar Pessoas");
            System.out.println("6. Listar consultas");
            System.out.println("7. Listar Exames");
            System.out.println("8. Calcular Pagamentos");
            System.out.println("9. Relatório de Consultas por Médico");
            System.out.println("0. Sair");
    

            System.out.println("Informe a opção desejada:");
            op = sc.nextInt();
            
            switch(op) {
                case 1:
                    sc.nextLine();
                    System.out.println("Digite um nome:");
                    String nomePaciente = sc.nextLine();
                    System.out.println("Digite a idade:");
                    int idadePaciente = sc.nextInt();
                    System.out.println("Digite um CPF:");
                    sc.nextLine();
                    String cpfPaciente = sc.nextLine();
                    if(validarCPF(pessoas, cpfPaciente).equals("O CPF inserido ja esta cadastrado no sistema.")){
                        System.out.println("O CPF inserido já está cadastrado no sistema.");
                        break;
                    }
                    System.out.println("CPF valido!");
                    System.out.println("Digite um susCard:");
                    String susCard = sc.nextLine();
                    if(validarSusCard(pessoas, susCard).equals("O SusCard inserido ja esta cadastrado no sistema.")){
                        System.out.println("O SusCard inserido ja esta cadastrado no sistema.");
                        break;
                    }
                    System.out.println("Digite um Historico Medico:");
                    String historico = sc.nextLine();
                    Paciente paciente = new Paciente(nomePaciente, idadePaciente, cpfPaciente, susCard, historico);
                    pessoas.add(paciente);
                    qtdPacientes++;
                    break;


                case 2:
                    sc.nextLine();
                    System.out.println("Digite um nome:");
                    String nomeMedico = sc.nextLine();
                    System.out.println("Digite a idade:");
                    int idadeMedico = sc.nextInt();
                    System.out.println("Digite um CPF:");
                    sc.nextLine();
                    String cpfMedico = sc.nextLine();
                    if(validarCPF(pessoas, cpfMedico).equals("O CPF inserido ja esta cadastrado no sistema.")){
                        System.out.println("O CPF inserido ja esta cadastrado no sistema.");
                        break;
                    }
                    System.out.println("CPF valido!");
                    System.out.println("Digite a especialidade:");
                    String especialidade = sc.nextLine();
                    System.out.println("Digite o salario: ");
                    double salario = sc.nextDouble();
                    Medico medico = new Medico(nomeMedico, idadeMedico, cpfMedico, especialidade, salario);
                    pessoas.add(medico);
                    qtdMedicos++;
                    break;


                case 3:
                    sc.nextLine();
                    System.out.println("Digite o nome do paciente:");
                    String nomeBusca = sc.nextLine();
                    int resultadoPaciente = buscarPorNomePaciente(pessoas, nomeBusca);
                    if(resultadoPaciente == -1){
                        System.out.println("O nome não foi encontrado.");
                        break;
                    }

                    Paciente pacienteConsulta = (Paciente) pessoas.get(resultadoPaciente);
                    System.out.println("Digite o nome do medico:");
                    nomeBusca = sc.nextLine();
                    int resultadoMedico = buscarPorNomeMedico(pessoas, nomeBusca);
                    if(resultadoMedico == -1){
                        System.out.println("O nome não foi encontrado.");
                        break;
                    }
                    Medico medicoConsulta = (Medico) pessoas.get(resultadoMedico);

                    System.out.println("Digite a data:");
                    String data = sc.nextLine();

                    System.out.println("Digite a descrição:");
                    String descricao = sc.nextLine();
                    
                    Consulta consulta = new Consulta(pacienteConsulta, medicoConsulta, data, descricao);
                    consultas.add(consulta);

                    break;
                
                case 4:
                    sc.nextLine();
                    System.out.println("Digite o nome do exame:");
                    String nomeExame = sc.nextLine();

                    System.out.println("Digite o nome do paciente: ");
                    String nomePacienteExame = sc.nextLine();
                    int resultadoPacienteExame = buscarPorNomePaciente(pessoas, nomePacienteExame);
                    if(resultadoPacienteExame == -1){
                        System.out.println("O nome não foi encontrado.");
                        break;
                    }

                    Paciente pacienteConsultaExame = (Paciente) pessoas.get(resultadoPacienteExame);
                    System.out.println("Digite o resultado do exame: ");
                    String resultadoExames = sc.nextLine();

                    Exame exame = new Exame(nomeExame, pacienteConsultaExame, resultadoExames);
                    exames.add(exame);

                    break;

                case 5:
                    if(pessoas.isEmpty()){
                        System.out.println("Não há pessoas registradas no sistema.");
                        break;
                    }
                    for(int i = 0; i < pessoas.size(); i++){
                        System.out.println(pessoas.get(i).showDados());
                    }
                    break;
                
                case 6:
                    if(consultas.isEmpty()){
                        System.out.println("Não há consultas registradas no sistema.");
                        break;
                    }
                    for(int i = 0; i < consultas.size(); i++){
                        System.out.println(consultas.get(i).showDados());
                    }

                    break;

                case 7:
                    if(exames.isEmpty()){
                        System.out.println("Não há exames registrados no sistema.");
                        break;
                    }
                    for(int i = 0; i < exames.size(); i++){
                        System.out.println(exames.get(i).showDados());
                    }
                    break;

                case 8:
                    if(pessoas.isEmpty()){
                        System.out.println("Não há médicos registrados no sistema.");
                        break;
                    }
                    for(int i = 0; i < pessoas.size(); i++){
                        if(pessoas.get(i).pegarClasse().equals("Medico")){
                            Medico medicoSalario = (Medico) pessoas.get(i);
                            System.out.println("Nome do Funcionário: \n" + medicoSalario.getNome() + " Salario do Funcionário: " + medicoSalario.getSalario());
                        }
                    }
                    break;

                case 9:
                    sc.nextLine();
                    if(consultas.isEmpty()){
                        System.out.println("Não há consultas registradas no sistema.");
                        break;
                    } 
                    System.out.println("Insira o nome do Médico: ");
                    String nomeRelatorio = sc.nextLine(); 
                    for(int i = 0; i < consultas.size(); i++){
                        if(nomeRelatorio.equals(consultas.get(i).getMedico().getNome())){
                            System.out.println("Histórico do médico: \n" + consultas.get(i).showDados());
                            System.out.println("");
                        }
 
                    }
                    break;
                    
            }

        } while (op != 0);

        sc.close();
    }

     public static String validarSusCard(ArrayList<Pessoa> pessoas, String susCard){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).pegarClasse().equals("Paciente")){
                Paciente paciente = (Paciente) pessoas.get(i);
                if(paciente.getSusCard().equals(susCard)){
                    return "O SusCard inserido ja esta cadastrado no sistema.";
                }
            }
        }
        return "SusCard Registrado!";
    }

    public static String validarCPF(ArrayList<Pessoa> pessoas, String CPF){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getCPF().equals(CPF)){
                return "O CPF inserido ja esta cadastrado no sistema.";
            }
        }
        return "CPF Registrado!";
        
    }
    public static int buscarPorNomePaciente(ArrayList<Pessoa> pessoas, String nome){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getNome().equals(nome)){
                if(pessoas.get(i).pegarClasse().equals( "Paciente")){
                    return i;
                }
            }
        } 
        // não achou, então retorna -1
        return -1;
    }
    

    public static int buscarPorNomeMedico(ArrayList<Pessoa> pessoas, String nome){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getNome().equals(nome)){
                if(pessoas.get(i).pegarClasse().equals("Medico")){
                    return i;
                }
            }
        } 
        // não achou, então retorna -1
        return -1;
    }
}
