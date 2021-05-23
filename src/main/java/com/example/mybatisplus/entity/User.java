package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @TableId(type =IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;


}
