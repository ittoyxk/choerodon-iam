package io.choerodon.iam.api.controller.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import io.choerodon.base.app.service.DashboardC7nService;
import io.choerodon.base.infra.dto.DashboardDTO;
import io.choerodon.base.infra.utils.ParamUtils;
import io.choerodon.core.base.BaseController;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.CustomPageRequest;
import io.choerodon.swagger.annotation.Permission;

/**
 * @author dongfan117@gmail.com
 */
@RestController
@RequestMapping(value = "/choerodon/v1/dashboards")
public class DashboardC7nController extends BaseController {
    private DashboardC7nService dashboardC7nService;

    public DashboardC7nController(DashboardC7nService dashboardC7nService) {
        this.dashboardC7nService = dashboardC7nService;
    }

    /**
     * 根据dashboardId更新Dashboard
     *
     * @param dashboardId  DashboardE Id
     * @param dashboardDto Dashboard对象
     * @return 更新成功的Dashboard对象
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "修改dashboard")
    @PostMapping(value = "/{dashboard_id}")
    public ResponseEntity<DashboardDTO> update(
            @PathVariable("dashboard_id") Long dashboardId,
            @RequestParam(value = "update_role", required = false, defaultValue = "false")
            @ApiParam("是否更新角色列表/默认false") Boolean updateRole,
            @RequestBody DashboardDTO dashboardDto) {
        return new ResponseEntity<>(dashboardC7nService.update(dashboardId, dashboardDto, updateRole), HttpStatus.OK);
    }

    /**
     * 根据DashboardId,查询Dashboard对象
     *
     * @param dashboardId DashboardE Id
     * @return 查询到的Dashboard对象
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "通过id查询Dashboard")
    @GetMapping(value = "/{dashboard_id}")
    public ResponseEntity<DashboardDTO> query(@PathVariable("dashboard_id") Long dashboardId) {
        return new ResponseEntity<>(dashboardC7nService.query(dashboardId), HttpStatus.OK);
    }

    /**
     * 分页模糊查询Dashboard
     *
     * @param name   Dashboard名称
     * @param params 模糊查询参数
     * @return 查询到的Dashboard分页对象
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "分页模糊查询Dashboard")
    @GetMapping
    @CustomPageRequest
    public ResponseEntity<Page<DashboardDTO>> list(
            @ApiIgnore
            @SortDefault(value = "id", direction = Sort.Direction.DESC) PageRequest pageRequest,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String namespace,
            @RequestParam(required = false) Boolean enable,
            @RequestParam(required = false) Boolean needRoles,
            @RequestParam(required = false) String[] params) {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setName(name);
        dashboardDTO.setCode(code);
        dashboardDTO.setEnabled(enable);
        dashboardDTO.setLevel(level);
        dashboardDTO.setNamespace(namespace);
        dashboardDTO.setNeedRoles(needRoles);
        return new ResponseEntity<>(dashboardC7nService.list(dashboardDTO, pageRequest, ParamUtils.arrToStr(params)), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation("重置仪表盘配置数据")
    @PutMapping("/reset")
    public void reset(@RequestParam(value = "dashboard_id", required = false) Long dashboardId) {
        dashboardC7nService.reset(dashboardId);
    }

}
