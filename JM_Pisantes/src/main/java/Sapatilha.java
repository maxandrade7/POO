public class Sapatilha extends Calcado {

    public Sapatilha(int codCalcado, int tamanho, String cor, String marca, String material, double valor) {
        super(codCalcado, tamanho, cor, marca, material, valor);
    }
    
    public double Desconto() {
        double desconto = 0;
        if(super.getValor() > 100){
            desconto = super.getValor() - super.getValor()* 0.12; 
            System.out.println("O valor do seu calçado após o desconto é de: R$" + desconto);
        }
        return desconto;
    }
}
