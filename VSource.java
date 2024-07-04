
/**
 * Escreva uma descrição da classe VSource aqui.
 * 
 * @author (JoaoFerro) 
 * @version (0.01)
 */
public class VSource extends Comp{
    
    private double amplitude;
    private double frequenciaAC;
    private double faseAC;
    
    //Construtor: para instanciar uma fonte DC faço frequência e fase nulas
    public VSource(double A){   
        this.faseAC = 0;
        this.amplitude = A;
        this.frequenciaAC = 0;
        this.set_v1(0);   //setar em zero a tensão no nó 1
        this.apply_ddp(A);   //setar a tensaõ no nó 2
    }
    
    //COnstrutor: para instanciar uma fonte AC dou o argumento frequencia f e a fase fica nula por convenção
    public VSource(double A, double f){    
        this.faseAC = 0;
        this.amplitude = A;
        this.frequenciaAC = f;
        this.set_v1(0);  //setar em zero a tensão no nó 1
        this.apply_ddp(A);  //setar a tensão no nó 2 
    }
    
    public double get_rate(){
        return this.frequenciaAC;
    }
    
}
