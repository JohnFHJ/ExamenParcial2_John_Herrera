/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.model.BookType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author John
 */
public class BookTypeDAOImpl implements BookTypeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        boolean aux = false;
        List<BookType> bookTypeList = session.createCriteria(BookType.class).list();
        for (BookType x : bookTypeList) {
            session.delete(x);
            aux = true;
        }
        session.getTransaction().commit();
        return aux;
    }
    
    /**
     *
     * @param booktype
     * @return
     */
    @Override
    public BookType save(BookType booktype) {
        session.beginTransaction();
        session.save(booktype);
        session.getTransaction().commit();
        return booktype;
    }

    /**
     *
     * @param type
     * @return
     */
    @Override
    public BookType findByName(String type) {
        BookType book = null;
        Query query = session.createQuery("from BookType where type = :type ");
        query.setParameter("type", type);
        if (query.list().size() > 0) {
            book = (BookType) query.list().get(0);
        }
        return book;
    }
}
