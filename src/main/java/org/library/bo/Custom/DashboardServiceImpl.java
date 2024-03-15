package org.library.bo.Custom;

import org.library.bo.DashboardService;
import org.library.dao.AdminRepository;
import org.library.dao.BookRepository;
import org.library.dao.BorrowBookRepository;
import org.library.dao.BranchRepository;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dto.AdminDto;
import org.library.entity.Admin;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DashboardServiceImpl implements DashboardService {

    private final AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.admin );
    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.Books );

    private final BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.Branch );

    private final BorrowBookRepository borrowBookRepository = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.BorrowBook );
    private Session session;
    private Transaction transaction;
    @Override
    public void Update(AdminDto Data) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        Admin admin = new Admin();
        admin.setId(Data.getId());
        admin.setName(Data.getName());
        admin.setUsername(Data.getUsername());
        admin.setPassword(Data.getPassword());
        admin.setEmail(Data.getEmail());
        adminRepository.Update(admin);
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    @Override
    public void Delete(int id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        adminRepository.Delete(id);
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    @Override
    public long BookCount(){
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        long count = bookRepository.Count();
        session.close();
        return count;
    }
    @Override
    public long MemberCount(){
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        long count = adminRepository.Count();
        session.close();
        return count;
    }
    @Override
    public long BranchCount(){
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        long count = branchRepository.Count();
        session.close();
        return count;
    }

    @Override
    public long Payment(){
        session = SessionFactoryConfiguration.getInstance().getSession();
        borrowBookRepository.SetSession(session);
        long count = borrowBookRepository.Count();
        session.close();
        return count;
    }
}
