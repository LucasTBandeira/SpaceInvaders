import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Represents a shot that crosses the screen from bottom to up and then dismiss
 * 
 * @author Bernardo Copstein and Rafael Copstein
 */

public class Shot extends BasicElement {

    public Shot(int px, int py) {
        super(px, py);
    }

    @Override
    public void start() {
        setDirV(-1);
        setSpeed(8);
    }

    @Override
    public void testaColisao(Character outro) {
        if (outro instanceof Shot) {
            return;
        } else {
            super.testaColisao(outro);
        }
    }

    @Override
    public void Update(long deltaTime) {
        if (jaColidiu()) {  // Se colidiu com o inimigo o tiro desaparece
            deactivate();
        } else {
            setPosY(getY() + getDirV() * getSpeed());
            if (getY() <= getLMinV()) { // Se chegou na parte superior da tela o tiro desaparece.
                deactivate();
            }
        }
    }

    @Override
    public int getAltura() {
        return 16;
    }

    @Override
    public int getLargura() {
        return 8;
    }

    public void Draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#00FF00"));
        graphicsContext.fillOval(getX(), getY(), 8, 16);
    }
    
}
