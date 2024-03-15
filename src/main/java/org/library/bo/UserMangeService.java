package org.library.bo;

import org.library.dto.MemberDto;

import java.util.ArrayList;

public interface UserMangeService extends SuperService {
    ArrayList<MemberDto> getAll();

    void delete(int Id);

}
