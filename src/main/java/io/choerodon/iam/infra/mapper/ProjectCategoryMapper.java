package io.choerodon.iam.infra.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.choerodon.iam.infra.dto.ProjectCategoryDTO;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * @author jiameng.cao
 * @date 2019/6/4
 */
public interface ProjectCategoryMapper extends BaseMapper<ProjectCategoryDTO> {


    List<ProjectCategoryDTO> selectProjectCategoriesByOrgId(@Param("organizationId") Long organizationId, @Param("param") String param, @Param("projectCategoryDTO") ProjectCategoryDTO projectCategoryDTO);

    List<ProjectCategoryDTO> selectProjectCategoriesListByOrgId(@Param("organizationId") Long organizationId,
                                                                @Param("param") String param);

    List<ProjectCategoryDTO> selectByParam(@Param("param") String param, @Param("projectCategoryDTO") ProjectCategoryDTO projectCategoryDTO);

    Long getIdByCode(@Param("agile") String agile);

}
