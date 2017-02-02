package ac.cr.una.backend.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author John
 */
@Entity
@Table(name = "book_type", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_type")})
public class BookType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_type", unique = true, nullable = false)
    private int idType;

    @Column(name = "type", unique = true, nullable = false)
    private String type;

    /**
     *
     */
    public BookType() {
    }

    /**
     *
     * @param type
     */
    public BookType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getIdType() {
        return idType;
    }

    /**
     *
     * @param idType
     */
    public void setIdType(int idType) {
        this.idType = idType;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
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
        final BookType other = (BookType) obj;
        if (this.idType != other.idType) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
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
        return "BookType{" + "idType=" + idType + ", type=" + type + '}';
    }

}
