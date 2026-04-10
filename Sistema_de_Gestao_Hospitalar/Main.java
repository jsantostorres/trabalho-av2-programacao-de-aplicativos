import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        int qtdPacientes = 0;
        int qtdMedicos = 0;

        do {
            Menu m = new Menu();
            m.menu();

            System.out.println("Informe a opção desejada:");
            op = sc.nextInt();

            switch(op) {
                case 1:
                    ArrayList<Paciente> pacientes = new ArrayList<>();
                    for (int i = 0; i < 10; i++){
                        if(pacientes.get(i).getNome() == null){
                            pacientes.add(new Paciente("", 0, "", "", ""));
                            pacientes.get(i).setNome();
                            pacientes.get(i).setIdade();
                            pacientes.get(i).setCPF();
                            pacientes.get(i).setSusCard();
                            pacientes.get(i).setHistorico();

                            qtdPacientes++;
                            break;
                        }
                    }
                    break;

                case 2:
                    ArrayList<Medico> medicos = new ArrayList<>();
                    for (int i = 0; i < 10; i++){
                        if(medicos.get(i).getNome() == null){
                            medicos.add(new Medico("", 0, "", "", 0                            ));
                            medicos.get(i).setNome();
                            medicos.get(i).setIdade();
                            medicos.get(i).setCPF();
                            medicos.get(i).setEspecialidade();

                            qtdMedicos++;
                            break;
                        }
                    }
                    break;
            }

        } while (op != 0);
    }
}