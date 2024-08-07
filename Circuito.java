import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.FieldVector;

/**
 * Classe modelo para circitos elétricos. Seus atributos nodes e compoenentes representam o conjunto de 
 * componentes e nós que definem a topologia do sistema; e o atributo fonte define o objeto VSource que 
 * alimenta o sistema
 *
 * @author (JoaoFerr0)
 * @version (final)
 */ 

public class Circuito {
    private Node[] nodes;
    private Componente[] componentes;
    private VSource fonte;

    /**
     * <summary>
     * Construtor para objetos da classe Circuito. Os parêmetros nodes, componentes e fonte recebem a lista de nós,
     * a lista de componentes e a fonte de alimetaçao do circuito a ser instanciado.
     */
    
    public Circuito(Node[] nodes, Componente[] componentes, VSource fonte) {
        this.nodes = nodes;
        this.componentes = componentes;
        this.fonte = fonte;
    }

    /**
     * <summary>
     * Método que compila toda a topologia do circuito e condições de contorno com base no método de análise nodal,
     * monta o sistema linear em forma de matrizes e vetores, resolve este sistema, atualiza e imprime na tela o
     * resultado obtido para o potencial de cada nó do circuito.
     */
    
    public void realizarAnaliseNodal() {
        int n = nodes.length;
        int nodeIndexReference = findNodeIndex(fonte.get_neg().get_id()); // Nó de referência (terra)
        int nodeIndexSourcePositive = findNodeIndex(fonte.get_pos().get_id()); // Nó positivo da fonte

        Complex[][] Y = new Complex[n][n];
        Complex[] B = new Complex[n];
        for (int i = 0; i < n; i++) {
            B[i] = Complex.ZERO;
            for (int j = 0; j < n; j++) {
                Y[i][j] = Complex.ZERO;
            }
        }

        for (Componente comp : componentes) {
            if (comp instanceof CompPassivo) {
                CompPassivo passivo = (CompPassivo) comp;
                Complex impedancia = passivo.get_impedancia();

                Complex g = Complex.ONE.divide(impedancia);

                if (Double.isNaN(g.getReal()) || Double.isInfinite(g.getReal())) {
                    System.out.println("Impedância inválida detectada: " + impedancia);
                    continue;
                }

                int posComp = findNodeIndex(passivo.get_pos().get_id());
                int negComp = findNodeIndex(passivo.get_neg().get_id());

                Y[posComp][posComp] = Y[posComp][posComp].add(g);
                Y[posComp][negComp] = Y[posComp][negComp].subtract(g);
                Y[negComp][posComp] = Y[negComp][posComp].subtract(g);
                Y[negComp][negComp] = Y[negComp][negComp].add(g);
            }
        }
        
        printMatrix(new Array2DRowFieldMatrix<>(Y));
        
        Complex[][] adjustedY = new Complex[n][n];
        Complex[] adjustedB = new Complex[n];
        for (int i = 0; i < n; i++) {
            adjustedB[i] = Complex.ZERO;
            for (int j = 0; j < n; j++) {
                adjustedY[i][j] = Y[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            adjustedB[nodeIndexReference] = Complex.ZERO; // V_terra = 0
            
            if (i != nodeIndexReference) {
                
                adjustedY[nodeIndexReference][i] = Complex.ZERO;
            }
        }
        
        for(int i = 0; i < n; i++){
            adjustedB[nodeIndexSourcePositive] = fonte.getTensao(); // Va = V_fonte
            
            if(i != nodeIndexSourcePositive){
                
                adjustedY[nodeIndexSourcePositive][i] = Complex.ZERO;
            }
        }
        
        adjustedY[nodeIndexReference][nodeIndexReference] = Complex.ONE;
        adjustedY[nodeIndexSourcePositive][nodeIndexSourcePositive] = Complex.ONE;
        
        FieldMatrix<Complex> matrix = new Array2DRowFieldMatrix<>(adjustedY);
        FieldVector<Complex> vector = new ArrayFieldVector<>(adjustedB);

        printMatrix(new Array2DRowFieldMatrix<>(adjustedY));
        printVector(new ArrayFieldVector<>(adjustedB));

        FieldLUDecomposition<Complex> luDecomposition = new FieldLUDecomposition<Complex>(matrix);
        FieldDecompositionSolver<Complex> solver = luDecomposition.getSolver();
        FieldVector<Complex> solution;

        try {
            solution = solver.solve(vector);
        } catch (Exception e) {
            System.out.println("Erro ao resolver o sistema linear: " + e.getMessage());
            return;
        }

        System.out.println("Tensões nos nós:");
        for (int i = 0; i < solution.getDimension(); i++) {
            Complex tensao = solution.getEntry(i);
            nodes[i].set_potencial(tensao);
            System.out.printf("Nó %s: %.2f /_ %.2f ° V%n", nodes[i].get_id(), tensao.abs(), 180 * tensao.getArgument() / Math.PI);
        }
    }

    /**
     * <summary>
     * Método que compara o id de um dado nó com o id de um nó da lista de nós do sistema e, caso o encontre, 
     * retorna o seu índice dentro da lista
     */
    
    private int findNodeIndex(String id) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].get_id().equals(id)) {
                return i;
            }
        }
        
        System.out.println("Nós disponíveis:");
        for (Node node : nodes) {
            System.out.println("ID: " + node.get_id());
        }
        throw new IllegalArgumentException("Nó não encontrado: " + id);
    }

    /**
     * <summary>
     * Método que imprime da tela uma matriz com campos complexos
     */
    
    private void printMatrix(FieldMatrix<Complex> matrix) {
        System.out.println("Matriz Y:");
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                System.out.print(matrix.getEntry(i, j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * <summary>
     * Método que imprime da na tela um vetor com campos complexos
     */
    
    private void printVector(FieldVector<Complex> vector) {
        System.out.println("Vetor B:");
        for (int i = 0; i < vector.getDimension(); i++) {
            System.out.println(vector.getEntry(i));
        }
    }
}







