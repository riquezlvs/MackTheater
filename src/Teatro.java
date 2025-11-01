import java.util.ArrayList;

public class Teatro {
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Espetaculo> espetaculos = new ArrayList<>();

    public Teatro() {}

    public void NovaCompra(){
        this.carrinho = new Pedido();
        System.out.println("\n--- Nova Compra Iniciada ---");
    }

    public void apresentaEspetaculos(){
        System.out.println("\n--- Espetáculos Disponíveis ---");
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + espetaculos.get(i).toString());
        }
    }

    public void selecionaEspetaculo(int numero){
        for (int i = 0; i < espetaculos.size(); i++) {
            if (numero-1 == i){
                this.espetaculoSelecionado = espetaculos.get(numero - 1);
                System.out.println("Espetaculo" + i+1 + " selecionado.");
            }else{
                System.out.println("Erro: Número de espetáculo inválido.");
                this.espetaculoSelecionado = null;
            }
        }
    }

    public void NovaEntrada(int tipo, int assento){
        if(this.espetaculoSelecionado == null){
            System.out.println("Nenhum espetaculo selecionado.");
        }else{
            espetaculoSelecionado.novaEntrada(tipo, assento);
        }
    }

    public double finalizaCompra(String cpf){
        return 0;
    }
}
