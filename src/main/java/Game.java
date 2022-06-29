import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Handles the game lifecycle and behavior
 * @author Bernardo Copstein and Rafael Copstein
 */

public class Game {
    private static Game game = null;
    public static final int MAX_LEVEL = 3;
    private BasicSpaceship nave;
    private List<Character> activeChars;
    private boolean gameOver;
    private int pontos;
    private LocalDate ld;
    private int faseAtual;

    private Game(){
        gameOver = false;
        pontos = 0;
        ld = LocalDate.now();
        faseAtual = 1;
    }

    public LocalDate getDate(){
        return ld;
    }
    
    public void setGameOver(){
        gameOver = true;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public boolean isGameWon(){
        return areAllEnemiesDead();
    }

    private boolean areAllEnemiesDead() {
        return !activeChars
            .stream()
            .anyMatch(c -> c instanceof Inimigo);
    }

    public int getPontos(){
        return pontos;
    }

    public void incPontos(int x){
        this.pontos++;
    }

    public static Game getInstance(){
        if (game == null) {
            game = new Game();
        }
        return(game);
    }

    public void addChar(Character c){
        activeChars.add(c);
        c.start();
    }

    public void eliminate(Character c){
        activeChars.remove(c);
    }

    public int getNextLevel() {
        return faseAtual + 1;
    }

    public void loadLevel(int level){
        faseAtual = level;
        pontos = 0;
        Start();
    }

    public void Start() {
        this.gameOver = false;
        // Repositório de personagens
        activeChars = new LinkedList<>();

        // Adiciona o canhao
        nave = new AdvencedSpaceship(400,550);
        activeChars.add(nave);

        // Adiciona as barreiras
        addBarreiras();
        if (this.faseAtual == 1) {
            this.addLevel1Enemies();
        } else if (this.faseAtual == 2) {
            this.addLevel2Enemies();
        } 
        else if (this.faseAtual == 3) {
            this.addLevel3Enemies();
        }

        for(Character c:activeChars){
            c.start();
        }

    }

    public void show() {
        game.show();
    }

    private void addLevel1Enemies() {
        int quantEnemis = 5;
        for (int i = 0; i < quantEnemis; i++) {
            activeChars.add(new Alien1(i * 100, 50));
        }
    }
    
    private void addLevel2Enemies() {
        activeChars.add(new Alien2(0, 10));
        activeChars.add(new Alien2(100, 10));
        activeChars.add(new Alien1(200, 10));
        activeChars.add(new Alien1(300, 10));
        activeChars.add(new Alien3(400, 10));
        activeChars.add(new Alien3(500, 10));
    }
    
    private void addLevel3Enemies() {
        activeChars.add(new AlienBoss(40, 40));
    }

    public void addBarreiras(){
        for(int j = 0; j < 60; j = j + 10){
            for(int i = 0; i < 60; i = i + 11){
                activeChars.add(new BlocoDestrutivoBasico(40+i, 400+j));
            }
        }
        for(int j = 0; j < 60; j = j + 10){
            for(int i = 0; i < 60; i = i + 11){
                activeChars.add(new BlocoDestrutivoBasico(370+i, 400+j));
            }
        }
        for(int j = 0; j < 60; j = j + 10){
            for(int i = 0; i < 60; i = i + 11){
                activeChars.add(new BlocoDestrutivoBasico(680+i, 400+j));
            }
        }
    }

    public void Update(long currentTime, long deltaTime) {
        if (gameOver){
            return;
        }

        for(int i=0;i<activeChars.size();i++){
            Character este = activeChars.get(i);
            este.Update(deltaTime);
            for(int j =0; j<activeChars.size();j++){
                Character outro = activeChars.get(j);
                if (este != outro){
                    este.testaColisao(outro);
                }
            }
        }
    }

    public void OnInput(KeyCode keyCode, boolean isPressed) {
        nave.OnInput(keyCode, isPressed);
    }

    public void Draw(GraphicsContext graphicsContext) {
        for(Character c:activeChars){
            c.Draw(graphicsContext);
        }
    }

    public int activeCharsSize(){
        return activeChars.size();
    }
    
}
