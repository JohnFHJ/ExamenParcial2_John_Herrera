/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author John
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        boolean aux = false;
        List<AuthorContact> authorContactList = findAll();
        for (AuthorContact x : authorContactList) {
            session.delete(x);
            aux = true;
        }
        session.getTransaction().commit();
        return aux;
    }

    /**
     *
     * @param authorContact
     * @return
     */
    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();
        return authorContact;
    }

    /**
     *
     * @return
     */
    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> authorContactList = new ArrayList<>();
        session.beginTransaction();
        authorContactList = session.createCriteria(AuthorContact.class).list();

        return authorContactList;
    }
}
