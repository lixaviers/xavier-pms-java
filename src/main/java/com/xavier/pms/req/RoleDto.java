package com.xavier.pms.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "角色入参")
public class RoleDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "角色名称不能为空")
    @Size(max = 50, message = "角色名称不能超过50位")
    private String roleName;

    @Schema(description = "备注")
    @Size(max = 255, message = "备注不能超过255位")
    private String remarks;

    @Schema(description = "菜单id列表")
    private List<Long> menuIdList;


}
