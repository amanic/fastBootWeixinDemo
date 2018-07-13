package com.amateur.wanbei.dao.mapper;

import com.amateur.wanbei.dao.entity.WbUserLoan;
import com.amateur.wanbei.dao.entity.WbUserLoanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WbUserLoanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int countByExample(WbUserLoanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int deleteByExample(WbUserLoanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int insert(WbUserLoan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int insertSelective(WbUserLoan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    List<WbUserLoan> selectByExample(WbUserLoanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    WbUserLoan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int updateByExampleSelective(@Param("record") WbUserLoan record, @Param("example") WbUserLoanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int updateByExample(@Param("record") WbUserLoan record, @Param("example") WbUserLoanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int updateByPrimaryKeySelective(WbUserLoan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_loan
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    int updateByPrimaryKey(WbUserLoan record);
    /**
     * 查询列表
     * @param map
     * @return
     */
	List<WbUserLoan> getUserLoanList(Map<String, Object> map);
	 /**
     * 查询列表的统计
     * @param map
     * @return
     */
	int countUserLoanList(Map<String, Object> map);

	List<Map> jobSql();
}