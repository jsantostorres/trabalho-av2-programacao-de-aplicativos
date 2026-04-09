import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Menu m = new Menu();
        m.menu();

        //int op;
        System.out.println("Informe a opção desejada:");
        int op = sc.nextInt();

        switch(op) {
            case 1:
                Paciente p = new Paciente("", 0, "", "", "");
                p.setNome();
                p.setIdade();
                p.setCPF();
                p.setSusCard();
                p.setHistorico();
                break;
        }
    }
}