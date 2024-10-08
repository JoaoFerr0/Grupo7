public class Circ4{
    public static void execute(String[] args) {
        // Criar a fonte de tensão (ela cria seus próprios nós internamente)
        VSource fonte = new VSource(5, 60); // 5V, 60 Hz
        
        // Obter os nós criados pela fonte e o nó adicional
        Node n1 = fonte.get_pos(); //nó positivo da fonte, sempre será adicionado ao índice 1 do vetor de nós
        Node n0 = fonte.get_neg(); //nó de referência (terra)
        
        // Criar componentes
        Resistor r1 = new Resistor(100); // 100 Ohm
        Resistor r2 = new Resistor(500); // 500 Ohm
        Resistor r3 = new Resistor(200); // 200 Ohm
        Indutor l1 = new Indutor(0.01); //10mH
        Capacitor c1 = new Capacitor(10e-6); //10mcF
        
        // Criar um nó adicional
        Node n2 = new Node("b");
        Node n3 = new Node("c");
        Node n4 = new Node("d");
        
        // Conectar os componentes à fonte e aos seus nós
        r1.connect_system(fonte, fonte.get_pos(), n2);
        r2.connect_system(fonte, n2, n3);
        r3.connect_system(fonte, n4, fonte.get_neg());
        l1.connect_system(fonte, n3, n4);
        c1.connect_system(fonte, n2, n4);
              

        // Criar um array de nós e componentes
        Node[] nodes = {n0, n1, n2, n3, n4}; // Inclua todos os nós utilizados
        Componente[] componentes = {r1, r2, r3, l1, c1};

        // Criar o circuito
        Circuito circuito = new Circuito(nodes, componentes, fonte);

        // Realizar análise nodal
        circuito.realizarAnaliseNodal();       
          
    }
}





/*public class Main {
    public static void main(String[] args) {
        // Criar a fonte de tensão (ela cria seus próprios nós internamente)
        VSource fonte = new VSource(5, 60); // 5V, 60 Hz

        // Criar componentes
        Resistor r1 = new Resistor(1000); // 1k Ohm
        Resistor r2 = new Resistor(1000); // 1k Ohm
        Capacitor c1 = new Capacitor(0.01); // 10 mF

        // Criar nós adicionais
        Node n3 = new Node("b");

        // Conectar os componentes à fonte e aos seus nós
        r1.connect_system(fonte, fonte.get_pos(), fonte.get_neg());
        r2.connect_system(fonte, fonte.get_pos(), n3);
        c1.connect_system(fonte, n3, fonte.get_neg());

        // Obter os nós criados pela fonte e o nó adicional
        Node n1 = fonte.get_pos();
        Node n2 = fonte.get_neg();

        // Criar um array de nós e componentes
        Node[] nodes = {n1, n2, n3}; // Inclua todos os nós utilizados
        Componente[] componentes = {r1, r2, c1};

        // Criar o circuito
        Circuito circuito = new Circuito(nodes, componentes, fonte);

        // Realizar análise nodal
        circuito.realizarAnaliseNodal();
    }
}*/
