package com.gk.dao;

import com.gk.entity.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc on 2017/1/13.
 */
public interface UserInfoResponsitory extends JpaRepository<UserInfo,Long>{

}
