
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Examp1 extends Application {
    private String operation = ""; // To store the selected operation

    public void start(Stage primaryStage) {
        // UI controls
        Label l1 = new Label("First number:");
        Label l2 = new Label("Second number:");
        Label l3 = new Label("Result =");

        TextField t1 = new TextField();
        TextField t2 = new TextField();

        Button b1 = new Button("+");
        Button b2 = new Button("-");
        Button b3 = new Button("*");
        Button b4 = new Button("/");
        Button b5 = new Button("Calculate");

        // Layout
        FlowPane root = new FlowPane();
        root.setHgap(10); // Optional spacing for better layout
        root.setVgap(10);
        root.getChildren().addAll(l1, t1, b1, b2, b3, b4, l2, t2, l3, b5);

        // Scene
        Scene s1 = new Scene(root, 400, 400);

        // Stage
        primaryStage.setScene(s1);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

        // Set operation when operation buttons are clicked
        b1.setOnAction(e -> operation = "+");
        b2.setOnAction(e -> operation = "-");
        b3.setOnAction(e -> operation = "*");
        b4.setOnAction(e -> operation = "/");

        // Perform calculation when "Calculate" is clicked
        b5.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        l3.setText("Result = " + result);
                        break;
                    case "-":
                        result = num1 - num2;
                        l3.setText("Result = " + result);
                        break;
                    case "*":
                        result = num1 * num2;
                        l3.setText("Result = " + result);
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                            l3.setText("Result = " + result);
                        } else {
                            l3.setText("Error: Division by zero");
                        }
                        break;
                    default:
                        l3.setText("Please select an operation");
                }
            } catch (NumberFormatException ex) {
                l3.setText("Invalid input");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

