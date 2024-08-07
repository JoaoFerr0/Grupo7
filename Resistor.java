import org.apache.commons.math3.complex.Complex;

/**
 * Classe modelo para resistores. Tem todos os atributos e métodos das superclasses a ainda o atributo resistencia, 
 * que representa a característica intrínseca dos resistores
 * 
 *
 * @author (VivianoParaguayo)
 * @version (final)
 */

public class Resistor extends CompPassivo {
    private double resistencia;

    /**
     * <summary>
     * Construtor para objetos da classe Resistor. O parâmetro R define o valor do atributo resistencia. O atributo
     * impedancia também é inicializado aqui por não depender de fatores externos
     */
    
    public Resistor(double R) {
        this.resistencia = R;
        this.impedancia = new Complex(R, 0);
    }

    /**
     * <summary>
     * Método para modificar o valor do atributo do objeto resistencia fornecendo parâmetro R  
     */
    
    public void set_resistencia(double R) {
        this.resistencia = R;
    }

    /**
     * <summary>
     * Retorna o valor do atributo resistencia do objeto
     */
    
    public double get_resistencia() {
        return this.resistencia;
    }

    /**
     * <summary>
     * Método de inserção dos resistores aos circuitos.
     * O parâmetro source define qual fonte alimenta o circuito ao qual o resistor será inserido; os parâmetros
     * n1 e n2 definem a quais nós o resistor será conectado para construir a topologia do circuito.
     */
    
    public void connect_system(VSource source, Node n1, Node n2) {
        this.set_systemsource(source);
        this.feed_supply(n1, n2);
    }
}

