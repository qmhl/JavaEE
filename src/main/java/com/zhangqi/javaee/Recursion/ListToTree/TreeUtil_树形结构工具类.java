package com.zhangqi.javaee.Recursion.ListToTree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
 
/**
 * 树形结构工具类
 *
 * 将一组list对象转成树形结构
 * 该list需符合设定的字段类型
 *
 */
public class TreeUtil_树形结构工具类 {
 
 
    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
 
    public List<TreeNode1> menuCommon;
    public List<Object> list = new ArrayList<Object>();
 
    public List<Object> treeMenu(List<TreeNode1> menu){
        //menuCommon  menu原始的集合数据
        this.menuCommon = menu;
        for (TreeNode1 treeNode : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(treeNode.getParentId().equals("0")){
                setTreeMap(mapArr,treeNode);
                list.add(mapArr);
            }
        }
        return list;
    }
 
    public List<?> menuChild(String id){
        List<Object> lists = new ArrayList<Object>();
        for(TreeNode1 a:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(a.getParentId() .equals(id)){
               setTreeMap(childArray,a);
               lists.add(childArray);
            }
        }
        return lists;
    }
 
    private void setTreeMap(Map<String,Object> mapArr,TreeNode1 treeNode){
        mapArr.put("id", treeNode.getId());
        mapArr.put("name", treeNode.getName());
        mapArr.put("parentId", treeNode.getParentId());
        List<?> childrens = menuChild(treeNode.getId());
        if(childrens.size()>0){
            mapArr.put("hasChild",true);
        }
        else{
            mapArr.put("hasChildren",false);
        }
        mapArr.put("childrens", menuChild(treeNode.getId()));
    }
 
    public  static void main(String[] args){
 
        List<TreeNode1> treeNodeList = new ArrayList<>();
        TreeNode1 treeNode1 = new TreeNode1("1","0","首页");
        TreeNode1 treeNode2 = new TreeNode1("2","0","订单");
        TreeNode1 treeNode3 = new TreeNode1("3","1","预约");
        TreeNode1 treeNode4 = new TreeNode1("4","2","捐献");
        TreeNode1 treeNode5 = new TreeNode1("5","4","我的订单");
        TreeNode1 treeNode6 = new TreeNode1("6","5","个人中心");
        TreeNode1 treeNode7 = new TreeNode1("7","6","个人中心2");
        TreeNode1 treeNode8 = new TreeNode1("8","99","个人中心3");
        treeNodeList.add(treeNode1);
        treeNodeList.add(treeNode6);
        treeNodeList.add(treeNode5);
        treeNodeList.add(treeNode3);
        treeNodeList.add(treeNode4);
        treeNodeList.add(treeNode2);
        treeNodeList.add(treeNode7);
        treeNodeList.add(treeNode8);
 
 
        TreeUtil_树形结构工具类 treeUtil = new TreeUtil_树形结构工具类();
        System.out.print(JSON.toJSONString(treeUtil.treeMenu(treeNodeList)));
 
    }
 
 
}
