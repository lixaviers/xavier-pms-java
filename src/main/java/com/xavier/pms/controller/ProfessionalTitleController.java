package com.xavier.pms.controller;

import com.xavier.pms.req.ProfessionalTitleDto;
import com.xavier.pms.req.ProfessionalTitleQueryDto;
import com.xavier.pms.resp.ProfessionalTitleVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IProfessionalTitleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-职称管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@RequestMapping("professionalTitle")
@RestController
@Tag(name = "职称管理接口")
@RequiredArgsConstructor
public class ProfessionalTitleController extends CommonController {

    private final IProfessionalTitleService professionalTitleService;

    @Operation(summary = "新增职称", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody ProfessionalTitleDto professionalTitleDto) {
        professionalTitleService.createProfessionalTitle(professionalTitleDto);
        return Result.ok();
    }

    @Operation(summary = "编辑职称", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody ProfessionalTitleDto professionalTitleDto) {
        professionalTitleService.updateProfessionalTitle(professionalTitleDto);
        return Result.ok();
    }

    @Operation(summary = "删除职称", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result<Integer> delete(@RequestBody List<Long> idList) {
        professionalTitleService.deleteProfessionalTitle(idList);
        return Result.ok();
    }

    @Operation(summary = "获取职称信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<ProfessionalTitleVo> get(@PathVariable Long id) {
        return Result.ok(professionalTitleService.getProfessionalTitle(id));
    }

    @Operation(summary = "分页获取职称列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<ProfessionalTitleVo>> queryProfessionalTitle(@Validated @RequestBody ProfessionalTitleQueryDto professionalTitleQueryDto) {
        return Result.ok(professionalTitleService.queryProfessionalTitle(professionalTitleQueryDto));
    }

}
