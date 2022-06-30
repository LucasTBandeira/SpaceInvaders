import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Handles window initialization and primary game setup
 * @author Bernardo Copstein, Rafael Copstein
 */

 /* Lucas Treviso Bandeira - 21104312-0
 * Natália Dal Pizzol - 21200917-9
 * Vermon João de Aguiar Neto - 21200965-8
 */

// Link repositório: https://github.com/LucasTBandeira/SpaceInvaders

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Menu.getInstance();
    }

    public static void main(String args[]) {
        launch();
    }
}
