import java.awt.*;

public class Balls {
    private Point[] balls;

    public Balls(int nbBalls) {
        balls = new Point[nbBalls];
        for (int i = 0; i < nbBalls; i++) {
            balls[i] = new Point(20 * i, 10);
        }
    }

    public Balls() {
        this(1);
    }

    public Point[] getBalls() {
        return balls;
    }

    public void setBalls(Point[] balls) {
        this.balls = balls;
    }

    public void translate(int dx, int dy) {
        for (Point ball : balls) {
            ball.translate(dx, dy);
        }
    }

    public void reInit() {
        int idx = 0;
        for (Point ball : balls) {
            ball.setLocation(15 * idx, 10);
            idx++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point ball : balls) {
            sb.append(ball.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
