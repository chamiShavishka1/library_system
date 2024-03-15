package org.library.bo.Custom;

import org.library.bo.AdminRegisterService;
import org.library.dao.AdminRepository;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dto.AdminDto;
import org.library.entity.Admin;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminRegisterServiceImpl implements AdminRegisterService {
    private final AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.admin);

    private Session session;

    private Transaction transaction;

    @Override
    public int saveAdmin(AdminDto adminDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        int saved = adminRepository.saved(new Admin(adminDto.getId(), adminDto.getName(), adminDto.getUsername(), adminDto.getPassword(), adminDto.getEmail()));

        transaction = session.beginTransaction();
        transaction.commit();
        if (saved > 0) {
            session.close();
            return saved;
        } else {
            transaction.rollback();
            session.close();
            return -1;
        }
    }
}
