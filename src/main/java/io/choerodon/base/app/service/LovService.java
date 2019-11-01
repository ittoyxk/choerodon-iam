package io.choerodon.base.app.service;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;

import io.choerodon.base.infra.dto.*;

public interface LovService {
    LovDTO queryLovByCode(String code);

    LovDTO createLov(LovDTO lovDTO);

    PageInfo<PermissionDTO> queryApiByLevel(Pageable pageable, String level);

    PageInfo<LovDTO> queryLovList(Pageable pageable, String code, String description, String level, String param);

    LovDTO updateLov(Long id, LovDTO lovDTO);

    void deleteLov(Long id);
}
