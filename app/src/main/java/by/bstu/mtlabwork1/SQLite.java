package by.bstu.mtlabwork1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static by.bstu.mtlabwork1.Constants.*;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context) {
        super(context,  BAL_DATABASE_NAME, null, BAL_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + BAL_TABLE_MOVIE
                + " ("
                + BAL_MOVIE_ID + " integer primary key autoincrement, "
                + BAL_MOVIE_NAME + " text, "
                + BAL_MOVIE_DIRECTOR + " text, "
                + BAL_MOVIE_YEAR + " text, "
                + BAL_MOVIE_MONEY + " integer"
                + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDataToDataBase(Movie movie) {
        SQLiteDatabase dealsDB = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BAL_MOVIE_NAME, movie.getName());
        values.put(BAL_MOVIE_DIRECTOR, movie.getDirector());
        values.put(BAL_MOVIE_YEAR, movie.getYear());
        values.put(BAL_MOVIE_MONEY, movie.getMoney());

        if (dealsDB.insert(BAL_TABLE_MOVIE, null, values) == -1) {
            Log.e("ERROR", "Can not write to db");
        }

        dealsDB.close();
    }

    public void getValidDataFromDataBase(ArrayList<Movie> listOfMovies) {
        SQLiteDatabase dealsDB = getWritableDatabase();

        String[] columns = new String[] {
                BAL_MOVIE_NAME,
                BAL_MOVIE_DIRECTOR,
                BAL_MOVIE_YEAR,
                BAL_MOVIE_MONEY
        };

        Cursor cursor = dealsDB.query(BAL_TABLE_MOVIE, columns, null, null, null, null, null);
        listOfMovies.clear();

        if (!cursor.isAfterLast()) {

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Movie movie = new Movie();
                movie.setName(cursor.getString(cursor.getColumnIndex(BAL_MOVIE_NAME)));
                movie.setDirector(cursor.getString(cursor.getColumnIndex(BAL_MOVIE_DIRECTOR)));
                movie.setYear(cursor.getString(cursor.getColumnIndex(BAL_MOVIE_YEAR)));
                movie.setMoney(cursor.getInt(cursor.getColumnIndex(BAL_MOVIE_MONEY)));

                listOfMovies.add(movie);

                cursor.moveToNext();
            }

        }

        cursor.close();
        dealsDB.close();

    }
}
