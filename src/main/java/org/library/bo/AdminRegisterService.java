package org.library.bo;

import org.library.dto.AdminDto;

public interface AdminRegisterService extends SuperService{
    int saveAdmin(AdminDto adminDto);
}
