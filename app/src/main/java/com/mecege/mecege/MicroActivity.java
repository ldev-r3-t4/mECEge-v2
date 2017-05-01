package com.mecege.mecege;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MicroActivity extends AppCompatActivity {

    Button button;
    private int micro_message_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro);

        addRefreshButton();
        addLoadButton();
        addSendButton();
    }

    public void addRefreshButton() {
        button = (Button) findViewById(R.id.micro_refreshbutton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                micro_message_count = 10;
                getMessages();
                updateMessageView("TODO_REFRESH: put real messages here");
                Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addLoadButton() {
        button = (Button) findViewById(R.id.micro_loadbutton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                micro_message_count += 10;
                getMessages();
                updateMessageView("TODO_LOAD: put real messages here");
                Toast.makeText(getApplicationContext(), "Loaded 10 more messages", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addSendButton() {
        button = (Button) findViewById(R.id.micro_sendbutton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                micro_message_count = 10;
                sendMessage();
                getMessages();
                updateMessageView("TODO_SEND: put real messages here");

                //hide keyboard
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    public void updateMessageView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.micro_messageview);
        textView.setText(toThis);
    }

    private void getMessages() {
        //TODO: get recent messages from the server

        /*************************************************************
         * include code here that manipulates the received message and
         * show it using the function updateMessageView(String toThis)
         *************************************************************/
    }

    private void sendMessage() {
        //TODO: send the new message to the server

        EditText editText = (EditText) findViewById(R.id.micro_messagebox);
        String new_message = (String) editText.getText().toString();

        //check for empty message
        if(new_message.equals("")) {
            errorMessage("ERROR: You can't send an empty message!");
            return;
        }

        /*************************************************************
         * new_message is the variable that has the user-typed message
         * include code here that manipulates the new message and
         * send it to the server
         *************************************************************/

        //toast notification
        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();

        //reset the EditText
        editText.setText("");
    }

    private void errorMessage(String toThis) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(toThis);
        builder.setCancelable(true);
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        AlertDialog alert1 = builder.create();
        alert1.show();
    }
}
