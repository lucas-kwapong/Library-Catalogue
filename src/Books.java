//Creating reference data type of type class to represent our Books in the library
public class Books {
    //    Instantiating our class variables
    String title;
    boolean IsCheckedOut;
    int PageCount;
    int ISBN;
    int DayCheckedOut;

    //Defining our class constructor
    public Books(String booktitle, boolean IsCheckedOut, int bookPageCount, int bookISBN, int bookDayCheckedOut) {
        this.title = booktitle;
        this.IsCheckedOut = false;
        this.ISBN = bookISBN;
        this.DayCheckedOut = bookDayCheckedOut;
        this.PageCount = bookPageCount;
    }

//    Defining our class instant methods # Getters and Setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return IsCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut, int CurrentDay) {
        IsCheckedOut = checkedOut;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getDayCheckedOut() {
        return DayCheckedOut;
    }

    public void setDayCheckedOut(int dayCheckedOut) {
        DayCheckedOut = dayCheckedOut;
    }

    public boolean getIsCheckedOut() {
        return false;
    }
}
