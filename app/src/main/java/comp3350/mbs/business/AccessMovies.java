package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessMovies {
    private DataAccessStub dataAccess;

    //Constructor
    public AccessMovies(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getMovieList - a getter method for the movieList for the given theatre.
     * @param whichTheatre is the theatre that contains the list of movies.
     * @return it will return the movieList for the given theatre if it exists.
     *          Otherwise it will return null.
     */
    public List<Movie> getMovieList(Theatre whichTheatre){
        return dataAccess.getMovieList(whichTheatre);
    }//end getMovieList


}//end AccessMovies