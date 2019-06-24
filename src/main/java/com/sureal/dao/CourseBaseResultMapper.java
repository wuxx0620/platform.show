package com.sureal.dao;

import com.sureal.pojo.CourseBaseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/5/31 18:07
 * @PackageName com.sureal.dao
 * @ClassName CourseStaticsMapper
 * @Description
 */
@Mapper
public interface CourseBaseResultMapper {
    /**
     * 学校总数
     *
     * @return
     */
    Long findAllSchoolNum();

    /**
     * 所有课程
     *
     * @return
     */
    List<CourseBaseResult> findAllSubject();

    /**
     * 查询课程数据
     *
     * @return
     */
    List<CourseBaseResult> findSchoolAndSubject();

    /**
     * 当前用户的课程数量
     *
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<CourseBaseResult> findCourseNumByUser(@Param("username") String username,
                                               @Param("bTime") String bTime,
                                               @Param("eTime") String eTime);

    /**
     * 科目数量最大值
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<CourseBaseResult> findCourseMax(@Param("bTime") String bTime,
                                         @Param("eTime") String eTime);

    /**
     * 科目数量平均值
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<CourseBaseResult> findCourseAvg(@Param("bTime") String bTime,
                                         @Param("eTime") String eTime);

    /**
     * 根据当前用户自定义的选项进行课程查询
     *
     * @param subjects
     * @param grades
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<CourseBaseResult> findCourseNumBySubjcetAndGrade(@Param("subjects") String[] subjects,
                                                          @Param("grades") String[] grades,
                                                          @Param("username") String username,
                                                          @Param("bTime") String bTime,
                                                          @Param("eTime") String eTime);
}
