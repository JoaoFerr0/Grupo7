import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;

public class CircView extends Application {
    private FXMLLoader loader;
    private URL url;

    public CircView() {
        this.loader = new FXMLLoader();
        try {
            // Ajuste o caminho do arquivo FXML conforme necessário
            this.url = getClass().getResource("/INTERF.fxml");
            if (this.url == null) {
                throw new Exception("Arquivo FXML não encontrado");
            }
            this.loader.setLocation(this.url);
        } catch (Exception e) {
            System.out.println("Erro na carga da FXML: " + e);
        }
    }

    public void setController(CircController controller) {
        this.loader.setController(controller);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Defina o controlador aqui
            CircController controller = new CircController();
            this.loader.setController(controller);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Calculador de Circuito");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o FXML: " + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
