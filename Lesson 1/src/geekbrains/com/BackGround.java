package geekbrains.com;

import java.awt.*;

public class BackGround {
    int red;
    int green;
    int blue;
    int SpeedRed;
    int SpeedGreen;
    int SpeedBlue;


    BackGround () {
        //Начальный цвет белый
        red   = 255;
        green = 255;
        blue  = 255;

        //Скорость изменения трех измерений:
        SpeedRed   = (int)(Math.random() * 5);
        SpeedGreen = (int)(Math.random() * 5);
        SpeedBlue  = (int)(Math.random() * 5);
    }

    void update(GameCanvas canvas, float deltaTime) {

        red   -= SpeedRed;
        green -= SpeedGreen;
        blue  -= SpeedBlue;
        if (red <=0) {
            red = 0;
            SpeedRed = -SpeedRed;
        }
        if (red >=255) {
            red = 255;
            SpeedRed = -SpeedRed;
        }

        if (green <=0) {
            green = 0;
            SpeedGreen = -SpeedGreen;
        }
        if (green >=255) {
            green = 255;
            SpeedGreen = -SpeedGreen;
        }

        if (blue <=0) {
            blue = 0;
            SpeedBlue = -SpeedBlue;
        }
        if (blue >=255) {
            blue = 255;
            SpeedBlue = -SpeedBlue;
        }


    }


    void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(new Color(red,green,blue));
    }

}
