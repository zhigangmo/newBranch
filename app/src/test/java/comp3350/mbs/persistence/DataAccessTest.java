package comp3350.mbs.persistence;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessTest extends TestCase {
    private DataAccess dataAccess;
    public DataAccessTest(String arg0){super(arg0);}

    public void setUp(){
        System.out.println("\nStarting Persistence test DataAccess (using stub)");

        // Use the following statements to run with the stub database:
        //dataAccess = new DataAccessStub();
        //dataAccess.open("Stub");
        // or switch to the real database:
         dataAccess = new DataAccessObject(Main.dbName);
         dataAccess.open(Main.getDBPathName());
        // Note the increase in test execution time.
    }

    public void tearDown() {
        dataAccess.close();
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    @Test
    public void testGetTheatreList(){
        List<Theatre> theatreList;
        Theatre theatre;
        System.out.println("Starting DataAccessTest: testGetTheatreList");

        theatreList = dataAccess.getTheatreList();
        assertNotNull(theatreList);
        assertEquals(3,theatreList.size());

        theatre = theatreList.get(0);//get theatre1 (Scotiabank Theatre)
        assertNotNull(theatre);
        assertEquals("Scotiabank Theatre",theatre.getName());
        assertEquals("817 St.James",theatre.getAddress());
        assertEquals("15.7km",theatre.getDistance());

        theatre = theatreList.get(1);//get theatre2 (Cinema City Northgate)
        assertNotNull(theatre);
        assertEquals("Cinema City Northgate",theatre.getName());
        assertEquals("1399 McPhillips St.",theatre.getAddress());
        assertEquals("10km",theatre.getDistance());

        theatre = theatreList.get(2);//get theatre3 (Silver City St.Vital Cinemas)
        assertNotNull(theatre);
        assertEquals("Silver City St.Vital Cinemas",theatre.getName());
        assertEquals("160-1225 St Mary's Rd",theatre.getAddress());
        assertEquals("19.8km",theatre.getDistance());

        System.out.println("Finished DataAccessTest: testGetTheatreList");

    }//end testGetTheatreList

    @Test
    public void testGetMoviesFromTheatre1(){
        List<TheatreMovies> theatreMoviesList;
        TheatreMovies theatreMovie;

        System.out.println("Starting DataAccessTest: testGetMoviesFromTheatre1");
        theatreMoviesList = dataAccess.getMoviesFromTheatre(new TheatreMovies("Scotiabank Theatre",null));
        assertNotNull(theatreMoviesList);
        assertEquals(5,theatreMoviesList.size());

        theatreMovie = theatreMoviesList.get(0); //movie 1 (Avengers Endgame)
        assertNotNull(theatreMovie);
        assertEquals("Scotiabank Theatre",theatreMovie.getTheatreName());
        assertEquals("Avengers Endgame",theatreMovie.getMovieName());
        assertEquals(R.drawable.avengers_endgame,theatreMovie.getMoviePoster());
        assertEquals("Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(1);//movie 2 (The Incredibles)
        assertNotNull(theatreMovie);
        assertEquals("Scotiabank Theatre",theatreMovie.getTheatreName());
        assertEquals("The Incredibles",theatreMovie.getMovieName());
        assertEquals(R.drawable.incredibles,theatreMovie.getMoviePoster());
        assertEquals("In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(2);//movie 3 (Superman)
        assertNotNull(theatreMovie);
        assertEquals("Scotiabank Theatre",theatreMovie.getTheatreName());
        assertEquals("Superman",theatreMovie.getMovieName());
        assertEquals(R.drawable.superman,theatreMovie.getMoviePoster());
        assertEquals("Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(3);//movie 4 (The Lion King)
        assertNotNull(theatreMovie);
        assertEquals("Scotiabank Theatre",theatreMovie.getTheatreName());
        assertEquals("The Lion King",theatreMovie.getMovieName());
        assertEquals(R.drawable.lion_king,theatreMovie.getMoviePoster());
        assertEquals("This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(4);//movie 5 (Star Wars)
        assertNotNull(theatreMovie);
        assertEquals("Scotiabank Theatre",theatreMovie.getTheatreName());
        assertEquals("Star Wars",theatreMovie.getMovieName());
        assertEquals(R.drawable.starwars,theatreMovie.getMoviePoster());
        assertEquals( "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.",theatreMovie.getMovieDescription());

        System.out.println("Finished DataAccessTest: testGetMoviesFromTheatre1");

    }//end testGetMoviesFromTheatre1

    @Test
    public void testGetMoviesFromTheatre2(){

        List<TheatreMovies> theatreMoviesList;
        TheatreMovies theatreMovie;

        System.out.println("Starting DataAccessTest: testGetMoviesFromTheatre2");
        theatreMoviesList = dataAccess.getMoviesFromTheatre(new TheatreMovies("Cinema City Northgate",null));
        assertNotNull(theatreMoviesList);
        assertEquals(2,theatreMoviesList.size());

        theatreMovie = theatreMoviesList.get(0);//movie 1 (Avengers Endgame)
        assertNotNull(theatreMovie);
        assertEquals("Cinema City Northgate",theatreMovie.getTheatreName());
        assertEquals("Avengers Endgame",theatreMovie.getMovieName());
        assertEquals(R.drawable.avengers_endgame,theatreMovie.getMoviePoster());
        assertEquals("Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(1); //movie 2 (The Incredibles)
        assertNotNull(theatreMovie);
        assertEquals("Cinema City Northgate",theatreMovie.getTheatreName());
        assertEquals("The Incredibles",theatreMovie.getMovieName());
        assertEquals(R.drawable.incredibles,theatreMovie.getMoviePoster());
        assertEquals("In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.",theatreMovie.getMovieDescription());

        System.out.println("Finished DataAccessTest: testGetMoviesFromTheatre2");

    }//end testGetMoviesFromTheatre2

    @Test
    public void testGetMoviesFromTheatre3(){
        List<TheatreMovies> theatreMoviesList;
        TheatreMovies theatreMovie;

        System.out.println("Starting DataAccessTest: testGetMoviesFromTheatre3");
        theatreMoviesList = dataAccess.getMoviesFromTheatre(new TheatreMovies("Silver City St.Vital Cinemas",null));
        assertNotNull(theatreMoviesList);
        assertEquals(3,theatreMoviesList.size());

        theatreMovie = theatreMoviesList.get(0);//movie 1 (Superman)
        assertNotNull(theatreMovie);
        assertEquals("Silver City St.Vital Cinemas",theatreMovie.getTheatreName());
        assertEquals("Superman",theatreMovie.getMovieName());
        assertEquals(R.drawable.superman,theatreMovie.getMoviePoster());
        assertEquals("Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(1);//movie 2 (The Lion King)
        assertNotNull(theatreMovie);
        assertEquals("Silver City St.Vital Cinemas",theatreMovie.getTheatreName());
        assertEquals("The Lion King",theatreMovie.getMovieName());
        assertEquals(R.drawable.lion_king,theatreMovie.getMoviePoster());
        assertEquals("This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).",theatreMovie.getMovieDescription());

        theatreMovie = theatreMoviesList.get(2);//movie 3 (Star Wars)
        assertNotNull(theatreMovie);
        assertEquals("Silver City St.Vital Cinemas",theatreMovie.getTheatreName());
        assertEquals("Star Wars",theatreMovie.getMovieName());
        assertEquals(R.drawable.starwars,theatreMovie.getMoviePoster());
        assertEquals( "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.",theatreMovie.getMovieDescription());


        System.out.println("Finished DataAccessTest: testGetMoviesFromTheatre3");

    }//end testGetMoviesFromTheatre3

    @Test
    public void testValidViewingTimeUpdate(){
        System.out.println("Starting DataAccessTest: testValidViewingTimeUpdate");
        List<TheatreMovies> theatreMoviesList = dataAccess.getMoviesFromTheatre(new TheatreMovies("Scotiabank Theatre",null));

        ViewingTime vt = dataAccess.getViewingTimeList( theatreMoviesList.get(0)).get(0);
        String showTime = vt.getShowTime();

        assertNotNull(vt);
        //assertEquals( vt.getSeatString(), "00000000000000000000000000000000");

        String updateResult = dataAccess.updateSeatList( vt, "11111111111111111111111111111111");

        assertEquals( updateResult, "Success");

        //vt = dataAccess.getViewingTimeList( theatreMoviesList.get(0)).get((0));
        List<ViewingTime> vtList = dataAccess.getViewingTimeList( theatreMoviesList.get(0) );
        for( int i = 0; i < vtList.size(); i++ ){
            if( vtList.get(i).getShowTime().equals( showTime )){
                vt = vtList.get(i);
            }
        }
        System.out.println( vt.getShowTime() + " " + vt.getSeatString() );
        assertEquals( vt.getSeatString(), "11111111111111111111111111111111");

        System.out.println("Finished DataAccessTest: testValidViewingTimeUpdate");

        //reset viewing time status and order
        dataAccess.updateSeatList( vt, "00000000000000000000000000000000");
        vtList = dataAccess.getViewingTimeList( theatreMoviesList.get(0));
        for( int i = 0; i < vtList.size()-1; i++ ){
            dataAccess.updateSeatList( vtList.get(i), "00000000000000000000000000000000");
        }


    }//end testValidViewingTimeUpdate


    @Test
    public void testInvalidViewingtimeUpdate(){
        System.out.println("Starting DataAccessTest: testInvalidViewingTimeUpdate");

        //Create a viewing time that is not in the database
        ViewingTime vt = new ViewingTime( "Xtheatre", "Xmovie", "Right Now", "Today", "1234567890");

        //attempt to update
        String updateResult = dataAccess.updateSeatList( vt, "00000000000000000000000000000000");

        assertEquals( updateResult, "Failure");

        System.out.println("Finished DataAccessTest: testInvalidViewingTimeUpdate");
    }//end testInvalidViewingtimeUpdate


    @Test
    public void testGetValidTicket(){
        System.out.println("Starting DataAccessTest: testGetValidTicket");

        //attempt to retrieve a ticket that is in the db
       Ticket ticketResult = dataAccess.getTicket("Avengers Endgame");

        assertEquals(10.00, ticketResult.getPrice());
        assertEquals("Avengers Endgame", ticketResult.getMovieName());

        System.out.println("Finished DataAccessTest: testGetValidTicket");
    }//end testGetValidTicket


    @Test
    public void testGetInvalidTicket(){
        System.out.println("Starting DataAccessTest: testGetInvalidTicket");

        //attempt to retrieve a ticket that is in the db
        Ticket ticketResult = dataAccess.getTicket("Avengers Endgame");

        assertEquals(10.00, ticketResult.getPrice());
        assertEquals("Avengers Endgame", ticketResult.getMovieName());

        System.out.println("Finished DataAccessTest: testGetInvalidTicket");
    }//end testGetInvalidTicket


    @Test
    public void testGetViewingTimeList(){
        System.out.println("Starting DataAccessTest: testGetViewingTimeList");

        List<ViewingTime> viewingTimeList;
        ViewingTime viewingTime;
        TheatreMovies theatreMovie;

        theatreMovie = new TheatreMovies("Scotiabank Theatre","Superman");
        viewingTimeList = dataAccess.getViewingTimeList(theatreMovie);
        assertNotNull(viewingTimeList);
        assertEquals(4,viewingTimeList.size());

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("5:00 to 7:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //fourth viewing time
        viewingTime = viewingTimeList.get(3);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("9:00 to 11:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        System.out.println("Finished DataAccessTest: testGetViewingTimeList");
    }//end testGetViewingTimeList


}//end DataAccessTest
