package com.gk.dao.jsonManage;

import com.gk.entity.jsonManage.JsonDataInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pc on 2017/1/13.
 */
public interface JsonDataInfoRepository extends JpaRepository<JsonDataInfo,Long>{
    List<JsonDataInfo> findByCatIdAndCreateUserIdAndDel(Long catId,Long createUserId,boolean isDel);

}
