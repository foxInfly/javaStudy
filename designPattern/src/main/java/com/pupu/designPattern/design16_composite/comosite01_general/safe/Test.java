package com.pupu.designPattern.design16_composite.comosite01_general.safe;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // 来一个根节点
        Composite root = new Composite("root");

        // 来一个树枝节点
        Composite branchA = new Composite("---branchA");
        root.addChild(branchA);

        Composite branchB = new Composite("------branchB");
        // 来一个叶子节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        branchA.addChild(leafA);
        branchA.addChild(branchB);
        branchB.addChild(leafB);

        Component leafC = new Leaf("---leafC");
        root.addChild(leafC);







        String result = root.operation();
        System.out.println(result);

    }
}
