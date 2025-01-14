package com.xavier.pms.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "审批分组入参")
public class ApprovalGroupDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    /**
     * 分组名称
     */
    @Schema(description = "分组名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分组名称不能为空")
    @NotEmpty(message = "分组名称不能为空")
    @Size(max = 50, message = "分组名称不能超过50位")
    private String groupName;

    /**
     * 排序
     */
    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "排序不能为空")
    private Integer sortNumber;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Size(max = 255, message = "备注不能超过255位")
    private String remarks;


}
