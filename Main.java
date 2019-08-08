package ivan.samoylov;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
      launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      primaryStage.setTitle("World");
      Canvas canvas = new Canvas();
      canvas.setHeight(BOARD_HEIGHT);
      canvas.setWidth(BOARD_WIDTH);
      BorderPane group = new BorderPane(canvas);
      Scene scene = new Scene(group);
      primaryStage.setScene(scene);
      primaryStage.show();

      GraphicsContext gc = canvas.getGraphicsContext2D();
      drawWorld(gc);
    }

    private void drawWorld(GraphicsContext gc) {
        final int SUN_DIAMETR = 120;
        final double X_ROOF[] = {70, 210, 140};
        final double Y_ROOF[] = {BOARD_HEIGHT - 140,
                                 BOARD_HEIGHT - 140,
                                 BOARD_HEIGHT - 200};
        final int ROOF_POINTS = 3;

        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT - 50);
        gc.setFill(Color.SLATEGRAY);
        gc.fillRect(0, BOARD_HEIGHT - 50, BOARD_WIDTH, 50);

        gc.setFill(Color.ORANGE);
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(50);

        gc.fillOval(600, 10, SUN_DIAMETR,SUN_DIAMETR);
        gc.strokeOval(600, 10, SUN_DIAMETR,SUN_DIAMETR);

        gc.setFill(Color.GHOSTWHITE);
        gc.fillOval(200, 80, 140,30);
        gc.fillOval(50, 120, 90,25);
        gc.fillOval(450, 130, 110,35);

        gc.setFill(Color.BROWN);
        gc.fillRect(80, BOARD_HEIGHT - 140, 120, 90);
        gc.fillPolygon(X_ROOF, Y_ROOF, ROOF_POINTS);
    }
}
