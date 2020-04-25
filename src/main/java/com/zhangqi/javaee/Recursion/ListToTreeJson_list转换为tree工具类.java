package com.zhangqi.javaee.Recursion;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 把list转换为tree的json形式返回给前端
 */
public class ListToTreeJson_list转换为tree工具类
{


    /**  把list转换为tree的json形式返回给前端的方法
     * @param arr  原生的数据集合
     * @param id   id
     * @param pid  父id
     * @param child  展现形式为children
     * @return
     */
    public static JSONArray listToTree(JSONArray arr, String id, String pid, String child) {
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
        //将数组转为Object的形式，key为数组中的id
        //  arr原生的数组列表
        for (int i = 0; i < arr.size(); i++) {
            //  每一行数据
            JSONObject json = (JSONObject) arr.get(i);
            //  把每一行数据的id当做key  每一行数据当做value
            hash.put(json.getString(id), json);
        }
        //遍历结果集
        for (int j = 0; j < arr.size(); j++) {
            //单条记录
            JSONObject oldVal = (JSONObject) arr.get(j);
            //在hash中取出key为单条记录中pid的值
            String pidStr = "";
            //  如果每行数据的pid不为空 说明是oldVal子
            if (oldVal.get(pid) != null) {
                //  获取每行数据的pid
                pidStr = oldVal.get(pid).toString();
            }
            //  从新的集合中找出key是pid的对象
            //  说明是父
            JSONObject hashVP = (JSONObject) hash.get(pidStr);
            //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
            if (hashVP != null) {
                //检查是否有child属性
                //  如果有child属性
                if (hashVP.get(child) != null) {
                    JSONArray ch = (JSONArray) hashVP.get(child);
                    ch.add(oldVal);
                    hashVP.put(child, ch);
                } else {
                    //  如果没有child属性 则添加child属性

                    JSONArray ch = new JSONArray();
                    ch.add(oldVal);
                    hashVP.put(child, ch);
                }
            } else {
                r.add(oldVal);
            }
        }
        return r;
    }



    public static void main(String[] args){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("pid",0);
        map.put("name","甘肃省");
        data.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("id",2);
        map2.put("pid",1);
        map2.put("name","天水市");
        data.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("id",3);
        map3.put("pid",2);
        map3.put("name","秦州区");
        data.add(map3);
        Map<String,Object> map6 = new HashMap<>();
        map6.put("id",6);
        map6.put("pid",3);
        map6.put("name","秦州区的下一级66");
        data.add(map6);
        Map<String,Object> map7 = new HashMap<>();
        map7.put("id",7);
        map7.put("pid",3);
        map7.put("name","秦州区的下一级77");
        data.add(map7);
        Map<String,Object> map4 = new HashMap<>();
        map4.put("id",4);
        map4.put("pid",0);
        map4.put("name","北京市");
        data.add(map4);
        Map<String,Object> map5 = new HashMap<>();
        map5.put("id",5);
        map5.put("pid",4);
        map5.put("name","昌平区");
        data.add(map5);
        System.out.println(JSON.toJSONString(data));

        JSONArray result =
                listToTree(JSONArray.parseArray(JSON.toJSONString(data)),"id","pid","children");
        System.out.println(JSON.toJSONString(result));
    }
}
