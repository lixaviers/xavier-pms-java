package com.xavier.pms.model;

import com.baomidou.mybatisplus.annotation.*;
import com.xavier.pms.utils.XavierLambdaQueryWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName("tb_post")
public class Post {

    public static final XavierLambdaQueryWrapper<Post> gw() {
        return new XavierLambdaQueryWrapper<>();
    }


    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 职位名称
     */
    @TableField(value = "post_name")
    private String postName;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 角色列表
     */
    @TableField(value = "role")
    private String role;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
