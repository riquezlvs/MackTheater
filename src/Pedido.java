import java.util.ArrayList;

public class Pedido {
    public Pedido(){}
    ArrayList<Entrada> entradas = new ArrayList<>();

    public void adicionaEntrada(Entrada entrada){
        this.entradas.add(entrada);
    }

    public double calculaValorTotal(double precoBaseEspetaculo){
        double total = 0;
        for (Entrada entrada : entradas) {
            total += entrada.calculaValor(precoBaseEspetaculo);
        }
        return total;
    }
}
