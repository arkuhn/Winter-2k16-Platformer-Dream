package Window;

/**
 * Created by ak101 on 12/19/2016.
 */

import oracle.jrockit.jfr.JFR;

import javax.swing.JFrame;

public class Game {

    public static void main(String[] args){

        //Create a window

        JFrame window = new JFrame("Winter at RIT");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);



    }
}
