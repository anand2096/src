package LLD.LibraryMgmtSystem;





import java.time.LocalDateTime;
import java.util.List;
//nouns
/**
 * Book
 *Rack
 *BookItem
 * library card
 * Barcode
 */

//actors
/**
 * customer
 * Librarian
 * System
 *
 *
 *
 *
 */

//verb
/**
 * Add/Remove/Edit Book
 * search book
 * Issue a book
 * checkout and reserve
 * Return Book
 * book details
 * collect fines
 *send notifications
 *
 *
 */


enum  BookStatus{
   ISSUED, AVAILABLE,RESERVED,NOT_AVAILABLE;
}
enum  BookType{
  SCI_FI,ROMANTIC,FANTASY,DRAMA;
}
enum  BookFormat{
    HARDCOVER,PAPERBACK,NEWSPAPER,JOURNAL;
}
enum ReservationStatus{
    RESERVED,WAITING,NOT_AVAILABLE;
}
class Library{
    String name;
    Address address;
    List<BookItem>books;
}
class Book{

    String uuid;
    String bookName;
    List<Author> authors;
    BookType bookType;
    String title;
    List<BookItem> bookItemList;
}
class BookItem extends Book{
    int bookItemId;
    String barcode;
    String issuedUserId;
    LocalDateTime issuedDateTime;
    LocalDateTime dueDate;
    Rack  rack;
    BookStatus status;
    BookFormat bookFormat;
}
class Rack{
    int rackNumber;
    String locationId;

}
class AccountDetail{
    int accountId;
    String userName;
    String password;
}
class Address{
    int pincode;
    String street;
    String city;
    String country;

}
class Person{

    String firstName;
    String lastName;
}
class Author extends Person{
    List<Book> bookPublished;
}
class SystemUser{
    String email;
    String phoneNumber;
    AccountDetail accounDetail;
    Address address;

}

class Customer extends SystemUser{
    int totalBookCheckedOut;
    BookSearch bookSearchService;
    BookIssue bookIssueService;
    //BookReserve bookReserveService;



}

class Librarian extends  SystemUser{
    BookSearch bookSearchService;
    BookIssue bookIssueService;
   // BookReserve bookReserveService;

    public BookItem addBookItem(Book bookInfo) {
        return null;
    }

    public BookItem updateBookItem(Book bookInfo) {
        return null;
    }

    public BookItem deleteBookItem(String barcode) {
        return null;
    }
}
class BookSearch{

    public List<BookItem> getBookByTitle(String title){
        return null;
    };
    public List<BookItem> getBookByAuthor(String authorName){
        return null;
    };
    public List<BookItem> getBookByType (BookType bookType){
        return null;
    };
}
class BookIssue{
    FineService fineService;
    public BookIssueDetail issueBook(BookItem bookItem,SystemUser user,int duration){
        return null;
    };
 //   public BookRenewDetail renewBook(BookItem bookItem,SystemUser user,int duration){};
    public void returnBook(BookItem bookItem,SystemUser user){};
    public BookReservationDetail reserveBook(BookItem bookItem,SystemUser user){
        return null;
    };
    public BookReservationDetail getReservationDetail(BookItem bookItem){
        return null;
    };
    public BookReservationDetail updateReservationDetail(BookItem bookItem){
        return null;
    };


}

class BookLending{
    BookItem bookItem;
    SystemUser systemUser;
    LocalDateTime startDate;
}

class BookReservationDetail{

    ReservationStatus reservationStatus;
}
class BookIssueDetail{
    LocalDateTime dueDate;
}
class Fine{
    LocalDateTime fineDate;
    BookItem bookItem;
    SystemUser systemUser;
    Double fineValue;
}
class FineService{

    public Fine calculateFine(BookItem bookItem,SystemUser systemUser,int days){
        return null;
    };
}
public class LibraryMgmtSystem {
}


