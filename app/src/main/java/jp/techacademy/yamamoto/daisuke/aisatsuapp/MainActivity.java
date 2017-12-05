package jp.techacademy.yamamoto.daisuke.aisatsuapp;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button1) {
                    showTimetDialog();
                }
            }
            private void showTimetDialog() {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(hourOfDay >= 2 && hourOfDay <= 9) {
                            textView.setText("おはよう");
                        }else if(hourOfDay >= 10 && hourOfDay <= 17) {
                            textView.setText("こんにちは");
                        }else {
                            textView.setText("こんばんは");
                        };
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
    }


}
