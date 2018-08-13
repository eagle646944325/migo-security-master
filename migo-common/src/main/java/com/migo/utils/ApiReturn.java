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

package com.migo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public class ApiReturn extends HashMap<String, Object> {



    public static Map error(int code, String msg) {
        Map r = new HashMap();
        r.put("success",false);

        Map map=new HashMap();
        map.put("code",code);
        map.put("message",msg);
        r.put("error",map);
        return r;
    }


    public static ApiReturn ok(Map<String, Object> map) {
        ApiReturn r = new ApiReturn();
        r.put("success",true);
        r.put("data",map);
        return r;
    }


    public static ApiReturn ok() {
        ApiReturn r = new ApiReturn();
        r.put("success",true);
        Map map=new HashMap();
        map.put("code","200");
        map.put("message","成功");
        r.put("data",map);
        return r;
    }

    public static ApiReturn error() {


        ApiReturn r = new ApiReturn();
        r.put("success",false);
        Map map=new HashMap();
        map.put("code",500);
        map.put("message","未知异常，请联系管理员");
        //r.setError(map);
        r.put("error",map);
        return r;

    }

    public static ApiReturn error(String msg) {
        ApiReturn r = new ApiReturn();
        r.put("success",false);
        Map map=new HashMap();
        map.put("code",500);
        map.put("message",msg);
        r.put("error",map);
        return r;
    }

}
