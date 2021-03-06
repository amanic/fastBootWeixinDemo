package com.amateur.wanbei.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WbUserLoan {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.id
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_amount
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private BigDecimal loanAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_start_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Date loanStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_end_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Date loanEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Integer loanUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private String loanName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.account
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.delete
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Integer delete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.create_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.update_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wb_user_loan.loan_type
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    private Integer loanType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.id
     *
     * @return the value of wb_user_loan.id
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.id
     *
     * @param id the value for wb_user_loan.id
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.uid
     *
     * @return the value of wb_user_loan.uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.uid
     *
     * @param uid the value for wb_user_loan.uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.name
     *
     * @return the value of wb_user_loan.name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.name
     *
     * @param name the value for wb_user_loan.name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_amount
     *
     * @return the value of wb_user_loan.loan_amount
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_amount
     *
     * @param loanAmount the value for wb_user_loan.loan_amount
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_start_time
     *
     * @return the value of wb_user_loan.loan_start_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Date getLoanStartTime() {
        return loanStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_start_time
     *
     * @param loanStartTime the value for wb_user_loan.loan_start_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanStartTime(Date loanStartTime) {
        this.loanStartTime = loanStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_end_time
     *
     * @return the value of wb_user_loan.loan_end_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Date getLoanEndTime() {
        return loanEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_end_time
     *
     * @param loanEndTime the value for wb_user_loan.loan_end_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanEndTime(Date loanEndTime) {
        this.loanEndTime = loanEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_uid
     *
     * @return the value of wb_user_loan.loan_uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Integer getLoanUid() {
        return loanUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_uid
     *
     * @param loanUid the value for wb_user_loan.loan_uid
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanUid(Integer loanUid) {
        this.loanUid = loanUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_name
     *
     * @return the value of wb_user_loan.loan_name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public String getLoanName() {
        return loanName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_name
     *
     * @param loanName the value for wb_user_loan.loan_name
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.account
     *
     * @return the value of wb_user_loan.account
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.account
     *
     * @param account the value for wb_user_loan.account
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.delete
     *
     * @return the value of wb_user_loan.delete
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Integer getDelete() {
        return delete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.delete
     *
     * @param delete the value for wb_user_loan.delete
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.create_time
     *
     * @return the value of wb_user_loan.create_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.create_time
     *
     * @param createTime the value for wb_user_loan.create_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.update_time
     *
     * @return the value of wb_user_loan.update_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.update_time
     *
     * @param updateTime the value for wb_user_loan.update_time
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wb_user_loan.loan_type
     *
     * @return the value of wb_user_loan.loan_type
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public Integer getLoanType() {
        return loanType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wb_user_loan.loan_type
     *
     * @param loanType the value for wb_user_loan.loan_type
     *
     * @mbggenerated Fri Jun 08 15:40:38 CST 2018
     */
    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "WbUserLoan{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanStartTime=" + loanStartTime +
                ", loanEndTime=" + loanEndTime +
                ", loanUid=" + loanUid +
                ", loanName='" + loanName + '\'' +
                ", account='" + account + '\'' +
                ", delete=" + delete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", loanType=" + loanType +
                '}';
    }
}