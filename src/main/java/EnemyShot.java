/* Lucas Treviso Bandeira - 21104312-0
 * Natália Dal Pizzol - 21200917-9
 * Vermon João de Aguiar Neto - 21200965-8
 */

public class EnemyShot extends Shot{

    public EnemyShot(int px, int py) {
        super(px, py);
    }

    @Override
    public void testaColisao(Character outro) {
        if (outro instanceof Enemies || outro instanceof Shot){
            return;
        }else{
            super.testaColisao(outro);
        }
    }

}
