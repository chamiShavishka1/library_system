package org.library.bo.Custom;

import org.library.bo.AdminService;
import org.library.dao.AdminRepository;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dto.AdminDto;
import org.library.entity.Admin;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;

public class AdminServiceImpl implements AdminService {

    private Session session;
    AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.admin );

    public static AdminDto data;

    public static Admin admin;
    @Override
    public boolean getData(String Id, String Password) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        Admin data = adminRepository.getData(Id);

        if (data != null && Password.equals(data.getPassword())){
            this.data = new AdminDto(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
            admin = data;
            return true;
        }
        else {
            return false;
        }
    }
}
