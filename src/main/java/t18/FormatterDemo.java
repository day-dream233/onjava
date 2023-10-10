package t18;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * 格式说明符
 * %[argument_index$][flags][width][.precision]conversion
 * 对齐：中文字符的宽度影响到排版
 *
 */
public class FormatterDemo {
    static class WantedBooks{
        private double total;
        private static Formatter formatter = new Formatter(System.out);

        private static class Book {
            double price;
            String name;

            public Book(double price, String name) {
                this.price = price;
                this.name = name;
            }
        }

        List<Book> books = new ArrayList<>();

        void addBook(String bookName, double price) {
            books.add(new Book(price, bookName));
        }

        private void countTotal() {
            books.forEach(book -> total+=book.price);
        }

        public void formattedInfo() {
            countTotal();
            String format = "%-15s %6s %n";
            formatter.format(format, "book", "price");
            formatter.format(format, "----", "-----");
            books.forEach(book -> formatter.format("%-15s %6.2f %n", book.name, book.price));
            formatter.format(format, "---", "---");
            formatter.format(format, "total", total);
        }
    }
    public static void main(String[] args) {
        WantedBooks wantedBooks = new WantedBooks();
        wantedBooks.addBook("onjava", 99.9);
        wantedBooks.addBook("fjdskla", 49.9);
        wantedBooks.formattedInfo();

        PrintStream printStream = System.out;
        Formatter formatter = new Formatter(printStream);
    }
}
