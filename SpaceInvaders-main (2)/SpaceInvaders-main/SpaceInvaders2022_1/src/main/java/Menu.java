import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu {
    private AnchorPane mainPane; // Organizar todo o conteúdo criado (interfaces gráficas) a partir de coordenadas
    private Scene mainScene;
    private Stage mainStage;
    private ArrayList<Botao> botoesMenu;

    public Menu() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, Params.WINDOW_WIDTH, Params.WINDOW_HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        botoesMenu = new ArrayList<>();
        botoesCriados();
        fundo();
        titulo();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void botoesCriados() { // Método para organizar a criação de botões do Menu
        criarBotao("JOGAR", 275, 150);
        criarBotao("RANKING", 275, 250);
        criarBotao("OPÇÕES", 275, 350);
        criarBotao("SAIR", 275, 450);

    }

    private void criarBotao(String nome, int x, int y) { // Método para criar os botões do Menu
        Botao botao = new Botao(nome);
        botao.setLayoutX(x);
        botao.setLayoutY(y);
        botoesMenu.add(botao);
        mainPane.getChildren().add(botao);
    }

    private void fundo() {  // Método para criar o fundo da tela inicial
        Image imagemFundo = new Image("background2.jpg", 800, 600, false, true);
        BackgroundImage fundo = new BackgroundImage(imagemFundo, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT , BackgroundSize.DEFAULT);
        mainPane.setBackground(new Background(fundo));
    }

    private void titulo() {  // Método para criar a logo "Space Invaders" na tela inicial
        Label text = new Label("Space Invaders");
        text.setLayoutX(180);
        text.setLayoutY(60);
        text.setFont(Font.font("", 60));
        text.setTextFill(Color.web("#DAA549", 0.8));
        mainPane.getChildren().add(text);
    }

}
