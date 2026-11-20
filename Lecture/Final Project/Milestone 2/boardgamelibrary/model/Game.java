package boardgamelibrary.model;

import java.util.Locale;

/**
 * Represents one board game in the library.
 * Each game has a repository-assigned id and four user-editable fields.
 *
 * @author Aryan Kondapalli
 * @author Lakulish Saini
 */
public class Game {
    private int id;
    private String title;
    private String publisher;
    private double price;
    private boolean isExpansion;

    /** Creates a new game that has not yet been assigned a database id. */
    public Game(String title, String publisher, double price, boolean isExpansion) {
        this(0, title, publisher, price, isExpansion);
    }

    /** Creates a game with an existing id, such as one loaded from storage. */
    public Game(int id, String title, String publisher, double price, boolean isExpansion) {
        this.id = checkedId(id);
        this.title = checkedText(title, "Game title");
        this.publisher = checkedText(publisher, "Publisher");
        this.price = checkedPrice(price);
        this.isExpansion = isExpansion;
    }

    /** Copy constructor so the repository does not expose its stored objects. */
    public Game(Game other) {
        this(other.getId(), other.getTitle(), other.getPublisher(),
                other.getPrice(), other.isExpansion());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = checkedId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = checkedText(title, "Game title");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = checkedText(publisher, "Publisher");
    }

    public double getPrice() {
        return price;
    }

    /** Rejects negative and non-finite prices at the model layer. */
    public void setPrice(double price) {
        this.price = checkedPrice(price);
    }

    public boolean isExpansion() {
        return isExpansion;
    }

    public void setExpansion(boolean expansion) {
        this.isExpansion = expansion;
    }

    private static int checkedId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative.");
        }
        return id;
    }

    private static String checkedText(String text, String fieldName) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return text.trim();
    }

    private static double checkedPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Price must be a nonnegative, finite number.");
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "ID: %d | Title: %s | Publisher: %s | Price: $%.2f | Expansion: %s",
                id, title, publisher, price, isExpansion ? "Yes" : "No");
    }
}
