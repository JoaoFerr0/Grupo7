 * @author (JoaoFerr0) 
 * @version (0.02)
 */
public class Resist extends Comp implements Imped{
    
    private double resistencia;

    public Resist(double R){
        this.resistencia = R;
    }
    
    public void set_resistencia(double R){
        this.resistencia = R;
    }

    public double calcula_modulo(){
        return this.resistencia;
    }
    
    public double calcula_angulo(){
        return 0;
    }
    
    public double calcula_real(){
        return this.resistencia;
    }
    
    public double calcula_imaginario(){
        return 0;
    }  
}