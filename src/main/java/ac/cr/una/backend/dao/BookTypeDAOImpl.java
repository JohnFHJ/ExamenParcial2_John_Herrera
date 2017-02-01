/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author John
 */
public class BookTypeDAOImpl implements BookTypeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {
        boolean aux = false;
        if (aux == false){
        Query query = session.createQuery("truncate table Booktype");
        query.executeUpdate();
        aux = false;
        }
        return aux;
    }
    

    @Override
    public BookType save(BookType booktype) {
        session.beginTransaction();
        session.save(booktype);
        session.getTransaction().commit();
        return booktype;
    }

    @Override
    public BookType findByName(String name) {
        BookType book = null;
        Query query = session.createQuery("from Author where name like =:name ");
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            book = (BookType) query.list().get(0);
        }
        return book;
    }
}
