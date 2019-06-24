package com.sureal.service;

import com.sureal.pojo.User;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

/**
 * @author Wuxx
 * @date 2019/4/19 16:24
 * @PackageName com.sureal.service
 * @ClassName PwdService
 * @Description
 */
@Service
public class PwdService implements PasswordService {

    private static String algorithmName ="md5";
    private static int hashIterations =2;
    @Override
    public String encryptPassword(Object plaintextPassword) throws IllegalArgumentException {
        User user = (User)plaintextPassword;
        return  new SimpleHash( algorithmName, user.getPassword(), user.getUsername() , hashIterations).toHex();
    }

    @Override
    public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {

        return false;
    }
}
