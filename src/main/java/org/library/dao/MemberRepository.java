package org.library.dao;

import org.library.entity.Member;

public interface MemberRepository extends CrudUtil<Member>{
    Member CheckEmail(String email);
}
