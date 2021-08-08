/* RestaurantBill | @Author - Brandon Thompson | 04/25/2021 | @Version Java 15 | @Version jGRASP 2.0.6_05
Write a program that simulates a restaurant bill with buttons to add menu items and print out total
**/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantBill extends Application
{
   private double balance;

   private static final double INITIAL_BALANCE = 0;

   public void start(Stage stage1)
   {
      Pane root = createRootPane();
      Scene scene1 = new Scene(root);
      stage1.setScene(scene1);
      stage1.setTitle("My Restaurant Bill");
      stage1.show();
   }

   private Pane createRootPane()
   {
      balance = INITIAL_BALANCE;

      Label totalLabel = new Label("TOTAL:");
      TextField totalField = new TextField("" + INITIAL_BALANCE);

      Button burgerButton = new Button("Burger");
      Button wingsButton = new Button("Wings");
      Button cokeButton = new Button("Coke");
      Button pieButton = new Button("Pie");
      Button milkshakeButton = new Button("Milkshake");
      
      String initialContents = String.format("$%.2f%n", balance);
      TextArea resultsArea = new TextArea(initialContents);
      final int ROW_COUNT = 10;
      final int COLUMN_COUNT = 20;
      resultsArea.setPrefRowCount(ROW_COUNT);
      resultsArea.setPrefColumnCount(COLUMN_COUNT);
      resultsArea.setEditable(false);

      Pane pane1 = new VBox(totalLabel, totalField,
         burgerButton, wingsButton, cokeButton, pieButton, milkshakeButton, resultsArea);

      burgerButton.setOnAction(event ->
      {
         // burger cost is $5
         balance = balance + 5;
         totalField.setText(String.format("$%.2f%n", balance));
         resultsArea.appendText(String.format("%-10s $%5.2f%n", "Burger", 5.0));
      });
      
      wingsButton.setOnAction(event ->
      {
         // wings cost is $3.50
         balance = balance + 3.50;
         totalField.setText(String.format("$%.2f%n", balance));
         resultsArea.appendText(String.format("%-10s $%5.2f%n", "Wings", 3.50));
      });
      
      cokeButton.setOnAction(event ->
      {
         // coke cost is $2
         balance = balance + 2;
         totalField.setText(String.format("$%.2f%n", balance));
         resultsArea.appendText(String.format("%-10s $%5.2f%n", "Coke", 2.0));
      });
      
      pieButton.setOnAction(event ->
      {
         // Pie cost is $4
         balance = balance + 4;
         totalField.setText(String.format("$%.2f%n", balance));
         resultsArea.appendText(String.format("%-10s $%5.2f%n", "Pie", 4.0));
      });
      
      milkshakeButton.setOnAction(event ->
      {
         // Milkshake cost is $3
         balance = balance + 3;
         totalField.setText(String.format("$%.2f%n", balance));
         resultsArea.appendText(String.format("%-10s $%5.2f%n", "Milkshake", 3.0));
      });
      
      return pane1;
   }
}
