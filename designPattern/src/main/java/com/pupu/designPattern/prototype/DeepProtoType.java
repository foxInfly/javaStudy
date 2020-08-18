package com.pupu.designPattern.prototype;

import java.io.*;

/**深拷贝
 * @author : lipu
 * @since : 2020-03-07 13:14
 */
public class DeepProtoType implements Serializable,Cloneable{
    public String name;
    public DeepCloneTarget deepCloneTarget;

    public DeepProtoType() {
    }

    //深拷贝，方法1使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //完成基本数据类型的clone
        deep = super.clone();
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneTarget = (DeepCloneTarget)deepCloneTarget.clone();

        return deep;
    }

    //深拷贝，方法2使用对象的序列化（推荐）
    public DeepProtoType deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            //序列化，输出，写出
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //当前这个对象以流的方式输出，有引用，引用对象也会输出
            oos.writeObject(this);

            //反序列化，读入
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType)ois.readObject();
            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

