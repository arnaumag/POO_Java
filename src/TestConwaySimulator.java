import gui.GUISimulator;
import java.awt.Color;

public class TestConwaySimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        ConwaySimulator ConwaySimulator = new ConwaySimulator(gui);

        gui.setSimulable(ConwaySimulator);
    }

}
