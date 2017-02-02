/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author John
 */
public interface BookService {

    /**
     *
     * @return
     */
    public boolean deleteAll();

    /**
     *
     * @param book
     * @return
     */
    public Book save(Book book);

    /**
     *
     * @return
     */
    public List<Book> findAll();

    /**
     *
     * @return
     */
    public float totalPrice();
}
