package io.choerodon.iam.infra.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.choerodon.base.infra.dto.UserDashboardDTO;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * @author dongfan117@gmail.com
 */
public interface UserDashboardMapper extends BaseMapper<UserDashboardDTO> {

    List<UserDashboardDTO> selectWithDashboard(@Param("userDashboard") UserDashboardDTO userDashboard);

    int deleteWithDashboard(@Param("userDashboard") UserDashboardDTO userDashboard);

    List<UserDashboardDTO> selectWithDashboardNotExist(@Param("userDashboard") UserDashboardDTO userDashboard);
}
