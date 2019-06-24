package com.sureal.dao;

import com.sureal.pojo.CorrectBaseResult;
import com.sureal.pojo.FocusBaseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/17 15:41
 * @PackageName com.sureal.dao
 * @ClassName CorrectBaseResultMapper
 */
@Mapper
public interface CorrectBaseResultMapper {


    /**
     * 当前用户的答题正确率
     *
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<CorrectBaseResult> findCorrectByUser(@Param("username") String username,
                                              @Param("bTime") String bTime,
                                              @Param("eTime") String eTime);

    /**
     * 查询最大的答题正确率
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<CorrectBaseResult> findCorrectMax(@Param("bTime") String bTime,
                                           @Param("eTime") String eTime);

    /**
     * 查询平均的答题正确率
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<CorrectBaseResult> findCorrectAvg(@Param("bTime") String bTime,
                                           @Param("eTime") String eTime);

    /**
     * 根据当前用户自定义的选项进行答题正确率查询
     *
     * @param subjects
     * @param grades
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<CorrectBaseResult> findCorrectBySujectAndGrade(@Param("subjects") String[] subjects,
                                                        @Param("grades") String[] grades,
                                                        @Param("username") String username,
                                                        @Param("bTime") String bTime,
                                                        @Param("eTime") String eTime);
}
