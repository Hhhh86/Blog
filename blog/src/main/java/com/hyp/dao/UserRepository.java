package com.hyp.dao;

import com.hyp.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName blog
 * @ClassName UserRepository
 * @create 2020-07-10 16:46
 * @Author by hyp
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
