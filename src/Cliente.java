import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    ArrayList<Pedido> historicoPedidos = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionaPedido(Pedido pedido){
        this.historicoPedidos.add(pedido);
        System.out.println("Pedido adicionado ao histórico de " + this.nome);
    }
}
