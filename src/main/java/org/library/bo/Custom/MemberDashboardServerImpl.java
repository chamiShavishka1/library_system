package org.library.bo.Custom;

import org.library.bo.MemberDashboardServer;
import org.library.dao.BorrowBookRepository;
import org.library.dao.Custom.RepositoryFactory;
import org.library.dao.MemberRepository;
import org.library.dto.MemberDto;
import org.library.entity.Member;
import org.library.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDashboardServerImpl implements MemberDashboardServer {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);

    private final BorrowBookRepository borrowBook = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.BorrowBook);
    private Session session;
    private Transaction transaction;
    @Override
    public MemberDto getData(String username) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(username);
        session.close();
        return new MemberDto(data.getId(), data.getFull_name(), data.getUsername(), data.getPassword(), data.getEmail());
    }

    @Override
    public void Update(MemberDto memberDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Update(new Member(memberDto.getId(), memberDto.getFull_name(), memberDto.getUsername(), memberDto.getPassword(), memberDto.getEmail()));
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    @Override
    public int BookCount(String memberUsername) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(memberUsername);
        borrowBook.SetSession(session);
        int bookCount = borrowBook.BookCount(data);
        session.close();
        return bookCount;
    }
}
