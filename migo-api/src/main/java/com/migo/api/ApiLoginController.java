/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.migo.api;

import com.migo.annotation.IgnoreAuth;
import com.migo.entity.OrderEntity;
import com.migo.entity.SysConfigEntity;
import com.migo.entity.TokenEntity;
import com.migo.entity.UserMessageEntity;
import com.migo.service.OrderService;
import com.migo.service.SysConfigService;
import com.migo.service.TokenService;
import com.migo.service.UserMessageService;
import com.migo.service.UserService;
import com.migo.utils.ApiReturn;
import com.migo.utils.Query;
import com.migo.utils.R;
import com.migo.validator.Assert;
import java.util.List;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * API登录授权
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private UserMessageService userMessageService;

    @Autowired
    private OrderService orderService;

    /**
     * 登录
     */
    @IgnoreAuth
    //@PostMapping("login")
    @RequestMapping("login")
    public ApiReturn login(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        Map<String, Object> map = tokenService.createToken(userId);

        return   ApiReturn.ok(map);
    }


    /**
     * 首页来源查询
     */
    @IgnoreAuth
    //@PostMapping("source")
    @RequestMapping("source")
    public ApiReturn source(String token){
        Assert.isBlank(token, "token不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        Map<String, Object> map=new HashedMap();
        map.put("key","task_source");
        Query query = new Query(map);
        List<SysConfigEntity> configList = sysConfigService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("category",configList);
        return   ApiReturn.ok(list);
    }

    /**
     * 首页来源查询
     */
    @IgnoreAuth
    //@PostMapping("login")
    @RequestMapping("userInfo")
    public ApiReturn userInfo(String token){
        Assert.isBlank(token, "token不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }

        Map<String, Object> map=new HashedMap();
        map.put("userId",tokenEntity.getUserId());
        Query query = new Query(map);

        List<UserMessageEntity> userMessageEntitiesList= userMessageService.queryList(query);
        if(userMessageEntitiesList==null||userMessageEntitiesList.size()==0){
            ApiReturn.error();
        }
        Map<String, Object> list=new HashedMap();
        list.put("userInfo",userMessageEntitiesList.get(0));
        return   ApiReturn.ok(list);
    }

    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("taskType")
    public ApiReturn taskType(String token){
        Assert.isBlank(token, "token不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        Map<String, Object> map=new HashedMap();
        map.put("key","task_type");
        Query query = new Query(map);
        List<SysConfigEntity> configList = sysConfigService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("category",configList);
        return   ApiReturn.ok(list);
    }




    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderList")
    public ApiReturn orderList(String token,String taskType,String orderType){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(taskType, "taskType不能为空");
        Assert.isBlank(orderType, "orderType不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        Map<String, Object> map=new HashedMap();
        map.put("auditStatus","S");
        map.put("buyUser","");
        map.put("taskType",taskType);
        Query query = new Query(map);
        List<OrderEntity> orderList= orderService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("list",orderList);
        return   ApiReturn.ok(list);
    }


    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderCommit")
    public ApiReturn orderCommit(String token,String orderId){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        OrderEntity orderEntity= orderService.queryObject(Long.valueOf(orderId));

        orderEntity.setBuyUser(tokenEntity.getUserId()+"");
        orderService.update(orderEntity);
        return   ApiReturn.ok();
    }


    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderQuit")
    public ApiReturn orderQuit(String token,String orderId){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        OrderEntity orderEntity= orderService.queryObject(Long.valueOf(orderId));

        orderEntity.setBuyUser("");
        orderService.update(orderEntity);
        return   ApiReturn.ok();
    }




    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("mYorder")
    public ApiReturn mYorder(String token){
        Assert.isBlank(token, "token不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        Map<String, Object> map=new HashedMap();
        map.put("auditStatus","S");
        map.put("buyUser",tokenEntity.getUserId());
        Query query = new Query(map);
        List<OrderEntity> orderList= orderService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("list",orderList);
        return   ApiReturn.ok(list);
    }


    ///**
    // * 登录
    // */
    //@IgnoreAuth
    //@PostMapping("loginOk")
    //public R login(String mobile, String password){
    //    Assert.isBlank(mobile, "手机号不能为空");
    //    Assert.isBlank(password, "密码不能为空");
    //    Map<String, Object> map = new HashMap<>();
    //    map.put("token", "2132132132");
    //    return R.ok(map);
    //}
    //
    ///**
    // * 登录
    // */
    //@IgnoreAuth
    //@PostMapping("loginError")
    //public R loginError(String mobile, String password){
    //    Assert.isBlank(mobile, "手机号不能为空");
    //    Assert.isBlank(password, "密码不能为空");
    //
    //    return R.error();
    //}
}
