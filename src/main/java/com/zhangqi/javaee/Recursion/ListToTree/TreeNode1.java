package com.zhangqi.javaee.Recursion.ListToTree;

import lombok.Data;


@Data
public class TreeNode1 {
    /**
     * 节点id
     */
    private String id;
    /**
     * 父节点 默认0为根节点
     */
    private String parentId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 是否有子节点
     */
    private boolean hasChild;

    public TreeNode1(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}
