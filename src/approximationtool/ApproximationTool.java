package approximationtool;

import approximationtool.ApproximationMethods.Betas;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.function.Function;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;

/**
 *
 * @author yassine  
 */
public class ApproximationTool extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Axes axes = new Axes(
                512, 400,
                -10, 10, 1,
                -8, 8, 1
        );
        Point[] points = new Point[4];

        points[0] = new Point(10, 5);
        points[1] = new Point(6, 9);
        points[2] = new Point(7, 3);
        points[3] = new Point(2, 0);
        
        Betas betas = ApproximationMethods.leastSquaresMethod(points);
        
        //Plot plot = new Plot(points, -10, 10, 0.01, axes);
        Plot plot = new Plot(
                x -> betas.a * x + betas.b,
                -10, 10, 0.01,
                axes
        );
        SplitPane splitPane = null;

        for(Node node : ((BorderPane) root).getChildren()) {
            if(node instanceof SplitPane) {
                splitPane = (SplitPane) node;
            }
        }
        
        if (splitPane != null) {
            splitPane.getItems().add(1, plot);
        }


        TableView tableView = null;
        for(Node node :((BorderPane) root).getChildren()) {
            if(node instanceof TableView)
                tableView = (TableView) node;
        }
        
        if(tableView != null) {
            
        }
        
        
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
