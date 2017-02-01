/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorContactDAOImpl;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author John
 */
@Path("authors")
class AuthorWebservice {

    AuthorDAO authorDAO;
    AuthorContactDAO authorContactDAO;
    AuthorService authorService;
    @Context
    private UriInfo context;

    public AuthorWebservice() {
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthors() {
        List<AuthorContact> authorList = null;
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);

        authorList = authorService.findAll();

        return authorList;

    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAthorByName(String name) {
        Author author = new Author();
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        author = authorService.findByName(name);

        return author;
    }

    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);

        result = authorService.deleteAll();

        return result;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthor(AuthorContact authorContact) {
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);

        authorContact = authorService.save(authorContact);

        return authorContact;
    }

}
