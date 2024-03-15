package org.library.bo.Custom;

import org.library.bo.MemberService;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dao.MemberRepository;
import org.library.entity.Member;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.Member );

    private Session session;

    public static Member member;
    @Override
    public boolean Login(String Username, String Password) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(Username);

        if (data != null && data.getPassword().equals(Password)){
            member = data;
            return true;
        }
        else {
            return false;
        }
    }
}
