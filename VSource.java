import org.apache.commons.math3.complex.Complex;

/**
 * Classe modelo para uma fonte de tensão. Possui todos os atributos e métodos das superclasses e ainda os atributos
 * frequenciaAC (especifica a frequência de oscilação da tensão senoidal fornecida ao circito quando conectada) e 
 * tensao (representada por um número complexo implementar circuitos AC)
 *
 *
 * @author (TheodoroCosta)
 * @version (final)
 */
 
public class VSource extends Componente {
    private double frequenciaAC;
    private Complex tensao;

    /**
     * <summary>
     * Construtor para objetos da classe VSource. O parêmetro A define o atributo tensao e o parâmetro f
     * define o atributo frequênciaAC. Fontes são instanciadas com nós padrão de conexão: 
     * positivo(id ="a", potencial = tensao) e negativo (id ="gnd", potencial = 0 / nó terra)
     */
    
    public VSource(double A, double f) {
        this.tensao = new Complex(A, 0);
        this.frequenciaAC = f;
        this.feed_supply(new Node("a"), new Node("gnd"));
        this.get_neg().set_potencial(new Complex(0, 0));
        this.get_pos().set_potencial(this.tensao);
    }

    /**
     * <summary>
     * Retorna o valor do atributo frequenciaAC do objeto 
     */
    
    public double get_rate() {
        return this.frequenciaAC;
    }

    /**
     * <summary>
     * Método para modificar o valor do aributo frequenciaAC do objeto fornecendo o parâmetro f 
     */
    
    public void set_rate(double f) {
        this.frequenciaAC = f;
    }

    /**
     * <summary>
     * Retorna o valor da magnitude do atributo tensao do objeto
     */
    
    public double get_amplitude() {
        return this.tensao.abs();
    }
    
    /**
     * <summary>
     * Retorna o valor do atributo tensao do objeto na forma completa 
     */
    
    public Complex getTensao(){
        return this.tensao;
    }

    /**
     * <summary>
     * Retorna o valor do ângulo de fase do atributo tensao do objeto
     */
    
    public double get_phaseangle() {
        return this.tensao.getArgument();
    }
}
