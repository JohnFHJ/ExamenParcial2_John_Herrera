/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author John
 */
public interface AuthorContactDAO {

    /**
     *
     * @return
     */
    public boolean deleteAll ();

    /**
     *
     * @param authorContact
     * @return
     */
    public AuthorContact save(AuthorContact authorContact);

    /**
     *
     * @return
     */
    public List<AuthorContact> findAll();
}
