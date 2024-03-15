package org.library.bo.Custom;


import org.library.bo.SearchBookService;
import org.library.dao.BookRepository;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dto.BookDto;
import org.library.entity.Books;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class SearchBookServiceImpl implements SearchBookService {

    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private Session session;
    @Override
    public BookDto getData(String title) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        Books data = bookRepository.getData(title);
        session.close();
        return new BookDto( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        List<String> list = bookRepository.getOneData();
        session.close();
        return list;
    }

}
