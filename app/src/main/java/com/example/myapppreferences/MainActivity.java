package com.example.myapppreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    public static final String PREFS_WORLD_READ = "PREFS_WORLD_READABLE";
    public static final String PREFS_WORLD_WRITE = "PREFS_WORLD_WRITABLE";
    public static final String PREFS_WORLD_READ_WRITE =
            "PREFS_WORLD_READABLE_WRITABLE";
    public static final String KEY_PRIVATE = "KEY_PRIVATE";
    public static final String KEY_WORLD_READ = "KEY_WORLD_READ";
    public static final String KEY_WORLD_WRITE = "KEY_WORLD_WRITE";
    public static final String KEY_WORLD_READ_WRITE =
            "KEY_WORLD_READ_WRITE";


    private SharedPreferences prefsPrivate;
    private SharedPreferences prefsWorldRead;
    private SharedPreferences prefsWorldWrite;
    private SharedPreferences prefsWorldReadWrite;

    private AppCompatButton registerButton ;
    private AppCompatEditText myEdithText;
    private String temporaryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateWidget();
        setupWidgetsLister();

    }

    private void setupWidgetsLister() {
        registerButton.setOnClickListener(this);
        myEdithText.addTextChangedListener(makeTextWatcher("[a-ZA-Z]"));
    }

    private TextWatcher makeTextWatcher(String cric){
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().matches(cric)){
                    Toast.makeText(getApplicationContext(),"Only Alphabetic Character",Toast.LENGTH_SHORT).show();
                }else{
                    temporaryName = s.toString();
                }
            }
        };
        return textWatcher;
    }
    private void initiateWidget() {
        registerButton = findViewById(R.id.validation_button);
    myEdithText = findViewById(R.id.fullname_edit_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.validation_button:
                treatmentCase();
        }
    }

    private void treatmentCase() {
    }
}