package LLD.MovieTicketBookingSystem;

//Nouns
/**
 * City
 * Cinema
 * Audi
 * Movie
 * Show
 *
 */
//Actors

/**
 * Customer
 * Server
 *
 *
 *
 */

//Verbs

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SearchMovie
 * DisplayCinemaForMovie with Shows
 * BookingTickets
 * Showing sitting arrangement of Hall
 */


class Address {
    int pincode;
    String street;
    String city;
    String state;
    String country;
}
class Theatre{
    int id;
    String name;
    Address address;
    List<Audi> audiList;
   // List<Movie> movieList;
    public Map<Date,Movie> getMovies(List<Date> dateList){return null;};
    public Map<Date,Show> getShows(List<Date>dateList){return null;};

}



class Audi{
    String id;
    String audiName;
    List<Show> showsList;

}
class Seat{
    int seatId;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;

}
enum SeatType{
    DELUX,VIP,ECONOMY,OTHER;
}
enum SeatStatus{
    BOOKED,AVAILABLE,RESERVED,NOT_AVAILABLE;
}

class Show{
    int showId;
    Movie movie;
    Date startTime;
    Date endTime;
    Theatre theatrePlayedAt;
    List<Seat> seatList;

}
class Movie{
    int movieId;
    String movieName;
    MovieGenere movieGenere;
    String durationMins;
    List<String> langauges;
    List<String> cast;
}

enum MovieGenere{
    SCI_FI,ROMANTIC,THRILLER,CRIME;
}


class User{
    int id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    AccountDetail accountDetail;
}

class AccountDetail{
    String userName;
    String password;
}


class Customer extends  User{
    MovieService movieService;
    BookingService bookingService;
}

class Admin extends  User{
    MovieService movieService;
    BookingService bookingService;
    public void addMovie(Movie movie,Theatre theatre){}
    public Movie updateMovie(Movie movie, Theatre theatre){
        return movie;
    }
    public Audi  addAudi(Audi audi,Theatre theatre){
        return  audi;
    }
    public Audi  updateAudi(Audi audi,Theatre theatre){
        return  audi;
    }
    public Audi  addShow(Show show,Audi audi,Theatre theatre){
        return  audi;
    }
    public Audi  updateShow(Show show,Audi audi,Theatre theatre){
        return  audi;
    }

}

class MovieService{
    public List<Movie> getMovieByName(String movieName){return null;};
    public List<Movie> getMovieByCity(String city){return null;};
    public List<Movie> getMovieByTheatre(String theatre){return null;};
    public List<Movie> getMovieByGenere(MovieGenere movieGenere){return null;};
}

class BookingService{
//    public TicketBookingDetail bookMovieTicket(Customer customer,TicketBookingDetail ticketBookingDetail){
//        return  null;
//    };
//    public getAvailableSeatsInAudi
}























public class MovieTicketBookingSystem {
}
