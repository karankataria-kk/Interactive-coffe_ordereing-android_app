package com.example.android.ordering_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(quantity);
        //displayPrice(quantity * 5);
        displayPrice(quantity);
        String pricedetail=orderSummary();
        displayMessage(pricedetail);
    }
    public String orderSummary(){
        String message="Name : Karan \nTotal cups of coffe : "+quantity+" \nThanks!!";
        message=message+"\nTotal amount is : "+(quantity*5);
        return  message;
    }
    public void increment_it(View view) {
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity);
    }

    public void decrement_it(View view) {
        quantity = quantity - 1;
        if (quantity<=0){
            quantity=0;
        }
        display(quantity);
        displayPrice(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        int price_updated=number*5;
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(price_updated));
    }
}