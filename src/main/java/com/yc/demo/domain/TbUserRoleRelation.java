package com.yc.demo.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_user_role_relation
 *
 * @mbg.generated do_not_delete_during_merge Sat May 29 19:24:21 CST 2021
 */
public class TbUserRoleRelation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.id
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.user_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private String userCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.role_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private String roleCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.remark
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.create_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.update_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.create_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.update_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Long updateUser;

    /**
     * Database Column Remarks:
     *   1??????
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role_relation.enable
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    private Integer enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.id
     *
     * @return the value of tb_user_role_relation.id
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.id
     *
     * @param id the value for tb_user_role_relation.id
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.user_code
     *
     * @return the value of tb_user_role_relation.user_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.user_code
     *
     * @param userCode the value for tb_user_role_relation.user_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.role_code
     *
     * @return the value of tb_user_role_relation.role_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.role_code
     *
     * @param roleCode the value for tb_user_role_relation.role_code
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.remark
     *
     * @return the value of tb_user_role_relation.remark
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.remark
     *
     * @param remark the value for tb_user_role_relation.remark
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.create_time
     *
     * @return the value of tb_user_role_relation.create_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.create_time
     *
     * @param createTime the value for tb_user_role_relation.create_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.update_time
     *
     * @return the value of tb_user_role_relation.update_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.update_time
     *
     * @param updateTime the value for tb_user_role_relation.update_time
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.create_user
     *
     * @return the value of tb_user_role_relation.create_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.create_user
     *
     * @param createUser the value for tb_user_role_relation.create_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.update_user
     *
     * @return the value of tb_user_role_relation.update_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.update_user
     *
     * @param updateUser the value for tb_user_role_relation.update_user
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role_relation.enable
     *
     * @return the value of tb_user_role_relation.enable
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role_relation.enable
     *
     * @param enable the value for tb_user_role_relation.enable
     *
     * @mbg.generated Sat May 29 19:24:21 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}