package com.zhangqi.javaee.Recursion.ListToTree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestListTree {

    public static void main(String[] args) {
        // id,pid(父节点),name(节点名称),sequence(同级节点排序依据)
        MyTestTree tree1 = new MyTestTree(1, "顶层节点1", 0, 1);
        MyTestTree tree2 = new MyTestTree(2, "顶层节点2", 0, 2);
        MyTestTree tree3 = new MyTestTree(3, "顶层节点3", 0, 3);

        MyTestTree tree4 = new MyTestTree(4, "二级节点4", 1, 1);
        MyTestTree tree5 = new MyTestTree(5, "二级节点5", 2, 2);
        MyTestTree tree6 = new MyTestTree(6, "二级节点6", 3, 3);

        MyTestTree tree7 = new MyTestTree(7, "三级节点7", 4, 1);
        MyTestTree tree8 = new MyTestTree(8, "三级节点8", 4, 2);
        MyTestTree tree9 = new MyTestTree(9, "三级节点9", 5, 1);

        List<MyTestTree> list = new ArrayList<MyTestTree>();
        list.add(tree1);
        list.add(tree2);
        list.add(tree3);
        list.add(tree4);
        list.add(tree5);
        list.add(tree6);
        list.add(tree7);
        list.add(tree8);
        list.add(tree9);

        LinkedList<MyTestTree> result = new LinkedList<MyTestTree>();
        LinkedList<MyTestTree> f = toSort(list, result, 0);
        for (int i = 0; i < f.size(); i++) {
            System.out.print(f.get(i).getId() + ",");
            System.out.print(f.get(i).getName() + ",");
            System.out.print(f.get(i).getParentId() + ",");
            System.out.println(f.get(i).getNo_order());
        }
        System.out.println(JSON.toJSONString(f));
    }

    /**
     *
     * @Description: 排序
     * @param list
     * @param result
     * @param father
     * @return
     * LinkedList<MyTestTree>
     */
    private static LinkedList<MyTestTree> toSort(List<MyTestTree> list,
                                                 LinkedList<MyTestTree> result, int father) {
        List<MyTestTree> temp = new ArrayList<MyTestTree>();
        // 最高层,临时存放
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getParentId() == father) {
                temp.add(list.get(i));
            }
        }

        if (temp.size() < 1) {
            return result;
        } else {
            // 删除最高层
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getParentId() == father) {
                    list.remove(j);
                }
            }
            // 对最高层排序
            for (int i = 0; i < temp.size() - 1; i++) {
                for (int j = i + 1; j < temp.size(); j++) {
                    if (temp.get(i).getNo_order() > temp.get(j).getNo_order()) {
                        MyTestTree myTestTree = temp.get(i);
                        temp.set(i, temp.get(j));
                        temp.set(j, myTestTree);
                    }
                }
            }
            // 递归
            for (int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
                toSort(list, result, temp.get(i).getId());
            }
            return result;
        }

    }
}
