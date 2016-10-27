package by.bstu.mtlabwork1;

public class Movie {
    private String name;
    private String director;
    private String year;
    private int money;

    public Movie() {
    }

    public Movie(String name, String director, String year, int money) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
