package com.amateur.wanbei.dao.mapper;

import com.amateur.wanbei.dao.entity.WbUserBinding;
import com.amateur.wanbei.dao.entity.WbUserBindingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WbUserBindingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int countByExample(WbUserBindingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int deleteByExample(WbUserBindingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int insert(WbUserBinding record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int insertSelective(WbUserBinding record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    List<WbUserBinding> selectByExample(WbUserBindingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    WbUserBinding selectByPrimaryKey(Integer id);


    WbUserBinding selectByOpenId(String openId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int updateByExampleSelective(@Param("record") WbUserBinding record, @Param("example") WbUserBindingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int updateByExample(@Param("record") WbUserBinding record, @Param("example") WbUserBindingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int updateByPrimaryKeySelective(WbUserBinding record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wb_user_binding
     *
     * @mbggenerated Mon Jun 11 09:52:26 CST 2018
     */
    int updateByPrimaryKey(WbUserBinding record);
}