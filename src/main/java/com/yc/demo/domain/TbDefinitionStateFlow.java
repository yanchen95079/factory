package com.yc.demo.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_definition_state_flow
 *
 * @mbg.generated do_not_delete_during_merge Fri Jun 04 15:47:02 CST 2021
 */
public class TbDefinitionStateFlow {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.id
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   权限code
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.acl_code
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private String aclCode;

    /**
     * Database Column Remarks:
     *   对应哪种单据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.def_type
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Integer defType;

    /**
     * Database Column Remarks:
     *   流转顺序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.position
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Integer position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.remark
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.create_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.update_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.create_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.update_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Long updateUser;

    /**
     * Database Column Remarks:
     *   1可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_definition_state_flow.enable
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    private Integer enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.id
     *
     * @return the value of tb_definition_state_flow.id
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.id
     *
     * @param id the value for tb_definition_state_flow.id
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.acl_code
     *
     * @return the value of tb_definition_state_flow.acl_code
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public String getAclCode() {
        return aclCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.acl_code
     *
     * @param aclCode the value for tb_definition_state_flow.acl_code
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setAclCode(String aclCode) {
        this.aclCode = aclCode == null ? null : aclCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.def_type
     *
     * @return the value of tb_definition_state_flow.def_type
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Integer getDefType() {
        return defType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.def_type
     *
     * @param defType the value for tb_definition_state_flow.def_type
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setDefType(Integer defType) {
        this.defType = defType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.position
     *
     * @return the value of tb_definition_state_flow.position
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.position
     *
     * @param position the value for tb_definition_state_flow.position
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.remark
     *
     * @return the value of tb_definition_state_flow.remark
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.remark
     *
     * @param remark the value for tb_definition_state_flow.remark
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.create_time
     *
     * @return the value of tb_definition_state_flow.create_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.create_time
     *
     * @param createTime the value for tb_definition_state_flow.create_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.update_time
     *
     * @return the value of tb_definition_state_flow.update_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.update_time
     *
     * @param updateTime the value for tb_definition_state_flow.update_time
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.create_user
     *
     * @return the value of tb_definition_state_flow.create_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.create_user
     *
     * @param createUser the value for tb_definition_state_flow.create_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.update_user
     *
     * @return the value of tb_definition_state_flow.update_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.update_user
     *
     * @param updateUser the value for tb_definition_state_flow.update_user
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_definition_state_flow.enable
     *
     * @return the value of tb_definition_state_flow.enable
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_definition_state_flow.enable
     *
     * @param enable the value for tb_definition_state_flow.enable
     *
     * @mbg.generated Fri Jun 04 15:47:02 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}