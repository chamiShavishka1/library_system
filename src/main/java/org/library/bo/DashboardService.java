package org.library.bo;

import org.library.dto.AdminDto;

public interface DashboardService extends SuperService {
    void Update(AdminDto Data) throws Exception;

    void Delete(int id);

    long BookCount();

    long MemberCount();

    long BranchCount();
}
