import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Botao extends Button{  // Classe para criar os botões do Menu. Herda da classe Button do javafx
    
    public Botao(String textoBotao) {  // Constrói o Botão
        setText(textoBotao);
        setFonteBotao(); 
        setEstiloBotao();
        setPrefWidth(200);  // Width da imagem do botão
        setPrefHeight(50);  // Height da imagem do botão
        eventoMouse();
    }

    private void setFonteBotao() {  // Define o estilo do texto do botão
        setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));

    }

    private void setEstiloBotao() {  // Define o estilo do botão
        setStyle("-fx-background-color: GREY");
    }

    private void eventoMouse() {  // Lida com evento do mouse
        setOnMouseClicked(new EventHandler<MouseEvent>() {  
            @Override
            public void handle(MouseEvent evento) {  // Sobreposição do método handle com a implementação desejada para lidar com o evento do mouse
                if(evento.getButton().equals(MouseButton.PRIMARY)) {
                    // Implementar o que acontece ao clicar no botão
                }
            }
        });
    }

}
