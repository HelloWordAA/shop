package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * yzw
 * 2022/11/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_product_type")
public class TProductType implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "pid")
    private Long pid;

    @TableField(value = "name")
    private String name;

    /**
     * 1????Ч
            0??ʧЧ
     */
    @TableField(value = "flag")
    private Boolean flag;

    private static final long serialVersionUID = 1L;
}