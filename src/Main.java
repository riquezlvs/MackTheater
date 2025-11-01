import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        Teatro teatro = new Teatro();

        do {
            System.out.println("\n*** MACK THEATER ***");
            System.out.println("1) Cadastrar Espetáculos");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Nome do Espetáculo: ");
                    String nome = input.nextLine();
                    System.out.println("Data: ");
                    String data = input.nextLine();
                    System.out.println("Hora: ");
                    String Hora = input.nextLine();
                    System.out.println("Preço da Entrada Inteira: ");
                    double preco = input.nextDouble();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Obrigado por utilizar o MACK THEATER. Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
        input.close();
    }
}