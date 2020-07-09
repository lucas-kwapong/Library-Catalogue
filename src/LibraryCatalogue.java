import java.util.HashMap;
import java.util.Map;

//Defining Our reference data type of type class
public class LibraryCatalogue {

    //    Instantiating our class variables
//    Note the Map is a referenced data type that takes two arguments the name and value
//    In our example The map is like book containing names of the books in our library catalogue and the info about them
    Map<String, Books> bookDatabase = new HashMap<String, Books>();
    int CurrentDay = 1;
    int lenghtOfCheckOutPeriod = 7;
    double InitialLateFee = 0.5;
    double feePerLateDay = 5;


    public LibraryCatalogue(Map<String, Books> BookDatabase) {
        this.bookDatabase = BookDatabase;
    }

    public LibraryCatalogue(Map<String, Books> bookDatabase, int currentDay, int lenghtOfCheckOutPeriod, double initialLateFee, double feePerLateDay) {
        this.bookDatabase = bookDatabase;
        CurrentDay = currentDay;
        this.lenghtOfCheckOutPeriod = lenghtOfCheckOutPeriod;
        InitialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    public static void main(String[] args) {

        // write your code here
        Map<String, Books> BookCollection = new HashMap<String, Books>();
        Books harry = new Books("Harry Portal", false, 200, 12313, 10);
        BookCollection.put("Harry Portal", harry);
        LibraryCatalogue MovieBooks = new LibraryCatalogue(BookCollection);
        MovieBooks.checkOutBook("Harry Portal");
        MovieBooks.nextDay();
        MovieBooks.nextDay(3);
        MovieBooks.checkOutBook("Harry Portal");
        MovieBooks.setCurrentDay(20);
        MovieBooks.returnBook("Harry Portal");
        MovieBooks.checkOutBook("Harry Portal");
        MovieBooks.checkOutBook("Harry Portal");
        MovieBooks.setCurrentDay(10);
        MovieBooks.returnBook("Harry Portal");
    }

    public Map<String, Books> getBookDatabase() {
        return bookDatabase;
    }

    public void setBookDatabase(Map<String, Books> bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    public int getCurrentDay() {
        return CurrentDay;
    }

    public void setCurrentDay(int currentDay) {
        CurrentDay = currentDay;
    }

    public int getLenghtOfCheckOutPeriod() {
        return lenghtOfCheckOutPeriod;
    }

    public void setLenghtOfCheckOutPeriod(int lenghtOfCheckOutPeriod) {
        this.lenghtOfCheckOutPeriod = lenghtOfCheckOutPeriod;
    }

    public double getInitialLateFee() {
        return InitialLateFee;
    }

    public void setInitialLateFee(double initialLateFee) {
        InitialLateFee = initialLateFee;
    }

    public double getFeePerLateDay() {
        return feePerLateDay;
    }

    public void setFeePerLateDay(double feePerLateDay) {
        this.feePerLateDay = feePerLateDay;
    }

    //    User defined methods
    public void nextDay() {
        CurrentDay++;
    }

    public void nextDay(int day) {
        CurrentDay = day;
    }

    public Books getBook(String title) {
        return getBookDatabase().get(title);
    }

    public void checkOutBook(String title) {
        Books Book = getBook(title);
        if (Book.getDayCheckedOut() < CurrentDay) {
            BookAlreadyCheckOut(Book);
        } else {
            Book.setCheckedOut(true, CurrentDay);
            System.out.println("You just checkOut " + Book.title + " from the library ");
            System.out.println("You have return it between " + CurrentDay + " to " + getLenghtOfCheckOutPeriod() + " days.");
        }

    }

    public void returnBook(String title) {
        Books Book = getBook(title);
        int daysLate = CurrentDay - (Book.getDayCheckedOut() - getLenghtOfCheckOutPeriod());
        if (daysLate > 0) {
            System.out.println(" Book is returned late");
            System.out.println(" You owe the library $" + (InitialLateFee + daysLate * getFeePerLateDay()) +
                    " because your book is " + daysLate + " due date");
        } else
            System.out.println(" Thank you return the book early, you can pick it up again");
        Book.setCheckedOut(false, -1);

    }

    public void BookAlreadyCheckOut(Books Book) {
        System.out.println(
                "Sorry" + Book.getTitle() + " is already checkout ." + " It should be back on day " +
                        (Book.getDayCheckedOut() + getLenghtOfCheckOutPeriod() + ". ")
        );
    }
}
