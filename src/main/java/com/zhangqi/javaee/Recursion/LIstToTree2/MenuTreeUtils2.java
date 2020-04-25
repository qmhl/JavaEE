package com.zhangqi.javaee.Recursion.LIstToTree2;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuTreeUtils2 {


    public static List<Menu> listToTreeMenu() {

        //查询所有的分类
        List<Menu>  menuList= new ArrayList<Menu>();
        /*插入一些数据*/
        menuList.add(new Menu("GN001D000","0","系统管理","/admin","Y"));
        menuList.add(new Menu("GN001D100","GN001D000","权限管理","/admin","Y"));
        menuList.add(new Menu("GN001D110","GN001D100","密码修改","/admin","Y"));
        menuList.add(new Menu("GN001D120","GN001D100","新加用户","/admin","Y"));
        menuList.add(new Menu("GN001D200","GN001D000","系统监控","/admin","Y"));
        menuList.add(new Menu("GN001D210","GN001D200","在线用户","/admin","Y"));
        menuList.add(new Menu("GN002D000","0","订阅区","/admin","Y"));
        menuList.add(new Menu("GN003D000","0","未知领域","/admin","Y"));


        //查询顶级分类
        List<Menu> top = menuList.stream().filter(x -> StringUtils.isEmpty(x.getParentId()) || x.getParentId().equals("0")).collect(Collectors.toList());
        //parentId作为key，子级作为value组成的map
        Map<String, List<Menu>> allMap = menuList.stream().collect(Collectors.groupingBy(Menu::getParentId));
        //递归查询
        List<Menu> list = treeMenu(top, allMap);
        return list;
    }

    public static List<Menu> treeMenu(List<Menu> top, Map<String, List<Menu>> allMap) {
        //遍历
        top.forEach(menu -> {
            List<Menu> temp = allMap.get(menu.getId());
            if (temp != null && !temp.isEmpty()) {
                menu.setChildren(temp);
                treeMenu(menu.getChildren(), allMap);
            } else {
                menu.setChildren(new ArrayList<>());
            }
        });
        return top;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(listToTreeMenu()));

    }

}