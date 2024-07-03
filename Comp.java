
/**
 * Escreva uma descrição da classe Comp aqui.
 * 
 * @author (JoaoFerr0) 
 * @version (um número da versão ou uma data)
 */
public abstract class Comp{

        private double v1;
        private double v2;
        
        public void set_v1(double tensao){
            this.v1 = tensao;
        }
        
        public void apply_ddp(double ddp){
            this.v2 = this.v1 + ddp;
        }
}
