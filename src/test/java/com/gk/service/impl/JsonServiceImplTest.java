package com.gk.service.impl;

import com.alibaba.fastjson.JSON;
import com.gk.entity.user.User;
import com.gk.protocol.json.AddJsonDataReq;
import com.gk.protocol.json.JsonListRsp;
import com.gk.service.JsonService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JsonServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 16, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonServiceImplTest {
    private JsonService service;

    public JsonService getService() {
        return service;
    }

    @Autowired
    public void setService(JsonService service) {
        this.service = service;
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getCatInfoResponsitory()
     */
    @Test
    public void testGetCatInfoResponsitory() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setCatInfoResponsitory(CatInfoRepository catInfoResponsitory)
     */
    @Test
    public void testSetCatInfoResponsitory() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getJsonDataInfoResponsitory()
     */
    @Test
    public void testGetJsonDataInfoResponsitory() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setJsonDataInfoResponsitory(JsonDataInfoRepository jsonDataInfoResponsitory)
     */
    @Test
    public void testSetJsonDataInfoResponsitory() throws Exception {
    }

    /**
     * Method: TestJson(String jsonString)
     */
    @Test
    public void testTestJson() throws Exception {
    }

    /**
     * Method: AddJsonData(AddJsonDataReq req)
     */
    @Test
    public void testAddJsonData() throws Exception {
        Long userId = 1l;
        AddJsonDataReq dataReq = new AddJsonDataReq();
        dataReq.setTitle("test Main");
        User user = new User();
        user.setPassword("hello");
        user.setUserName("gaocong");
        dataReq.setJson(JSON.toJSONString(user));
        if (service.addJsonData(dataReq)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    /**
     * Method: getJsonDataList(ConditionReq conditionReq)
     */
    @Test
    public void testGetJsonDataList() throws Exception {
        JsonListRsp rsp = service.getJsonDataList(null, 1l);
        System.out.println(JSON.toJSONString(rsp));
    }

    /**
     * Method: removeJsonData(Long id)
     */
    @Test
    public void testRemoveJsonData() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modifyJsonData(Long id, AddJsonDataReq req)
     */
    @Test
    public void testModifyJsonData() throws Exception {
//TODO: Test goes here... 
    }


}
