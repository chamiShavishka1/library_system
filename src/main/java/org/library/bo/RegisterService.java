package org.library.bo;

import org.library.dto.MemberDto;

public interface RegisterService extends SuperService {
    int Register(MemberDto member);
}
