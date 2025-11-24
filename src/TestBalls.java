public class TestBalls {
    public static void main(String[] args) {
        Balls balls = new Balls(10);
        System.out.println(balls);
        balls.translate(10, 10);
        System.out.println(balls);
        balls.reInit();
        System.out.println(balls);
    }
}