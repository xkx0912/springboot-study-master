package com.springbootmybatis.empty;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xkx on 2019/3/9.
 */
@Data
@ToString
@TableName(value = "teacher")
public class TeacherEmpty implements Serializable{

    private static final long serialVersionUID = 2046259721350440670L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type= IdType.AUTO)
    private long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
