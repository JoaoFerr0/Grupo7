
/**
 * Interface impedância que assina os métodos a serem usados pelos componentes
 * para calcular a impedância para uso no domínio da frequência.
 * 
 * @author (Theodoro Costa) 
 * @version (0.01)
 */
public interface Imped{
   public double calculaModulo();
   public double calculaAngulo();
   public double calculaReal();
   public double calculaImaginario();
}
