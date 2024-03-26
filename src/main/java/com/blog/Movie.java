package com.blog;

public class Movie {
    private long Year  ;
    private int rating ;
    private String movieName;

    public long getYear() {
        return Year;
    }

    public void setYear(long year) {
        Year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie(long year, int rating, String movieName) {
        Year = year;
        this.rating = rating;
        this.movieName = movieName;
    }


//    @Override
//    public int compareTo(Movie o) {
//        return this.rating - o.rating;
//    }
}
