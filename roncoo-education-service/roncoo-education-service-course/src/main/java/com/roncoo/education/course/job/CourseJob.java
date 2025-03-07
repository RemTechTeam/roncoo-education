package com.roncoo.education.course.job;

import com.roncoo.education.course.service.admin.biz.AdminCourseBiz;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * 同步课程数据到es
 *
 * @author fengyw
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseJob {

    @NotNull
    private final AdminCourseBiz adminCourseBiz;

    /**
     * 建议：每天凌晨5点执行一次
     */
    @XxlJob("courseJobHandler")
    public void course() {
        adminCourseBiz.syncEs();
        XxlJobHelper.handleSuccess("完成");
    }

}
