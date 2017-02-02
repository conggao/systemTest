package com.gk.dao;

import com.gk.entity.jsonManage.CatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc on 2017/1/13.
 */
public interface CatInfoResponsitory extends JpaRepository<CatInfo,Long>{
    CatInfo findByParentIdAndCreateUserIdAndDel(Long parentId,Long createUserId,boolean isDel);
    
}
