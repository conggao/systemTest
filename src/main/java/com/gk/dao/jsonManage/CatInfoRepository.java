package com.gk.dao.jsonManage;

import com.gk.entity.json.CatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pc on 2017/1/13.
 */
public interface CatInfoRepository extends JpaRepository<CatInfo,Long>{
    List<CatInfo> findByParentIdAndCreateUserIdAndNameAndDel(Long parentId, Long createUserId,String name, boolean isDel);
    
}
