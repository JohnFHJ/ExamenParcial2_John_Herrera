/*
 * Copyright (C) 2017 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
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
@Table(name = "author", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_author")})
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_author", unique = true, nullable = false)
    private int idAuthor;
    
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     *
     */
    public Author() {
    }

    /**
     *
     * @param idAuthor
     * @param name
     */
    public Author(int idAuthor, String name) {
        this.idAuthor = idAuthor;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getIdAuthor() {
        return idAuthor;
    }

    /**
     *
     * @param idAuthor
     */
    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idAuthor;
        hash = 11 * hash + Objects.hashCode(this.name);
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
        final Author other = (Author) obj;
        if (this.idAuthor != other.idAuthor) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "idAuthor=" + idAuthor + ", name=" + name + '}';
    }

}
