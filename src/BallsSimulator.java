import java.awt.*;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;

public class BallsSimulator implements Simulable {
    private Balls balls;
    private GUISimulator gui;
    private int dx = 10;
    private int dy = 10;

    public BallsSimulator(GUISimulator gui, Balls balls) {
        this.gui = gui;
        this.balls = balls;
    }

    public BallsSimulator(GUISimulator gui) {
        this(gui, new Balls(10));
    }

    public BallsSimulator() {
        this(new GUISimulator(500, 500, Color.BLACK), new Balls(10));
    }

    @Override
    public void next() {
        int height = gui.getPanelHeight();
        int width = gui.getPanelWidth();
        for (Point ball : balls.getBalls()) {
            if (ball.getX() + 10 >= width) {
                dx = -10;
            } else if (ball.getY() + 10 >= height) {
                dy = -10;
            } else if (ball.getX() <= 0) {
                dx = 10;
            } else if (ball.getY() <= 0) {
                dy = 10;
            }
            ball.translate(dx, dy);
        }
        System.out.println(balls.toString());

        gui.reset();
        for (Point ball : balls.getBalls()) {
            gui.addGraphicalElement(new Rectangle((int) ball.getX(), (int) ball.getY(), Color.RED, Color.RED, 10));
        }
    }

    @Override
    public void restart() {
        balls.reInit();
        gui.reset();
        for (Point ball : balls.getBalls()) {
            gui.addGraphicalElement(new Rectangle((int) ball.getX(), (int) ball.getY(), Color.RED, Color.RED, 10));
        }
    }

}