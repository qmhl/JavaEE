package com.zhangqi.javaee.Recursion.LIstToTree2;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeUtils {
    private List<Menu> menuList = new ArrayList<Menu>();
    // 带参构造初始化
    public MenuTreeUtils(List<Menu> menuList) {
        //menuList  是最原始的数据库数据
        this.menuList=menuList;
    }

    //获取根节点【第一级节点】
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists =new  ArrayList<Menu>();
        //  menuList原始数据进行遍历
        for(Menu menuNode : menuList) {
            //  获取第一级节点
            if(menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

    //建立树形结构
    public List<Menu> builTree(){
        List<Menu> treeMenus =new  ArrayList<Menu>();
        //  对第一级节点进行遍历
        for(Menu menuNode : getRootNode()) {
            //  一级节点建立子树
            menuNode=buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        // 返回一级子树的集合
        return treeMenus;
    }

    //递归，建立子树形结构
    private Menu buildChilTree(Menu pNode){
        List<Menu> chilMenus =new  ArrayList<Menu>();
        //  pNode 一级节点 menuList原始数据集合
        for(Menu menuNode : menuList) {
            //  如果原始数据中有pid等于一级节点的id
            if(menuNode.getParentId().equals(pNode.getId())) {
                //  添加到一级节点children的集合中
                chilMenus.add(menuNode);
                buildChilTree(menuNode);
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }


}