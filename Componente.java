/**
 * 
 * Classe que serve para dar os métodos e atributos básicos que todo componente deve ter. 
 * No escopo deste projeto, todo componente deve ter dois terminais (positivo e negativo) que podem ser 
 * conectados aos nós de um circuito para aliementar o componente (no caso de compoenentes passivos) ou
 * fornecer energia ao sistema (no caso de fontes)
 *   
 * 
 * @author (VivianoParaguayo)
 * @version (final)
 */

public abstract class Componente {
    private Node pos;
    private Node neg;

    /**
     * <summary>
     * Especifica a quais nós um componente deve ser conectado para construção de topologia do circuito.
     * 
     * @param pos - determina a qual nó será conectado o terminal positivo
     * @param neg - determina a qual nó será conectado o terminal negativo
     * @return void
     */
    
    public void feed_supply(Node pos, Node neg) {
        this.neg = neg;
        this.pos = pos;
    }

    /**
     * <summary>
     * Retorna o nó ao qual o terminal positivo está conectado
     * 
     * @return Node
     */
    
    public Node get_pos() {
        return this.pos;
    }

    /**
     * <summary>
     * Retorna o nó ao qual o terminal negativo está conectado
     * 
     * @return Node
     */
    
    public Node get_neg() {
        return this.neg;
    }
}
