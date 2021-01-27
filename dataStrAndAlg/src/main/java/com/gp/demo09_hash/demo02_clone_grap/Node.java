package com.gp.demo09_hash.demo02_clone_grap;

import java.util.ArrayList;
import java.util.List;

/**
 *  grap
 * @author lp
 * @since 2021/1/27 11:22
 **/
public class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}