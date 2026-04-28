import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        ArrayList<Exame> exames = new ArrayList<>();
        String caminho = "infos.txt";
        try {
            File arquivo = new File(caminho);
            arquivo.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(caminho));
            String linha = "";
            while (linha != null) {
                linha = reader.readLine();
                if (linha == null) {
                    break;
                }

                //Atributos 
                
                String nomePaciente = "";
                int idadePaciente = 0;
                String cpfPaciente = "";
                String susCardPaciente = "";
                String historicoMedicoPaciente = "";

                String nomeMedico = "";
                int idadeMedico = 0;
                String cpfMedico = "";
                String especialidadeMedico = "";
                double salarioMedico = 0;

                String nomeExame = "";
                String resultadoExame = "";

                String dataConsulta = "";
                String descricaoConsulta = "";

                String informacoes[] = linha.split(";");

                for (String informacao : informacoes) {
                    String info = informacao.trim();

                    //classe paciente
                    if (info.startsWith("nomePaciente=")) {
                        nomePaciente = info.substring("nomePaciente=".length());
                    } else if (info.startsWith("idadePaciente=")) {
                        idadePaciente = Integer.parseInt(info.substring("idadePaciente=".length()));
                    } else if (info.startsWith("cpfPaciente=")) {
                        cpfPaciente = info.substring("cpfPaciente=".length());
                    } else if (info.startsWith("susPaciente=")) {
                        susCardPaciente = info.substring("susPaciente=".length());
                    } else if (info.startsWith("historicoPaciente=")) {
                        historicoMedicoPaciente = info.substring("historicoPaciente=".length());
                    }
                    
                    //classe medico
                    else if (info.startsWith("nomeMedico=")) {
                        nomeMedico = info.substring("nomeMedico=".length());
                    } else if (info.startsWith("idadeMedico=")) {
                        idadeMedico = Integer.parseInt(info.substring("idadeMedico=".length()));
                    } else if (info.startsWith("cpfMedico=")) {
                        cpfMedico = info.substring("cpfMedico=".length());
                    } else if (info.startsWith("especialidadeMedico=")) {
                        especialidadeMedico = info.substring("especialidadeMedico=".length());
                    } else if (info.startsWith("salarioMedico=")) {
                        salarioMedico = Double.parseDouble(info.substring("salarioMedico=".length()));
                    }
                    
                    //classe exame
                    else if (info.startsWith("resultadoExame=")) {
                        resultadoExame = info.substring("resultadoExame=".length());
                    } else if (info.startsWith("nomeExame=")) {
                        nomeExame = info.substring("nomeExame=".length());
                    }

                    //classe consulta
                    else if (info.startsWith("dataConsulta=")) {
                        dataConsulta = info.substring("dataConsulta=".length());
                    } else if (info.startsWith("descricaoConsulta=")) {
                        descricaoConsulta = info.substring("descricaoConsulta=".length());
                    }
                }

                
                if (linha.startsWith("Paciente") && nomePaciente != "" && idadePaciente != 0 && cpfPaciente != ""
                        && susCardPaciente != "" && historicoMedicoPaciente != "") {
                    Paciente paciente = new Paciente(nomePaciente, idadePaciente, cpfPaciente, susCardPaciente,
                            historicoMedicoPaciente);
                    pessoas.add(paciente);
                } else if (linha.startsWith("Medico") && nomeMedico != "" && idadeMedico != 0 && cpfMedico != ""
                        && especialidadeMedico != "" && salarioMedico != 0) {
                    Medico medico = new Medico(nomeMedico, idadeMedico, cpfMedico, especialidadeMedico, salarioMedico);
                    pessoas.add(medico);
                } else if (linha.startsWith("Exame")) {
                    if (nomePaciente != "" && idadePaciente != 0 && cpfPaciente != "" && susCardPaciente != ""
                            && historicoMedicoPaciente != "" && nomeExame != "" && resultadoExame != "") {
                        Exame exame = new Exame(nomeExame, new Paciente(nomePaciente, idadePaciente, cpfPaciente,
                                susCardPaciente, historicoMedicoPaciente), resultadoExame);
                        exames.add(exame);
                    }
                } else if (linha.startsWith("Consulta")) {
                    if (dataConsulta != "" && descricaoConsulta != "") {
                        if (nomeMedico != "" && idadeMedico != 0 && cpfMedico != "" && especialidadeMedico != ""
                                && salarioMedico != 0 &&
                                nomePaciente != "" && idadePaciente != 0 && cpfPaciente != "" && susCardPaciente != ""
                                && historicoMedicoPaciente != "") {
                            Consulta consulta = new Consulta(
                                    new Paciente(nomePaciente, idadePaciente, cpfPaciente, susCardPaciente,
                                            historicoMedicoPaciente),
                                    new Medico(nomeMedico, idadeMedico, cpfMedico, especialidadeMedico, salarioMedico),
                                    dataConsulta, descricaoConsulta);

                            consultas.add(consulta);
                        }
                    }
                }
            }
            reader.close();

            Scanner sc = new Scanner(System.in);
            int op;

            do {
                System.out.println("\nMenu Principal:");
                System.out.println("1. Cadastrar Paciente");
                System.out.println("2. Cadastrar Médico");
                System.out.println("3. Registrar Consulta");
                System.out.println("4. Registrar Exame");
                System.out.println("5. Listar Pessoas");
                System.out.println("6. Listar consultas");
                System.out.println("7. Listar Exames");
                System.out.println("8. Calcular Pagamentos");
                System.out.println("9. Relatório de Consultas por Médico");
                System.out.println("10. Exibir Histórico de Paciente");
                System.out.println("0. Sair");

                System.out.println("Informe a opção desejada:");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        sc.nextLine();
                        System.out.println("\nDigite um nome:");
                        String nomePaciente = sc.nextLine().trim();
                        System.out.println("\nDigite a idade:");
                        int idadePaciente = sc.nextInt();
                        System.out.println("\nDigite um CPF:");
                        sc.nextLine();
                        String cpfPaciente = sc.nextLine();
                        if (validarCPF(pessoas, cpfPaciente).equals("O CPF inserido ja esta cadastrado no sistema.")) {
                            System.out.println("O CPF inserido já está cadastrado no sistema.");
                            break;
                        }
                        System.out.println("CPF valido!");
                        System.out.println("\nDigite um susCard:");
                        String susCard = sc.nextLine();
                        if (validarSusCard(pessoas, susCard)
                                .equals("O SusCard inserido ja esta cadastrado no sistema.")) {
                            System.out.println("O SusCard inserido ja esta cadastrado no sistema.");
                            break;
                        }
                        System.out.println("\nDigite um Historico Medico:");
                        String historico = sc.nextLine();
                        Paciente paciente = new Paciente(nomePaciente, idadePaciente, cpfPaciente, susCard, historico);
                        pessoas.add(paciente);
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("\nDigite um nome:");
                        String nomeMedico = sc.nextLine();
                        System.out.println("\nDigite a idade:");
                        int idadeMedico = sc.nextInt();
                        System.out.println("\nDigite um CPF:");
                        sc.nextLine();
                        String cpfMedico = sc.nextLine();
                        if (validarCPF(pessoas, cpfMedico).equals("O CPF inserido ja esta cadastrado no sistema.")) {
                            System.out.println("O CPF inserido ja esta cadastrado no sistema.");
                            break;
                        }
                        System.out.println("CPF valido!");
                        System.out.println("\nDigite a especialidade:");
                        String especialidade = sc.nextLine();
                        System.out.println("\nDigite o salario: ");
                        double salario = sc.nextDouble();
                        Medico medico = new Medico(nomeMedico, idadeMedico, cpfMedico, especialidade, salario);
                        pessoas.add(medico);
                        break;

                    case 3:
                        sc.nextLine();
                        System.out.println("\nDigite o nome do paciente:");
                        String nomeBusca = sc.nextLine();
                        int resultadoPaciente = buscarPorNomePaciente(pessoas, nomeBusca);
                        if (resultadoPaciente == -1) {
                            System.out.println("O nome não foi encontrado.");
                            break;
                        }

                        Paciente pacienteConsulta = (Paciente) pessoas.get(resultadoPaciente);
                        System.out.println("\nDigite o nome do medico:");
                        nomeBusca = sc.nextLine();
                        int resultadoMedico = buscarPorNomeMedico(pessoas, nomeBusca);
                        if (resultadoMedico == -1) {
                            System.out.println("O nome não foi encontrado.");
                            break;
                        }
                        Medico medicoConsulta = (Medico) pessoas.get(resultadoMedico);

                        System.out.println("\nDigite a data:");
                        String data = sc.nextLine();

                        System.out.println("\nDigite a descrição:");
                        String descricao = sc.nextLine();

                        Consulta consulta = new Consulta(pacienteConsulta, medicoConsulta, data, descricao);
                        consultas.add(consulta);

                        break;

                    case 4:
                        sc.nextLine();
                        System.out.println("\nDigite o nome do exame:");
                        String nomeExame = sc.nextLine();

                        System.out.println("\nDigite o nome do paciente: ");
                        String nomePacienteExame = sc.nextLine();
                        int resultadoPacienteExame = buscarPorNomePaciente(pessoas, nomePacienteExame);
                        if (resultadoPacienteExame == -1) {
                            System.out.println("O nome não foi encontrado.");
                            break;
                        }

                        Paciente pacienteConsultaExame = (Paciente) pessoas.get(resultadoPacienteExame);
                        System.out.println("\nDigite o resultado do exame: ");
                        String resultadoExames = sc.nextLine();

                        Exame exame = new Exame(nomeExame, pacienteConsultaExame, resultadoExames);
                        exames.add(exame);

                        break;

                    case 5:
                        if (pessoas.isEmpty()) {
                            System.out.println("Não há pessoas registradas no sistema. \n");
                            break;
                        }
                        System.out.println("===== LISTA DE PESSOAS =====");
                        for (int i = 0; i < pessoas.size(); i++) {
                            System.out.println(pessoas.get(i).showDados() + "\n");
                        }
                        break;

                    case 6:
                        if (consultas.isEmpty()) {
                            System.out.println("Não há consultas registradas no sistema. \n");
                            break;
                        }

                        System.out.println("===== LISTA DE CONSULTAS =====");

                        for (int i = 0; i < consultas.size(); i++) {
                            System.out.println(consultas.get(i).showDados() + "\n");
                        }
                        break;

                    case 7:
                        if (exames.isEmpty()) {
                            System.out.println("Não há exames registrados no sistema. \n");
                            break;
                        }

                        System.out.println("===== LISTA DE EXAMES =====");

                        for (int i = 0; i < exames.size(); i++) {
                            System.out.println(exames.get(i).showDados() + "\n");
                        }
                        break;

                    case 8:
                        if (pessoas.isEmpty()) {
                            System.out.println("Não há médicos registrados no sistema.");
                            break;
                        }

                        for (int i = 0; i < pessoas.size(); i++) {
                            if (pessoas.get(i).pegarClasse().equals("Medico")) {
                                Medico medicoSalario = (Medico) pessoas.get(i);
                                System.out.println("Nome do Funcionário: " + medicoSalario.getNome()
                                        + "\nSalario do Funcionário: " + medicoSalario.getSalario() + "\n");
                            }
                        }
                        break;

                    case 9:
                        sc.nextLine();
                        System.out.print("\n");

                        if (consultas.isEmpty()) {
                            System.out.println("Não há consultas registradas no sistema.");
                            break;
                        }
                        System.out.println("Insira o nome do Médico: ");
                        String nomeRelatorio = sc.nextLine();

                        for (Consulta consultaRelatorio : consultas) {
                            if (nomeRelatorio.equals(consultaRelatorio.getMedico().getNome())) {
                                System.out.println(consultaRelatorio.showDados() + "\n");
                            }
                        }
                        break;

                    case 10:
                        sc.nextLine();
                        if (consultas.isEmpty()) {
                            System.out.println("Não há consultas registradas no sistema.");
                            break;
                        }
                        if (exames.isEmpty()) {
                            System.out.println("Não há exames registrados no sistema.");
                            break;
                        }
                        System.out.println("Insira o nome do Paciente: ");
                        String nomePesquisa = sc.nextLine();

                        System.out.println("Consultas do paciente: \n");
                        for (Consulta consultaPesquisa : consultas) {
                            if (nomePesquisa.equals(consultaPesquisa.getPaciente().getNome())) {
                                System.out.println(consultaPesquisa.showDados() + "\n");
                            }
                        }

                        System.out.println("Exames do Paciente: \n");
                        for (Exame examePesquisa : exames) {
                            if (nomePesquisa.equals(examePesquisa.getPaciente().getNome())) {
                                System.out.println(examePesquisa.showDados() + "\n");
                            }
                        }
                        break;
                }

            } while (op != 0);

            sc.close();
        } catch (Exception e) {
            System.out.println("Ocorreu algum erro.");
            System.out.println(e);

        } finally {
            try {
                FileWriter escritor = new FileWriter(caminho);

                for (Pessoa pessoa : pessoas) {
                    escritor.write(pessoa.pegarClasse() + ";" + pessoa.toString() + "\n");
                }
                escritor.write("\n");

                for (Consulta consulta : consultas) {
                    escritor.write("Consulta;" + consulta.toString() + "\n");
                }
                escritor.write("\n");

                for (Exame exame : exames) {
                    escritor.write("Exame;" + exame.toString() + "\n");
                }

                escritor.close();
            } catch (Exception e) {
                System.out.println("Ocorreu algum erro.");
                System.out.println(e);
            }
        }

    }

    public static String validarSusCard(ArrayList<Pessoa> pessoas, String susCard) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).pegarClasse().equals("Paciente")) {
                Paciente paciente = (Paciente) pessoas.get(i);
                if (paciente.getSusCard().equals(susCard)) {
                    return "O SusCard inserido ja esta cadastrado no sistema.";
                }
            }
        }

        return "SusCard Registrado!";
    }

    public static String validarCPF(ArrayList<Pessoa> pessoas, String CPF) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCPF().equals(CPF)) {
                return "O CPF inserido ja esta cadastrado no sistema.";
            }
        }

        return "CPF Registrado!";
    }

    public static int buscarPorNomePaciente(ArrayList<Pessoa> pessoas, String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equals(nome)) {
                if (pessoas.get(i).pegarClasse().equals("Paciente")) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static int buscarPorNomeMedico(ArrayList<Pessoa> pessoas, String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equals(nome)) {
                if (pessoas.get(i).pegarClasse().equals("Medico")) {
                    return i;
                }
            }
        }

        return -1;
    }
}
