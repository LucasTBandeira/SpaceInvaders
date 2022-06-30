import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the basic game character
 * @author Bernardo Copstein and Rafael Copstein
 */

 /* Lucas Treviso Bandeira - 21104312-0
 * Natália Dal Pizzol - 21200917-9
 * Vermon João de Aguiar Neto - 21200965-8
 */

public interface Character {
    int getX();
    int getY();
    int getAltura();
    int getLargura();

    void testaColisao(Character c);
    boolean jaColidiu();
    void setColidiu();

    void start();
    boolean isActive();
    void Update(long deltaTime);
    void Draw(GraphicsContext graphicsContext);
}
