import org.apache.commons.math3.complex.Complex;

/**
 * Classe modelo para indutores. Tem todos os atributos e métodos das superclasses a ainda o atributo indutancia, que
 * representa a característica intrínseca dos indutores
 * 
 *
 * @author (VivianoParaguayo)
 * @version (final)
 */
  
public class Indutor extends CompPassivo {
    private double indutancia;

    /**
     * <summary>
     * Construtor para objetos da classe Indutor. O parâmetro L define o valor para o atributo indutancia.
     */
    
    public Indutor(double L) {
        this.indutancia = L;
    }

    /**
     * <summary>
     * Método para modificar o valor do atributo indutancia do objeto forncendo o parêmetro L
     */
    
    public void set_indutancia(double L) {
        this.indutancia = L;
    }

    /**
     * <summary>
     * Retorna o valor do atributo indutancia do objeto
     */
    
    public double get_indutancia() {
        return this.indutancia;
    }

    /**
     * <summary>
     * Método de inserção dos indutores aos circuitos.
     * O parâmetro source define qual fonte alimenta o circuito ao qual o indutor será inserido; os parâmetros
     * n1 e n2 definem a quais nós o indutor será conectado para construir a topologia do circuito. Além disso 
     * este método inicializa o valor da impedância do indutor dependente da frequência de alimentação e da 
     * indutância.
     */
    
    public void connect_system(VSource source, Node n1, Node n2) {
        this.set_systemsource(source);
        this.feed_supply(n1, n2);
        
        double reatancia = this.get_systemsource().get_rate() * 2 * Math.PI * this.indutancia;
        this.impedancia = new Complex(0, reatancia);
    }
}
