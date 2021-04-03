package com.yc.demo.domain;

import com.yc.demo.domain.ex.BasePoJo;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_check_info
 *
 * @mbg.generated do_not_delete_during_merge Thu Feb 25 15:37:16 CST 2021
 */
public class TbCheckInfo  extends BasePoJo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.id
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   订单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.order_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private String orderNo;

    /**
     * Database Column Remarks:
     *   成品号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.product_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private String productNo;

    /**
     * Database Column Remarks:
     *   序号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.serial_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private String serialNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.remark
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.create_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.update_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.create_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.update_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Long updateUser;

    /**
     * Database Column Remarks:
     *   1可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.enable
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Integer enable;

    /**
     * Database Column Remarks:
     *   对应config表的type=qualityInspectionModel的Key
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.config_key
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private String configKey;

    /**
     * Database Column Remarks:
     *   0未完成 1完成
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_check_info.state
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.id
     *
     * @return the value of tb_check_info.id
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.id
     *
     * @param id the value for tb_check_info.id
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.order_no
     *
     * @return the value of tb_check_info.order_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.order_no
     *
     * @param orderNo the value for tb_check_info.order_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.product_no
     *
     * @return the value of tb_check_info.product_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.product_no
     *
     * @param productNo the value for tb_check_info.product_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.serial_no
     *
     * @return the value of tb_check_info.serial_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.serial_no
     *
     * @param serialNo the value for tb_check_info.serial_no
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.remark
     *
     * @return the value of tb_check_info.remark
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.remark
     *
     * @param remark the value for tb_check_info.remark
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.create_time
     *
     * @return the value of tb_check_info.create_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.create_time
     *
     * @param createTime the value for tb_check_info.create_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.update_time
     *
     * @return the value of tb_check_info.update_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.update_time
     *
     * @param updateTime the value for tb_check_info.update_time
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.create_user
     *
     * @return the value of tb_check_info.create_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.create_user
     *
     * @param createUser the value for tb_check_info.create_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.update_user
     *
     * @return the value of tb_check_info.update_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.update_user
     *
     * @param updateUser the value for tb_check_info.update_user
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.enable
     *
     * @return the value of tb_check_info.enable
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.enable
     *
     * @param enable the value for tb_check_info.enable
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.config_key
     *
     * @return the value of tb_check_info.config_key
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.config_key
     *
     * @param configKey the value for tb_check_info.config_key
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_check_info.state
     *
     * @return the value of tb_check_info.state
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_check_info.state
     *
     * @param state the value for tb_check_info.state
     *
     * @mbg.generated Thu Feb 25 15:37:16 CST 2021
     */
    public void setState(Integer state) {
        this.state = state;
    }
}