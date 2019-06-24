package com.sureal.dao;

import com.sureal.pojo.FocusBaseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/14 16:55
 * @PackageName com.sureal.dao
 * @ClassName FocusBaseResultMapper
 */
@Mapper
public interface FocusBaseResultMapper {

    /**
     * 当前用户的焦点信息
     *
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<FocusBaseResult> findFocusByUser(@Param("username") String username,
                                          @Param("bTime") String bTime,
                                          @Param("eTime") String eTime);

    /**
     * 查询最大的焦点信息
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<FocusBaseResult> findFocusMax(@Param("bTime") String bTime,
                                       @Param("eTime") String eTime);

    /**
     * 查询平均的焦点信息
     *
     * @param bTime
     * @param eTime
     * @return
     */
    List<FocusBaseResult> findFocusAvg(@Param("bTime") String bTime,
                                       @Param("eTime") String eTime);

    /**
     * 根据当前用户自定义的选项进行焦点信息查询
     *
     * @param subjects
     * @param grades
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    List<FocusBaseResult> findFocusBySujectAndGrade(@Param("subjects") String[] subjects,
                                                    @Param("grades") String[] grades,
                                                    @Param("username") String username,
                                                    @Param("bTime") String bTime,
                                                    @Param("eTime") String eTime);
}
