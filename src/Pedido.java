import java.util.ArrayList;

public class Pedido {
    public Pedido(){}
    ArrayList<Entrada> entradas = new ArrayList<>();

    public void adicionaEntrada(Entrada entrada){
        this.entradas.add(entrada);
    }

    public double calculaValorTotal(){
        for(Entrada entrada : entradas){
            return entrada.calculaValor();
        }
        return 0;
    }
}
