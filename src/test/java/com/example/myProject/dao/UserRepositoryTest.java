package com.example.myProject.dao;

import com.example.myProject.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;


/**
 * Created by admin on 2018/5/10.
 */
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}