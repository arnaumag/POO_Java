public class TestConway {
    public static void main(String[] args) {
        Conway conway = new Conway(10);
        System.out.println(conway);
        conway.reInit();
        System.out.println(conway);
        conway.nextGeneration();
        System.out.println(conway);
    }

}
