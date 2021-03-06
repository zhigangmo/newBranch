package comp3350.mbs.persistence;

import java.util.List;

import comp3350.mbs.objects.Snack;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;

public interface DataAccess {

    void open(String dbName);

    void close();

    List<Theatre> getTheatreList();

    List<TheatreMovies> getMoviesFromTheatre(TheatreMovies whichTheatre);

    List<ViewingTime> getViewingTimeList(TheatreMovies theatreMovie);//get the list of viewing time from the given theatre and movie.

    List<Ticket> getTicketList();

    Ticket getTicket(String movieName);

    String updateSeatList( ViewingTime vt, String s);

    Snack getSnack(String movieName);
}
