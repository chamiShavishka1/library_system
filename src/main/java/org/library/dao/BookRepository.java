package org.library.dao;

import org.library.entity.Books;

public interface BookRepository extends CrudUtil<Books>{
    Books getData(String title);
}
