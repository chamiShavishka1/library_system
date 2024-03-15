package org.library.bo.Custom;

import org.library.bo.UserMangeService;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dao.MemberRepository;
import org.library.dto.MemberDto;
import org.library.entity.Member;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserManageServiceImpl implements UserMangeService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session = SessionFactoryConfiguration.getInstance().getSession();

    private Transaction transaction;
    @Override
    public ArrayList<MemberDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);

        ArrayList<Member> all = memberRepository.getAll();

        ArrayList<MemberDto> admins = new ArrayList<>();

        for (Member admin : all) {
            admins.add(new MemberDto(admin.getId(), admin.getFull_name(), admin.getUsername(), admin.getPassword(), admin.getEmail()));
        }
        session.close();
        return admins;
    }

    @Override
    public void delete(int Id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Delete(Id);
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }


}
