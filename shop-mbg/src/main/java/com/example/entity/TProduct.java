package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * yzw
 * 2022/11/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_product")
public class TProduct implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private Long price;

    @TableField(value = "sale_price")
    private Long salePrice;

    @TableField(value = "images")
    private String images;

    @TableField(value = "sale_point")
    private String salePoint;

    @TableField(value = "type_id")
    private Long typeId;

    @TableField(value = "type_name")
    private String typeName;

    /**
     * 1:??Ч
            0:ʧЧ
     */
    @TableField(value = "flag")
    private Boolean flag;

    private static final long serialVersionUID = 1L;
}