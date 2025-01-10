package com.xavier.pms.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "审批流程json出参")
public class ApprovalProcessItemJsonVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "类型 parent:直属上级 dept:部门负责人 userGroup:员工组 employee:指定员工 submitter:提交人")
    private String type;

    @Schema(description = "类型描述")
    private String typeDesc;

    @Schema(description = "id列表")
    private List<Long> idList;

    @Schema(description = "员工列表")
    private List<EmployeeJsonVo> employeeList;


}
