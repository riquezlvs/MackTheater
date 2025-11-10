import java.util.Scanner;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];
    Scanner input = new Scanner(System.in);

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        for (int i = 0; i < this.assentos.length; i++) {
            this.assentos[i] = false;
        }
    }

    public void ApresentaAssentos(){
        System.out.print("||| Assentos Disponíveis |||\n");
        for (int i = 0; i < this.assentos.length; i++) {
            int numeroAssento = i + 1;
            String saida = this.assentos[i] ? "XX" : String.valueOf(numeroAssento);
            System.out.printf("%2s ", saida);

            if (numeroAssento % 10 == 0) {
                System.out.println();
            }
        }
    }

    public Entrada novaEntrada(int tipo, int assento){
        this.marcarAssento(assento);
        return switch (tipo) {
            case 1 -> new EntradaInteira();
            case 2 -> new EntradaMeia();
            case 3 -> new EntradaProfessor();
            default -> null;
        };
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Espetáculo: " + nome + " | Data: " + data + " | Horário: " + hora + " | Preço Base: R$ " + String.format("%.2f", preco);
    }

    public void marcarAssento(int assento){
        this.assentos[assento -1] = true;
        System.out.println("Assento " + assento + " marcado como ocupado.");
    }
}
