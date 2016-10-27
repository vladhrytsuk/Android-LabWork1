package by.bstu.mtlabwork1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListAdapter extends ArrayAdapter<Movie> {

    private ArrayList<Movie> listOfMovies = null;
    private TextView viewName;
    private TextView viewDirector;
    private TextView viewYear;
    private TextView viewMoney;

    public MovieListAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        this.listOfMovies = objects;
    }

    @Override
    public int getCount() {
        return listOfMovies.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

        viewName = (TextView) convertView.findViewById(R.id.viewName);
        viewDirector = (TextView) convertView.findViewById(R.id.viewDirector);
        viewYear = (TextView) convertView.findViewById(R.id.viewYear);
        viewMoney = (TextView) convertView.findViewById(R.id.viewMoney);

        Movie movie = listOfMovies.get(position);

        viewName.setText(movie.getName());
        viewDirector.setText(movie.getDirector());
        viewYear.setText(movie.getYear());
        viewMoney.setText(Integer.toString(movie.getMoney(), 10));

        return convertView;
    }
}
