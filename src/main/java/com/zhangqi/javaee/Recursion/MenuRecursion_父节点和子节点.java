package com.zhangqi.javaee.Recursion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuRecursion_父节点和子节点 {
    //子节点
    static  List<Menu> childMenu=new ArrayList<Menu>();

    /**
     * 获取某个父节点下面的所有子节点
     * @param
     * @param
     * @return
     */

    public static List<Menu> treeMenuList( List<Menu> menuList, int pid){
        for(Menu mu: menuList){
            //遍历出父id等于参数的id，add进子节点集合
            if(Integer.valueOf(mu.getPid())==pid){
                childMenu.add(mu);

                //递归遍历下一级
                treeMenuList(menuList,Integer.valueOf(mu.getId()));
            }
        }
        return childMenu;
    }


    /**
     *查询我这条数的所有父节点集合  包含自己
    */
    private static Set<Menu> parentMenu=new HashSet<>();

    /**
     * @param menuList  总数据--集合
     * @param pid   我这条数数据的-父级id,注意是我的父级id 不是我自己的主键id
     * @return
     */

    public static Set<Menu> treeMenuList1( List<Menu> menuList, String pid){
        for(Menu mu: menuList){
            //mu.getId()是我自己的id
            if(mu.getId().equals(pid)){
                parentMenu.add(mu);
                //mu.getParentId()是我父级的id
                treeMenuList1(menuList,mu.getPid());
            }
        }
        return parentMenu;
    }



    public static void main(String args[]) {
        List<Menu> menuList=new ArrayList<Menu>();
        Menu mu=new Menu();
        mu.setId("1");
        mu.setName("目录");
        mu.setPid("0");
        Menu mu1=new Menu();
        mu1.setId("2");
        mu1.setName("目录1");
        mu1.setPid("1");
        Menu mu2=new Menu();
        mu2.setId("3");
        mu2.setName("目录1.1");
        mu2.setPid("2");
        Menu mu3=new Menu();
        mu3.setId("4");
        mu3.setName("目录1.2");
        mu3.setPid("2");
        Menu mu4=new Menu();
        mu4.setId("5");
        mu4.setName("目录2");
        mu4.setPid("1");
        Menu mu5=new Menu();
        mu5.setId("6");
        mu5.setName("目录2.1");
        mu5.setPid("5");
        Menu mu6=new Menu();
        mu6.setId("7");
        mu6.setName("目录2.2");
        mu6.setPid("5");
        Menu mu7=new Menu();
        mu7.setId("8");
        mu7.setName("目录2.2.1");
        mu7.setPid("7");
        menuList.add(mu);
        menuList.add(mu1);
        menuList.add(mu2);
        menuList.add(mu3);
        menuList.add(mu4);
        menuList.add(mu5);
        menuList.add(mu6);
        menuList.add(mu7);

        List<Menu> childList=treeMenuList(menuList,0);


        for(Menu m:childList){
            System.out.println("父id是："+m.getPid()+"====="+m.getId() + "====" + m.getName());
        }

        JSONArray result = ListToTreeJson_list转换为tree工具类.listToTree(JSONArray.parseArray(JSON.toJSONString(childList)),"id","pid","children");
        System.out.println(JSON.toJSONString(result));

        System.out.println("============");

        Set<Menu> parentList=treeMenuList1(menuList,"4");
//        for(Menu m:parentList){
//////            System.out.println("父id是："+m.getPid()+"====="+m.getId() + "====" + m.getName());
//////        }
        JSONArray result1 = ListToTreeJson_list转换为tree工具类.listToTree(JSONArray.parseArray(JSON.toJSONString(parentList)),"id","pid","children");
        System.out.println(JSON.toJSONString(result1));
        System.out.println("============");

    }
    }
