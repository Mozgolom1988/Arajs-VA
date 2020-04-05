package geekbrains.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ArrayList;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    //
    private BackGround background;
    int numberBall =10;
    //

    ArrayList <Sprite> sprites = new ArrayList<>();
    //Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new MainCircles();
           }
       });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               if(e.getButton() ==1) {
                    sprites.add(new Ball());
                } else if(e.getButton() ==3) {
                   if(sprites.size() >0) {
                       sprites.remove(sprites.size() - 1);
                   }
                }

                }
            });

        add(canvas, BorderLayout.CENTER);

        setTitle("Circles");
        initApplication();
        setVisible(true);
    }

    private void initApplication() {

        for (int i = 0; i < numberBall; i++) {
            sprites.add(new Ball());
        }
        background = new BackGround();
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(canvas, deltaTime);
        }
        background.update(canvas, deltaTime);
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(canvas, g);
        }
        background.render(canvas,g);
    }
}
