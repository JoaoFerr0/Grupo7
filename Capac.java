/**
 * @author (JoaoFerro) 
 * @version (0.02)
 */
public class Capac extends Comp{
    private double capacitancia;

    private VSource source;
    
    public Capac(double C){
        this.capacitancia = C;
    }
    public void setCapacitancia(double C){
        this.capacitancia = C;
    }

    public void feed_Capac(VSource fonte){
        this.source = fonte;
    }

    public double calcula_modulo(){
        double modulo = 1/(this.capacitancia * 2* Math.PI * this.source.get_rate());
        return modulo;
    }
    
    public double calcula_angulo(){
        double angulo = -Math.PI/2;
        return angulo;
    }
    
    public double calcula_real(){
        return 0;
    }
    
    public double calcula_imaginario(){
        return -(this.calcula_modulo());
    }

}