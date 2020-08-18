package com.pupu.designPattern.prototype;

import java.io.Serializable;

/**深拷贝
 * @author : lipu
 * @since : 2020-03-07 13:06
 */
public class DeepCloneTarget implements Serializable,Cloneable {

    private static final long serialVersionUID = 7504765517735527346L;

    private String cloneName;
    private String cloneClass;

    public DeepCloneTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
