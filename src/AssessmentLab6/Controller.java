package AssessmentLab6;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    Canvas myBoard;

    @FXML
    RadioButton rbtnRED;

    @FXML
    RadioButton rbtnGREEN;

    @FXML
    RadioButton rbtnBLUE;


    @FXML
    RadioButton rbtnERASER;

    @FXML
    RadioButton rbtnBLACK;

    Color color = Color.BLACK;

    ToggleGroup tg = new ToggleGroup();

    Cursor cursor = Cursor.DEFAULT;

    Double size = 5.0;

    Double initial_x;
    Double initial_y;

    Boolean firstPoint = true;





    public void initialize(){

        rbtnRED.setToggleGroup(tg);
        rbtnGREEN.setToggleGroup(tg);
        rbtnBLUE.setToggleGroup(tg);
        rbtnBLACK.setToggleGroup(tg);
        rbtnERASER.setToggleGroup(tg);

        rbtnRED.setOnAction(radioClickHandler);
        rbtnBLACK.setOnAction(radioClickHandler);
        rbtnGREEN.setOnAction(radioClickHandler);
        rbtnBLUE.setOnAction(radioClickHandler);
        rbtnERASER.setOnAction(radioClickHandler);

        rbtnBLACK.setSelected(true);


        GraphicsContext gc = myBoard.getGraphicsContext2D();

        myBoard.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myBoard.setCursor(cursor);
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();

                if (firstPoint){
                    initial_x = x;
                    initial_y = y;
                    firstPoint = false;
                }

                gc.setStroke(color);
                gc.setLineWidth(size);
                gc.strokeLine(x,y,initial_x,initial_y);
                initial_x = x;
                initial_y = y;


            }
        });



        myBoard.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myBoard.setCursor(Cursor.DEFAULT);
                firstPoint = true;
            }
        });


    }

    EventHandler<ActionEvent> radioClickHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

            if(rbtnBLACK.isSelected()){
                color = Color.BLACK;
                cursor = Cursor.HAND;
                size = 5.0;
            }
            if(rbtnRED.isSelected()){
                color = Color.RED;
                cursor = Cursor.HAND;
                size = 5.0;
            }
            if(rbtnBLUE.isSelected()){
                color = Color.BLUE;
                cursor = Cursor.HAND;
                size = 5.0;
            }
            if(rbtnGREEN.isSelected()){
                color = Color.GREEN;
                cursor = Cursor.HAND;
                size = 5.0;
            }
            if(rbtnERASER.isSelected()){
                color = Color.WHITE;
                cursor = Cursor.OPEN_HAND;
                size = 15.0;
            }

        }
    };

}
