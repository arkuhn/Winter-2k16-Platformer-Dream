package GameManager;

import java.awt.*;
import TileMap.Background;
import java.awt.event.KeyEvent;
import java.io.File;


/**
 * Created by ak101 on 12/19/2016.
 */
public class MenuState extends GameState {

    private Background bg;

    private int currentChoice = 0;
    private String[] options = {
            "Go to class",
            "Help",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm) {

        this.gsm = gsm;

        try {

            bg = new Background("/Backgrounds/RIT winter 1.png", 1);
            bg.setVector(-0.1, 0);

            titleColor = new Color(255, 250, 250);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            File fontFile = new File(this.getClass().getResource("res/Fonts/3Dventure.ttf").toURI());
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,  new File("C:\\Users\\ak101\\IdeaProjects\\Winter-2k16-Platformer-Dream\\Winter at RIT\\res\\Fonts\\3Dventure.ttf")));
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\ak101\\IdeaProjects\\Winter-2k16-Platformer-Dream\\Winter at RIT\\res\\FontsVCR_OSD_MONO_1.ttf")));
            //ystem.out.println(fontFamilies);
            titleFont = new Font("3DVenture", Font.PLAIN, 28);
            //font = new Font("VCR_OSD_MONO_1", Font.PLAIN, 12);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    private void select() {
        if(currentChoice == 0) {
            gsm.setState(GameStateManager.LEVEL1STATE);
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    public void init() {

    }

    public void update() {
        //bg.update();
    }

    public void draw(Graphics2D g) {
        // draw bg
        bg.draw(g);

        // draw title
        g.setColor(titleColor);


        g.setFont(titleFont);
        g.drawString("Winter at RIT", 80, 70);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.BLACK);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }

    public void keyReleased(int k) {

    }
}
