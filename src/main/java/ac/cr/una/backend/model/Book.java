/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author John
 */
@Entity
@Table(name = "book", catalog = "progra3_exa2​", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_book")})
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type", nullable = false)
    private BookType type;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "dataRelease", unique = false, nullable = false)
    private Calendar dataRelease;

    @Column(name = "price", unique = false, nullable = false)
    private float price;

    public Book() {
    }

    public Book(int idBook, Author author, BookType type, String name, Calendar dataRelease, float price) {
        this.idBook = idBook;
        this.author = author;
        this.type = type;
        this.name = name;
        this.dataRelease = dataRelease;
        this.price = price;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(Calendar dataRelease) {
        this.dataRelease = dataRelease;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idBook;
        hash = 89 * hash + Objects.hashCode(this.author);
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.dataRelease);
        hash = 89 * hash + Objects.hashCode(this.price);
        return hash;
    }

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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dataRelease, other.dataRelease)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", author=" + author + ", type=" + type + ", name=" + name + ", dataRelease=" + dataRelease + ", price=" + price + '}';
    }
}
