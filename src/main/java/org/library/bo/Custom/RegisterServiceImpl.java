package org.library.bo.Custom;

import org.library.bo.RegisterService;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dao.MemberRepository;
import org.library.dto.MemberDto;
import org.library.entity.Member;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RegisterServiceImpl implements RegisterService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session;
    private Transaction transaction;
    @Override
    public int Register(MemberDto member) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        int saved = memberRepository.saved(new Member(member.getId(),member.getFull_name(),member.getUsername(),member.getPassword(),member.getEmail()));
        transaction = session.beginTransaction();
        if (saved > 0) {
            transaction.commit();
            session.close();
        }
        else {
            transaction.rollback();
            session.close();
        }
        return saved;
    }
}
