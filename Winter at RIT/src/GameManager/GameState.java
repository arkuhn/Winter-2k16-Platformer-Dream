package GameManager;

/**
 * Created by ak101 on 12/19/2016.
 */
public abstract class GameState {

    protected GameStateManager gsm;

    public abstract void init();
    public abstract void update();
    public abstract void draw(java.awt.Graphics2D g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);

}
