package com.example.texttospeechapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainActivity1 {

    private TextToSpeech textToSpeech;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(this,this::onInit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }

            private void speak() {
            }
        });

    }


    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {

            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("KEY", "Language not supported");
            } else {
                button.setEnabled(true);
                speak();
            }

        } else {
            Log.d("KEY", "Error");
        }
    }

    private void speak() {
    }
}