package org.library.dao;

import org.library.entity.Admin;

public interface AdminRepository extends CrudUtil<Admin>{
    Admin getData();

    Admin CheckEmail(String email);
}
