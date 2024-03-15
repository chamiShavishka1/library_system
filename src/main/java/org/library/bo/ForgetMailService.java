package org.library.bo;

public interface ForgetMailService extends SuperService{
    boolean sendEmail(String email, String otp);
}
