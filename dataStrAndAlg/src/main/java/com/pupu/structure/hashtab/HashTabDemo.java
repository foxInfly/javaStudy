package com.pupu.structure.hashtab;

import lombok.Data;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**hash表
 * @author : lipu
 * @since : 2020-02-23 16:10
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出雇员");
            System.out.print("请输入您的操作：");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.print("输入id:");
                    int id = scanner.nextInt();
                    System.out.print("输入名字:");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "find":
                    System.out.print("输入id:");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }
}

//创建HashTab管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    //构造器
    public HashTab(int size) {
        this.size=size;
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表，hash表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id，查找雇员
    public void findEmpById(int id){
        int empListedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empListedListNo].findEmpById(id);
        if (emp != null) {
            System.out.println("在第"+(empListedListNo+1)+"条链表中找到该雇员");
        }else {
            System.out.println("在hash表中没有找到该雇员,id："+id);
        }
    }

    //编写散列函数
    public int hashFun(int id){
        return id % size;
    }
}


//雇员类
@Data
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

//链表类
class EmpLinkedList{
    //头指针
    private Emp head;

    //添加雇员列表
    public void add(Emp emp){
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;//定位到最后的辅助指针
        while (true){
            if (curEmp.next == null) {//链表最后
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no){
        if (head == null) {//链表为空
            System.out.println("第"+(no+1)+"个链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"个链表的信息为：");
        Emp curEmp = head;//辅助指针
        while (true){
            System.out.print("=>id="+curEmp.id+" name="+curEmp.name);
            if (curEmp.next == null) {//说明curEmp已经是最后节点
                break;
            }
            curEmp = curEmp.next;//后移,遍历
        }
        System.out.println();
    }

    //根据id查找雇员,没有返回空
    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null) {return null;}
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }

}
