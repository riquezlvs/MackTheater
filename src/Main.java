import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;
        Teatro teatro = new Teatro();
        teatro.adicionarEspetaculo(new Espetaculo("Espetáculo 01", "15/05/2023", "19h30", 30.00));
        teatro.adicionarEspetaculo(new Espetaculo("Espetáculo 02", "30/05/2023", "20h30", 50.00));
        teatro.adicionarClientes(new Cliente("Clovis", "123"));

        do {
            System.out.println("\n*** MACK THEATER ***");
            System.out.println("1) Cadastrar Espetáculos");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    teatro.cadastrarEspetaculo(input);
                    break;
                case 2:
                    teatro.cadastrarCliente(input);
                    break;
                case 3:
                    teatro.novaCompra();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
        input.close();
    }



}