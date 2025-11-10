public class EntradaMeia extends Entrada {

    @Override
    public double calculaValor(double precoBase) {
        return precoBase * 0.5;
    }
}