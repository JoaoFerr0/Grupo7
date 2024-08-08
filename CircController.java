import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CircController {
    CircView circView;
    Stage stage;
        
    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;

    @FXML
    private Button but4;

    @FXML
    private ImageView circ1;

    @FXML
    private ImageView circ2;

    @FXML
    private ImageView circ3;

    @FXML
    private ImageView circ4;
    
    public CircController() {
        this.circView = new CircView();
        this.circView.setController(this);
    }
    
    void initialize() {
        
    } 
    
    public void iniciar() throws Exception {
        this.circView.start(this.stage);
        this.stage.show();
    }
        
    @FXML
    public void clickC1(ActionEvent e) {
        Circ1.execute(new String[]{});
    }

    @FXML
    public void clickC2(ActionEvent event) {
        Circ2.execute(new String[]{});
    }

    @FXML
    public void clickC3(ActionEvent event) {
        Circ3.execute(new String[]{});
    }

    @FXML
    public void clickC4(ActionEvent event) {
        Circ4.execute(new String[]{});
    }
}


