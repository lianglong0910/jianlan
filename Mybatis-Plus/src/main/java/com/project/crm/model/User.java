package com.project.crm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TableName(value = "ts_user")
public class User extends Model<User> implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private int id;
    @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充
    private String userName;
    private String gender;
    private int age;
    private String phone;
    @TableLogic //标注逻辑删除属性
    private String deleteStatus;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}