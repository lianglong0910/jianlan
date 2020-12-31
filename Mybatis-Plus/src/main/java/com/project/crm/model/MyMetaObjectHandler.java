package com.project.crm.model;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author: Muma
 * @date: Created in 2020/6/20 17:31
 */
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("userName",metaObject); //获取需要填充的字段
        if(fieldValue == null){   //如果该字段没有设置值
            setFieldValByName("userName","马云",metaObject); //那就将其设置为"马云"
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("userName",metaObject);//获取需要填充的字段
        if(fieldValue == null){ //如果该字段没有设置值
            setFieldValByName("userName","马化腾",metaObject);  //那就将其设置为"马化腾"
        }
    }
}
