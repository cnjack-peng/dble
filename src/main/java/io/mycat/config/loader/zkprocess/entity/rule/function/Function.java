package io.mycat.config.loader.zkprocess.entity.rule.function;

import io.mycat.config.loader.zkprocess.entity.Named;
import io.mycat.config.loader.zkprocess.entity.Propertied;
import io.mycat.config.loader.zkprocess.entity.Property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <function name="mod-long" class="io.mycat.route.function.PartitionByMod">
 * * <property name="count">3</property>
 * </function>
 * 源文件名：Function.java
 * 文件版本：1.0.0
 * 创建作者：liujun
 * 创建日期：2016年9月18日
 * 修改作者：liujun
 * 修改日期：2016年9月18日
 * 文件描述：TODO
 * 版权所有：Copyright 2016 zjhz, Inc. All Rights Reserved.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "function")
public class Function implements Propertied, Named {


    @XmlAttribute(required = true)
    protected String name;

    @XmlAttribute(required = true, name = "class")
    protected String clazz;

    protected List<Property> property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Property> getProperty() {
        if (this.property == null) {
            property = new ArrayList<>();
        }
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    @Override
    public void addProperty(Property prop) {
        this.getProperty().add(prop);
    }

    @Override
    public String toString() {
        String builder = "Function [name=" +
                name +
                ", clazz=" +
                clazz +
                ", property=" +
                property +
                "]";
        return builder;
    }


}
