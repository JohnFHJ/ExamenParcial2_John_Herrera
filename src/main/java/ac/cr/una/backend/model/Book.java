package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author John
 */
@Entity
@Table(name = "book", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_book")})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_book", nullable = false)
    private int idBook;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type", nullable = false)
    private BookType type;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "date_release", unique = false, nullable = false)
    private Calendar dateRelease;

    @Column(name = "price", unique = false, nullable = false)
    private float price;

    /**
     *
     */
    public Book() {
    }

    /**
     *
     * @param author
     * @param type
     * @param name
     * @param dateRelease
     * @param price
     */
    public Book(Author author, BookType type, String name, Calendar dateRelease, float price) {
        this.author = author;
        this.type = type;
        this.name = name;
        this.dateRelease = dateRelease;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getIdBook() {
        return idBook;
    }

    /**
     *
     * @param idBook
     */
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    /**
     *
     * @return
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public BookType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(BookType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Calendar getDateRelease() {
        return dateRelease;
    }

    /**
     *
     * @param dateRelease
     */
    public void setDateRelease(Calendar dateRelease) {
        this.dateRelease = dateRelease;
    }

    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.dateRelease, other.dateRelease)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", author=" + author + ", type=" + type + ", name=" + name + ", dateRelease=" + dateRelease + ", price=" + price + '}';
    }

}
