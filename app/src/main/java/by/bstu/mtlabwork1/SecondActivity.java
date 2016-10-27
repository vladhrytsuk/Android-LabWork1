package by.bstu.mtlabwork1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView director;
    private TextView year;
    private Button addButton;
    private RadioButton radioButton100;
    private RadioButton radioButton100500;
    private RadioButton radioButton500;
    private int money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = (TextView) findViewById(R.id.editName);
        director = (TextView) findViewById(R.id.editDirector);
        year = (TextView) findViewById(R.id.editYear);

        addButton = (Button) findViewById(R.id.addButton);

        radioButton100 = (RadioButton) findViewById(R.id.radioButton100);
        radioButton100500 = (RadioButton) findViewById(R.id.radioButton100500);
        radioButton500 = (RadioButton) findViewById(R.id.radioButton500);

        addButton.setOnClickListener(this);
        radioButton100.setOnClickListener(this);
        radioButton100500.setOnClickListener(this);
        radioButton500.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton: {
                Intent intent = new Intent();
                intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Director", director.getText().toString());
                intent.putExtra("Year", year.getText().toString());
                intent.putExtra("Money", money);
                setResult(RESULT_OK, intent);
                finish();
                break;
            }
            case R.id.radioButton100: {
                money = 50000;
                break;
            }
            case R.id.radioButton100500: {
                money = 150000;
                break;
            }
            case R.id.radioButton500: {
                money = 550000;
                break;
            }
        }
    }
}
