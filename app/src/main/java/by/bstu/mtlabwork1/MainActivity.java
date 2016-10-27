package by.bstu.mtlabwork1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button button;
    private ListView listView;
    private ArrayList<Movie> listOfMovies = null;
    private MovieListAdapter adapter = null;
    private SQLite dbOpenHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbOpenHelper =  new SQLite(getApplicationContext());

        listOfMovies = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MovieListAdapter(MainActivity.this, R.layout.list_item, listOfMovies);
        listView.setAdapter(adapter);

        button = (Button) findViewById(R.id.container_popup).findViewById(R.id.action_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_button: {
                 Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (resultCode == RESULT_OK) {
            Movie movie = new Movie();
            movie.setName(data.getStringExtra("Name"));
            movie.setDirector(data.getStringExtra("Director"));
            movie.setYear(data.getStringExtra("Year"));
            movie.setMoney(data.getIntExtra("Money", 0));
            listOfMovies.add(movie);
            dbOpenHelper.addDataToDataBase(movie);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        dbOpenHelper.getValidDataFromDataBase(listOfMovies);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbOpenHelper.close();
    }
}
