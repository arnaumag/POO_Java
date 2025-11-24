import java.awt.*;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;

public class ConwaySimulator implements Simulable {
    private Conway conway;
    private GUISimulator gui;

    public ConwaySimulator(GUISimulator gui, Conway conway) {
        this.gui = gui;
        this.conway = conway;
    }

    public ConwaySimulator(GUISimulator gui) {
        this(gui, new Conway(10));
    }

    public ConwaySimulator() {
        this(new GUISimulator(500, 500, Color.BLACK), new Conway(10));
    }

    @Override
    public void next() {
        conway.nextGeneration();
        boolean[][] cells = conway.getCells();

        gui.reset();
        for (int i = 0; i < cells.length; i++) {
            boolean[] row = cells[i];
            for (int j = 0; j < row.length; j++) {
                if (cells[i][j]) {
                    gui.addGraphicalElement(new Rectangle(i * 10, j * 10, Color.RED, Color.RED, 10));
                } else {
                    gui.addGraphicalElement(new Rectangle(i * 10, j * 10, Color.WHITE, Color.WHITE, 10));
                }
            }
        }
    }

    @Override
    public void restart() {
        conway.reInit();
        gui.reset();
        boolean[][] cells = conway.getCells();
        for (int i = 0; i < cells.length; i++) {
            boolean[] row = cells[i];
            for (int j = 0; j < row.length; j++) {
                if (cells[i][j]) {
                    gui.addGraphicalElement(new Rectangle(i * 10, j * 10, Color.RED, Color.RED, 10));
                } else {
                    gui.addGraphicalElement(new Rectangle(i * 10, j * 10, Color.WHITE, Color.WHITE, 10));
                }
            }
        }
    }

}
