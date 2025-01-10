package com.xavier.pms.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "员工组入参")
public class UserGroupDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "用户id", hidden = true)
    private Long userId;

    @Schema(description = "组名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "组名称不能为空")
    @Size(max = 50, message = "组名称不能超过50位")
    private String groupName;

    @Schema(description = "员工列表")
    @NotNull(message = "员工列表不能为空")
    @Size(max = 200, message = "员工列表不能超过200位")
    @Valid
    private List<UserGroupEmployeeDto> employeeList;

    @Schema(description = "备注")
    @Size(max = 255, message = "备注不能超过255位")
    private String remarks;


}