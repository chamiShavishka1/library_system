package org.library.dao.Custom;

import org.library.dao.BorrowBookRepository;
import org.library.entity.BorrowBook;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookRepositoryImpl implements BorrowBookRepository {
    private Session session;
    @Override
    public BorrowBook getData(String Id) {
        return null;
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(BorrowBook data) {
        return (int) session.save(data);
    }

    @Override
    public ArrayList<BorrowBook> getAll() {
        return null;
    }

    @Override
    public void Update(BorrowBook Data) {

    }

    @Override
    public void Delete(int Id) {

    }

    @Override
    public long Count() {
        return 0;
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
