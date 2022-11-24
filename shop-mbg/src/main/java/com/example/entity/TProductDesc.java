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
@TableName(value = "t_product_desc")
public class TProductDesc implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "product_id")
    private Long productId;

    @TableField(value = "product_desc")
    private String productDesc;

    private static final long serialVersionUID = 1L;
}