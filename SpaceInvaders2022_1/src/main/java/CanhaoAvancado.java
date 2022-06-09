import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.image.Image;

/**
 * Represents the game Gun
 * @author Bernardo Copstein, Rafael Copstein
 */
public class CanhaoAvancado extends BasicElement implements KeyboardCtrl{
    private int RELOAD_TIME = 1000000000; // Time is in nanoseconds
    private int shot_timer = 0;
    private Image image;

    public CanhaoAvancado(int px,int py){
        super(px,py);
        setSpeed(3);
        try{
            // Carrega a imagem ajustando a altura para 40 pixels
            // mantendo a proporção em ambas dimensões
            image =  new Image( "spaceship.png",0,60,true,true );
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        setLimH(0,Params.WINDOW_WIDTH-40);
        setLimV(Params.WINDOW_HEIGHT-100,Params.WINDOW_HEIGHT);
    }

    @Override
    public void Update(long deltaTime) {
        if (jaColidiu()){
            Game.getInstance().setGameOver();
        }
        setPosX(getX() + getDirH() * getSpeed());
        if (shot_timer > 0) shot_timer -= deltaTime;
        if(getX() >= getLMaxH()){setPosX(getLMaxH()-5);}
        if(getX() < getLMinH()){setPosX(getLMinH()+5);}
        
    }

    @Override
    public void OnInput(KeyCode keyCode, boolean isPressed) {
        if (keyCode == KeyCode.LEFT){
            int dh = isPressed ? -1 : 0; 
            setDirH(dh);
        }
        if (keyCode == KeyCode.RIGHT){
            int dh = isPressed ? 1 : 0;
            setDirH(dh);
        }
        if (keyCode == KeyCode.SPACE){
            if (shot_timer <= 0) {
                Game.getInstance().addChar(new Shot(getX()+16,getY()-32));
                Game.getInstance().addChar(new Shot(getX()+46,getY()-32));
                Game.getInstance().addChar(new Shot(getX()-14,getY()-32));
                shot_timer = RELOAD_TIME;
            }
        }
        //if (keyCode == KeyCode.UP) do nothing
        //if (keyCode == KeyCode.DOWN) do nothing
    }

    @Override
    public int getAltura(){
        return 15;
    }

    @Override
    public int getLargura(){
        return 15;
    }

    @Override
    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.drawImage(image, getX(),getY());
    }
}
