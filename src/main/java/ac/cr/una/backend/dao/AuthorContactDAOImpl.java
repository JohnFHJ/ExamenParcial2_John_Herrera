/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author John
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {
        boolean aux = false;
        if (aux == false) {
            Query query = session.createQuery("truncate table booktype");
            query.executeUpdate();
            aux = false;
        }
        return aux;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();
        return authorContact;
    }

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> list = session.createCriteria(AuthorContact.class).list();
        return list;   
    }
}