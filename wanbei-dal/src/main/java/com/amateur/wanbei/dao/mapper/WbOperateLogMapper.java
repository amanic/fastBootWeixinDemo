package com.amateur.wanbei.dao.mapper;

import com.amateur.wanbei.dao.entity.WbOperateLog;
import com.amateur.wanbei.dao.entity.WbOperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WbOperateLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int countByExample(WbOperateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int deleteByExample(WbOperateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int insert(WbOperateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int insertSelective(WbOperateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    List<WbOperateLog> selectByExample(WbOperateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    WbOperateLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") WbOperateLog record, @Param("example") WbOperateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int updateByExample(@Param("record") WbOperateLog record, @Param("example") WbOperateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int updateByPrimaryKeySelective(WbOperateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_operate_log
     *
     * @mbggenerated Mon Jun 11 09:52:48 CST 2018
     */
    int updateByPrimaryKey(WbOperateLog record);
}