import java.util.ArrayList;
import java.util.Scanner;

public class Teatro {
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Espetaculo> espetaculos = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public Teatro() {}

    public void novaCompra(){
        this.carrinho = new Pedido();
        System.out.println("\n--- Nova Compra Iniciada ---");
        apresentaEspetaculos();
        System.out.print("Selecione um espetaculo: ");
        int selecEspetaculo = input.nextInt();
        input.nextLine();
        selecionaEspetaculo(selecEspetaculo);
        espetaculoSelecionado.ApresentaAssentos();
        while(true){
            System.out.println("Digite o número do assento desejado: ");
            int assento = input.nextInt();
            System.out.println("Digite o tipo de entrada");
            System.out.println("1. Inteira");
            System.out.println("2. Meia");
            System.out.println("3. Professor");
            int selecTipo = input.nextInt();
            input.nextLine();
            novaEntrada(selecTipo, assento);
            System.out.println("Deseja continuar? ");
            System.out.println("1. Sim ");
            System.out.println("2. Não");
            int desejaContinuar = input.nextInt();
            if(desejaContinuar == 1){
                continue;
            }else if(desejaContinuar == 2){
                break;
            }else{
                System.out.println("Digite um valor valido.");
            }
        }
        System.out.println("Digite o cpf: ");
        input.nextLine();
        String cpf = input.nextLine();

        double valorTotal = finalizaCompra(cpf);
        if (valorTotal > 0) {
            System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
        }
        System.out.println(">>> Retorna ao menu principal <<<");
    }

    public void apresentaEspetaculos(){
        System.out.println("\n--- Espetáculos Disponíveis ---");
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, espetaculos.get(i).toString());
        }
    }

    public void selecionaEspetaculo(int numero){
        if (numero >= 1 && numero <= espetaculos.size()){
            this.espetaculoSelecionado = espetaculos.get(numero - 1);
            System.out.println("Espetaculo " + numero + " selecionado.");
        } else {
            System.out.println("Número de espetáculo inválido.");
            this.espetaculoSelecionado = null;
        }
    }

    public void cadastrarEspetaculo(Scanner scanner) {
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
        this.espetaculos.add(new Espetaculo(nome, data, hora, preco));
        System.out.println(">>> Retorna ao menu principal <<<");
    }

    public void adicionarEspetaculo(Espetaculo espetaculo) {
        this.espetaculos.add(espetaculo);
    }

    public void novaEntrada(int tipo, int assento){
        if(this.espetaculoSelecionado == null){
            System.out.println("Nenhum espetaculo selecionado.");
        }else{
            Entrada novaEntrada = espetaculoSelecionado.novaEntrada(tipo, assento);
            carrinho.adicionaEntrada(novaEntrada);
        }
    }

    public void cadastrarCliente(Scanner scanner){
        System.out.println("Digite seu nome: ");
        input.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();
        this.clientes.add(new Cliente(nome,cpf));
        System.out.println(">>> Retorna ao menu principal <<<");
    }

    public void adicionarClientes(Cliente cliente){
        this.clientes.add(cliente);
    }

    public double finalizaCompra(String cpf){
        Cliente clienteEncontrado = null;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado com o CPF: " + cpf);
            return 0.0;
        }

        if (carrinho == null){
            System.out.println("Erro: Carrinho vazio. Compra não finalizada.");
            return 0.0;
        }
        if (espetaculoSelecionado == null) {
            System.out.println("Erro: Nenhum espetáculo selecionado.");
            return 0.0;
        }

        clienteEncontrado.adicionaPedido(carrinho);

        double precoBase = espetaculoSelecionado.getPreco();
        double valorTotal = carrinho.calculaValorTotal(precoBase);

        this.carrinho = null;
        this.espetaculoSelecionado = null;

        return valorTotal;
    }
}
