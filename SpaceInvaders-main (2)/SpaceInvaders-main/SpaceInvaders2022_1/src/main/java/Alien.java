import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alien extends BasicElement {
    private Image image;

    public Alien(int px, int py) {
        super(px, py);
        try {
            image = new Image("alien.png", 0, 40, true, true);  // Carrega a imagem ajustando a altura para 40 pixels e mantendo a proporção
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        setDirH(1);
        setSpeed(5);
    }

    @Override
    public void Update(long deltaTime) {
        if (jaColidiu()) {
            Game.getInstance().incPontos();
            deactivate();
        } else {
            setPosX(getX() + getDirH() * (getSpeed() / 2));
            // Se chegou no lado direito da tela ...

            if (getX() >= getLMaxH()) {
                setPosX(getLMinH() + 40);
                // Sorteia o passo de avanço [1,5]
                setSpeed(Params.getInstance().nextInt(5));
                // Se ainda não chegou perto do chão, desce
                /* if (getY() < 450){ */
                setPosY(getY() + 85);
            }
            if (getX() < getLMinH()) {
                setPosX(getLMaxH() - 40);
                // Sorteia o passo de avanço [1,5]
                setSpeed(Params.getInstance().nextInt(5));
                // Se ainda não chegou perto do chão, desce
                /* if (getY() < 450){ */
                setPosY(getY() + 85);

            }

        }
    }

    public void Draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY());
    }

    @Override
    public void testaColisao(Character outro) {
        if (outro instanceof Alien) {
            return;
        } else {
            super.testaColisao(outro);
        }
    }
    
}