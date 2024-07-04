@author (JoaoFerr0) 
@version (0.02)

public class Indut extends Comp implements Imped{
    
    private double indutancia;

    private VSource source;
      
    public Indut(double L){
        this.indutancia = L;
    }
           
    public void set_indutancia(double L){
        this.indutancia = L;
    }

    public void feed_Indut(VSource fonte){
        this.source = fonte;
    }
    
    public double calcula_modulo(){
        double modulo = this.indutancia * 2 * Math.PI * this.source.get_rate();
        return modulo;
    }
    
    public double calcula_angulo(){
        return Math.PI/2;
    }
    
    public double calcula_real(){
        return 0;
    }
    
    public double calcula_imaginario(){
        return this.calcula_modulo();
    }

}