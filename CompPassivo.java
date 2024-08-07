import org.apache.commons.math3.complex.Complex;

/**
 * Esta classe especifica os atributos e métodos que os componentes passivos do circuito devem ter, além 
 * daqueles da classe Componente. Quando conectados a um sistema alimentado pela fonte atribuída ao atributo 
 * systemsource, os componentes passivos adquirem uma nova dimensão de análise, chamada impedância, um número
 * complexo calculado com base nas características intrínsecas do componente que determina a reação de cada 
 * componente e está atribuída ao atributo impedancia. 
 * 
 *
 * @author (TheodoroCosta)
 * @version (final)
 */
 
public abstract class CompPassivo extends Componente {
    protected Complex impedancia;
    private VSource systemsource;

    /**
     * <summary>
     * 
     */
    
    public CompPassivo() {
    }

    /**
     * <summary>
     * Retorna o módulo da impedância do componente passivo
     * 
     * @return double
     */
    
    public double get_modulo() {
        return this.impedancia.abs();
    }

    /**
     * <summary>
     * Retorna o ângulo de fase da impedância do componente passivo
     * 
     * @return double
     */
    
    public double get_angulo() {
        return this.impedancia.getArgument();
    }

    /**
     * <summary>
     * Retorna a parte real da impedância do componente passivo
     * 
     * @return double
     */
    
    public double get_real() {
        return this.impedancia.getReal();
    }

    /**
     * <summary>
     * Retorna a parte imaginária da impedância do componente passivo
     * 
     * @return double
     */
    
    public double get_imaginario() {
        return this.impedancia.getImaginary();
    }

    /**
     * <summary>
     * Retorna o valor da impedância do componente passivo, na forma completa
     * 
     * @return Complex
     */
    
    public Complex get_impedancia() {
        return this.impedancia;
    }
    
    /**
     * <summary>
     * O parâmetro s define qual fonte alimenta o sistema ao qual o componente passivo está conectado
     * 
     * @param s : fonte a ser utilizada 
     * @return void 
     */
    
    public void set_systemsource(VSource s){
        this.systemsource = s;
    }
    
    /**
     * <summary>
     * Retorna qual fonte alimenta o sistema ao qual o componente passivo está conectado
     * 
     * @return VSource
     */
    
    public VSource get_systemsource(){
        return this.systemsource;
    }
}
