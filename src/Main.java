import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;
        Teatro teatro = new Teatro();
        teatro.cadastrarEspetaculo(new Espetaculo("Espetáculo 01", "15/05/2023", "19h30", 30.00));
        teatro.cadastrarEspetaculo(new Espetaculo("Espetáculo 02", "30/05/2023", "20h30", 50.00));

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
                    break;
                case 2:
                    cadastrarEspetaculo(teatro, input);
                    break;
                case 3:

                    break;
                case 4:
                    teatro.apresentaEspetaculos();
                    System.out.print("Selecione um espetaculo: ");

                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
        input.close();
    }
    private static void cadastrarEspetaculo(Teatro teatro, Scanner scanner) {
        System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        teatro.cadastrarEspetaculo(novoEspetaculo);

        System.out.println(">>> Retorna ao menu principal <<<");
    }

}