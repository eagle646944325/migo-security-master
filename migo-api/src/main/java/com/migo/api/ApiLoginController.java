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
import com.migo.entity.BuyerAccountEntity;
import com.migo.entity.OrderEntity;
import com.migo.entity.ProductEntity;
import com.migo.entity.SysConfigEntity;
import com.migo.entity.TaskEntity;
import com.migo.entity.TaskSearchEntity;
import com.migo.entity.TokenEntity;
import com.migo.entity.UserMessageEntity;
import com.migo.oss.AliyunCloudStorageService;
import com.migo.oss.CloudStorageConfig;
import com.migo.oss.CloudStorageService;
import com.migo.oss.QcloudCloudStorageService;
import com.migo.oss.QiniuCloudStorageService;
import com.migo.service.BuyerAccountService;
import com.migo.service.OrderService;
import com.migo.service.ProductService;
import com.migo.service.SysConfigService;
import com.migo.service.TaskSearchService;
import com.migo.service.TaskService;
import com.migo.service.TokenService;
import com.migo.service.UserMessageService;
import com.migo.service.UserService;
import com.migo.utils.ApiReturn;
import com.migo.utils.ConfigConstant;
import com.migo.utils.Constant;
import com.migo.utils.Query;
import com.migo.utils.R;
import com.migo.utils.RRException;
import com.migo.validator.Assert;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

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


    @Autowired
    private TaskService taskService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TaskSearchService taskSearchService;

    @Autowired
    private BuyerAccountService buyerAccountService;

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
        List<OrderEntity> orderList2=new ArrayList<>();
        for(OrderEntity orderEntity: orderList){
            Double s=  Double.parseDouble(orderEntity.getGoodsPrice()) *   Double.parseDouble(orderEntity.getTaskNumber());
            orderEntity.setGuarantyGold(s);
            orderList2.add(orderEntity);
        }
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




    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("taskCategroyList")
    public ApiReturn taskCategroyList(String token){
        Assert.isBlank(token, "token不能为空");
        //生成token
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null){
            ApiReturn.error();
        }
        Map<String, Object> map=new HashedMap();
        map.put("key","task_categroy_lisl");
        Query query = new Query(map);
        List<SysConfigEntity> configList = sysConfigService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("category",configList);
        return   ApiReturn.ok(list);
    }



    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("taskInfo")
    public ApiReturn taskInfo(String token,String orderId){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        OrderEntity orderEntity=  orderService.queryObject(Long.valueOf(orderId));
        TaskEntity taskEntity=taskService.queryObject(Long.valueOf(orderEntity.getTaskId()));
        ProductEntity productEntity=productService.queryObject(Long.valueOf(taskEntity.getProductId()));
        Map<String, Object> map=new HashedMap();
        map.put("taskId",taskEntity.getTaskId());
        Query query = new Query(map);
        List<TaskSearchEntity>  taskSearchEntityList= taskSearchService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("order",orderEntity);
        list.put("task",taskEntity);
        list.put("product",productEntity);
        list.put("SearchList",taskSearchEntityList);
        return   ApiReturn.ok(list);

    }


    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderSubmit")
    public ApiReturn orderSubmit(String token,String orderId,String imageUrl,String buyerName,String buyerAccount ){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        Assert.isBlank(buyerAccount, "buyerAccount不能为空");
        Assert.isBlank(buyerName, "buyerName不能为空");
        OrderEntity orderEntity=  orderService.queryObject(Long.valueOf(orderId));
        orderEntity.setOrderStatus("SUB");
        orderEntity.setImageUrl(imageUrl);

        orderEntity.setBuyerNickName(buyerName);
        orderEntity.setBuyerAccount(buyerAccount);

        return   ApiReturn.ok();

    }




    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderDraft")
    public ApiReturn orderDraft(String token,String orderId,String imageUrl,String buyerName,String buyerAccount ){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        OrderEntity orderEntity=  orderService.queryObject(Long.valueOf(orderId));
        orderEntity.setOrderStatus("Draft");
        orderEntity.setImageUrl(imageUrl);
        orderEntity.setBuyerNickName(buyerName);
        orderEntity.setBuyerAccount(buyerAccount);

        return   ApiReturn.ok();

    }




    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("orderInfo")
    public ApiReturn orderInfo(String token,String orderId,String imageUrl){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(orderId, "orderId不能为空");
        OrderEntity orderEntity=  orderService.queryObject(Long.valueOf(orderId));

        Map<String, Object> list=new HashedMap();
        list.put("order",orderEntity);
        return   ApiReturn.ok(list);

    }


    @IgnoreAuth
    //@PostMapping("taskType")
    @RequestMapping("buyerAccount")
    public ApiReturn buyerAccount(String token,String taskType){
        Assert.isBlank(token, "token不能为空");
        Assert.isBlank(taskType, "taskType不能为空");

        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if(tokenEntity == null) {
            ApiReturn.error();
        }

        Map<String, Object> map=new HashedMap();
        map.put("auditStatus",tokenEntity.getUserId());
        map.put("accountType",taskType);
        Query query = new Query(map);
        List<BuyerAccountEntity> buyerAccount= buyerAccountService.queryList(query);
        Map<String, Object> list=new HashedMap();
        list.put("buyerAccount",buyerAccount);
        return   ApiReturn.ok(list);

    }


    /**
     * 上传文件
     */
    @IgnoreAuth
    @RequestMapping("upload")
    public ApiReturn upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        String filename = file.getOriginalFilename();
        String prefix=filename.substring(filename.lastIndexOf("."));
        //上传文件
        String url = build().upload(file.getBytes(),prefix);


        Map<String, Object> list=new HashedMap();
        list.put("url",url);
        return ApiReturn.ok(list);
    }

    public CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig
                config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
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
