/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author John
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;

    /**
     *
     */
    public AuthorServiceImpl() {
    }

    /**
     *
     * @param authorDAO
     */
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    /**
     *
     * @param authorContactDAO
     */
    public AuthorServiceImpl(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }

    /**
     *
     * @param authorDAO
     * @param authorContactDAO
     */
    public AuthorServiceImpl(AuthorDAO authorDAO, AuthorContactDAO authorContactDAO) {
        this.authorDAO = authorDAO;
        this.authorContactDAO = authorContactDAO;
    }

    /**
     *
     * @return
     */
    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    /**
     *
     * @param authorDAO
     */
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    /**
     *
     * @return
     */
    public AuthorContactDAO getAuthorContactDAO() {
        return authorContactDAO;
    }

    /**
     *
     * @param authorContactDAO
     */
    public void setAuthorContactDAO(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return authorContactDAO.deleteAll();
    }

    /**
     *
     * @param authorContact
     * @return
     */
    @Override
    public AuthorContact save(AuthorContact authorContact) {
        return authorContactDAO.save(authorContact);
    }

    /**
     *
     * @return
     */
    @Override
    public List<AuthorContact> findAll() {
        return authorContactDAO.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Author findByName(String name) {
        return authorDAO.findByName(name);
    }

}
