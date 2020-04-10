package io.choerodon.iam.infra.annotation;

import java.lang.annotation.*;

import io.choerodon.core.iam.ResourceLevel;

/**
 * User: Mr.Wang
 * Date: 2020/2/25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {
    //操作的类型
    String type() default "";

    //记录操作的内容
    String content() default "";

    //操作的层级
    ResourceLevel[] level() default ResourceLevel.SITE;
}
