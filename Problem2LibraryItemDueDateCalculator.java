import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected final String title;
    LibraryItem(String title) { this.title = title; }
    protected abstract int loanDays();
    public LocalDate dueDate(LocalDate borrowedDate) {
        return borrowedDate.plusDays(loanDays());
    }
}
class Book extends LibraryItem {
    Book(String title) { super(title); }
    protected int loanDays() { return 14; }
}
class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    protected int loanDays() { return 7; }
}
class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    protected int loanDays() { return 3; }
}
public class Problem2LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2)
                title = title.substring(1, title.length() - 1);
            LibraryItem item;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                case "MAGAZINE": item = new Magazine(title); break;
                default: throw new IllegalArgumentException("Unknown item type: " + type);
            }
            System.out.println(item.title + ": " + item.dueDate(currentDate));
        }
        sc.close();
    }
}
