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
@TableName("tb_approval_group")
public class ApprovalGroup {

    public static final XavierLambdaQueryWrapper<ApprovalGroup> gw() {
        return new XavierLambdaQueryWrapper<>();
    }


    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分组名称
     */
    @TableField(value = "group_name")
    private String groupName;

    /**
     * 排序
     */
    @TableField(value = "sort_number")
    private Integer sortNumber;

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
