package com.algoexpert.Trees;

import com.sun.source.tree.Tree;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class FindNodeDistanceK
{
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        Map<Integer,BinaryTree> rootToParent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<TreeInfo> queue = new LinkedList<>();

        createMap(rootToParent,tree, null);

        BinaryTree node = getNodetoValue(target,tree,rootToParent);

        return breadthFirstSearch(rootToParent, node, k);
    }
    
    private ArrayList<Integer> breadthFirstSearch(Map<Integer,BinaryTree> rootToParent,
                                                  BinaryTree target,
                                             int distance)
    {
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.offer(new TreeInfo(target,0));

        Set<Integer> seen = new HashSet<>();
        seen.add(target.value);


        while(queue.size() > 0)
        {
            TreeInfo node = queue.poll();
            BinaryTree currentNdoe = node.node;
            int distanceToNode = node.value;

            if(distanceToNode == distance)
            {
                ArrayList<Integer> nodeDistance = new ArrayList<>();
                for(TreeInfo treeInfo:queue)
                {
                    nodeDistance.add(treeInfo.node.value);
                }
                nodeDistance.add(currentNdoe.value);
                return nodeDistance;
            }

            List<BinaryTree> connectedNodes = new ArrayList<>();
            connectedNodes.add(target.right);
            connectedNodes.add(target.left);
            connectedNodes.add(rootToParent.get(target.value));

            for(BinaryTree tree: connectedNodes)
            {
                if(tree == null) continue;
                if(seen.contains(tree)) continue;

                seen.add(tree.value);

                queue.add(new TreeInfo(tree,distanceToNode+1));
            }
        }
        return new ArrayList<>();
    }

    private BinaryTree getNodetoValue(int target, BinaryTree tree, Map<Integer,
            BinaryTree> rootToParent) {

        if(tree.value == target)
            return tree;

        BinaryTree nodeParent = rootToParent.get(target);
        if(nodeParent.left!=null && nodeParent.left.value == target)
            return tree.left;

        return tree.right;
    }

    private void createMap(Map<Integer, BinaryTree> rootToParent, BinaryTree tree, BinaryTree parent)
    {
        if(tree !=null)
        {
            rootToParent.put(tree.value, parent);
            createMap(rootToParent, tree.left, tree );
            createMap(rootToParent, tree.right, tree);
        }
    }

    static class TreeInfo{

        BinaryTree node;
        int value;

        TreeInfo(BinaryTree node, int value)
        {
            this.node = node;
            this.value = value;
        }
    }
}
