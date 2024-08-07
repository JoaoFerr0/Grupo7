import org.apache.commons.math3.complex.Complex;

/**
 * Classe modelo para capacitores. Tem todos os atributos e métodos das superclasses a ainda o atributo capacitancia, 
 * que representa a característica intrínseca dos capacitores
 * 
 * @author (TheodoroCosta)
 * @version (final)
 */

public class Capacitor extends CompPassivo {
    private double capacitancia;
    
    /**
     * <summary>
     */
    
    public Capacitor(double C) {
        this.capacitancia = C;
    }

    /**
     * <summary>
     * Retorna o valor do atributo capacitancia do objeto
     * 
     * @return double
     */
    
    public double get_capacitancia() {
        return this.capacitancia;
    }

    /**
     * <summary>
     * Método para modificar o valor do atributo capacitancia do objeto
     * 
     * @param C : valor da capacitância
     * @return void
     */
    
    public void set_capacitancia(double C) {
        this.capacitancia = C;
    }

    /**
     * <summary>
     * Método de inserção dos capacitores para construir a topologia do circuito. Além disso este método inicializa 
     * o valor da impedância do capacitor dependente da frequência de alimentação e da capacitância.
     * 
     * @param source : fonte a ser utilizada no sistema
     * @param n1 : nó de conexão ao terminal positivo
     * @param n2 : nó de conexão ao terminal negativo
     * @return void
     */
    
    public void connect_system(VSource source, Node n1, Node n2) {
        this.set_systemsource(source);
        this.feed_supply(n1, n2);
        
        double reatancia = 0;

        if (source.get_rate() == 0) {
            reatancia = 1e9; // Impedância muito alta para aproximação correta
        } else {
            reatancia = -1 / (2 * Math.PI * this.get_systemsource().get_rate() * this.capacitancia);
        }

        this.impedancia = new Complex(0, reatancia);
    }
}
