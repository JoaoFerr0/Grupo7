import java.util.List;
import java.util.ArrayList;
import org.apache.commons.math3.complex.Complex;

/**
 * Classe modelo para os nós do um circuito elétrico, que são pontos de conexão para componentes.
 * Possuiu os atributos básicos potencial, que representa o potencial elétrico do nó em relação a um referencial 
 * nulo; e id que serve para que o sistema possa diferenciar mais facilmente diferentes objetoes desta classe. 
 * Além disso possui uma lista componentes que serve para alocar os componentes conectados aos objetos da classe.
 *
 *
 * @author (JoaoFerr0)  
 * @version (final) 
 */

 
public class Node {
    private Complex potencial;
    private String id;
    private List<Componente> componentes = new ArrayList<Componente>();

    /**
     * <summary>
     * Construtor para objetos da classe Node. O parâmetro id define o valor do atributo id do objeto. 
     * O atributo potencial é inicializado como valor default pois não é sempre possível saber de antemão 
     * seu valor quando o circuito for montado e alimentado.
     */
    
    public Node(String id) {
        this.id = id;
    }

    /**
     * <summary>
     * Adiciona o compontente dado pelo parêmetro c à lista de componentes conectados ao objeto.
     */
    
    public void add_componente(Componente c) {
        this.componentes.add(c);
    }

    /**
     * <summary>
     * Retorna o valor do atributo potencial do objeto na forma completa
     */
    
    public Complex get_potencial() {
        return this.potencial;
    }

    /**
     * <summary>
     * Método para modificar o valor do atributo potencial do objeto forncendo o parâmetro potencial
     */
    
    public void set_potencial(Complex potencial) {
        this.potencial = potencial;
    }

    /**
     * <summary>
     * Retorna o valor do atriuto id do objeto
     */
    
    public String get_id() {
        return id;
    }

    /**
     * <summary>
     * Retorna a lista de componentes conectados ao objeto
     */
    
    public List<Componente> getComponentes() {
        return this.componentes;
    }
}
