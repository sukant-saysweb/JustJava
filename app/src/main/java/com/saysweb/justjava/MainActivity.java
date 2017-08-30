/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 *
 */

package com.saysweb.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfCoffees = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberOfCoffees);
        int cal_price = calculatePrice(numberOfCoffees, 40);
        String priceMessage = createOrderSummary(40);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, int cost) {
        int price = quantity * cost;
        return price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void removeCoffee(View view) {
        numberOfCoffees--;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void addCoffee(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }

    /**
     * Creates the summary of the order.
     *
     * @param orderPrice is the price of the order
     */
    private String createOrderSummary(int orderPrice){
        return "Name: Sukant Kumar \n Quantity: " + numberOfCoffees + "\n Total: " + calculatePrice(numberOfCoffees, orderPrice) + "\n Thank You!!!";
    }


    /**
     * This method displays the given price on the screen.
     *//*
    private void displayPrice(int number) {
        String priceMessage = "Total - " + NumberFormat.getCurrencyInstance().format(number) + "\n" + "Thank You!!!";
        displayMessage(priceMessage);
    }
    */

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}