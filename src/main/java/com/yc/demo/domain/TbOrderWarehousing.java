package com.yc.demo.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_order_warehousing
 *
 * @mbg.generated do_not_delete_during_merge Sun Aug 01 01:23:13 CST 2021
 */
public class TbOrderWarehousing {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.id
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String groupUuid;

    /**
     * Database Column Remarks:
     *   产线名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String productionLineName;

    /**
     * Database Column Remarks:
     *   成品型号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.finished_product_model
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String finishedProductModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.remark
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.create_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.update_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.create_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.update_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Long updateUser;

    /**
     * Database Column Remarks:
     *   1可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.enable
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Integer enable;

    /**
     * Database Column Remarks:
     *   产品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String name;

    /**
     * Database Column Remarks:
     *   序号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.serial_num
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String serialNum;

    /**
     * Database Column Remarks:
     *   单位
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.unit
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String unit;

    /**
     * Database Column Remarks:
     *   数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.quantity
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_warehousing.order_no
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    private String orderNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.id
     *
     * @return the value of tb_order_warehousing.id
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.id
     *
     * @param id the value for tb_order_warehousing.id
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.group_uuid
     *
     * @return the value of tb_order_warehousing.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getGroupUuid() {
        return groupUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.group_uuid
     *
     * @param groupUuid the value for tb_order_warehousing.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid == null ? null : groupUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.production_line_name
     *
     * @return the value of tb_order_warehousing.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getProductionLineName() {
        return productionLineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.production_line_name
     *
     * @param productionLineName the value for tb_order_warehousing.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setProductionLineName(String productionLineName) {
        this.productionLineName = productionLineName == null ? null : productionLineName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.finished_product_model
     *
     * @return the value of tb_order_warehousing.finished_product_model
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getFinishedProductModel() {
        return finishedProductModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.finished_product_model
     *
     * @param finishedProductModel the value for tb_order_warehousing.finished_product_model
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setFinishedProductModel(String finishedProductModel) {
        this.finishedProductModel = finishedProductModel == null ? null : finishedProductModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.remark
     *
     * @return the value of tb_order_warehousing.remark
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.remark
     *
     * @param remark the value for tb_order_warehousing.remark
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.create_time
     *
     * @return the value of tb_order_warehousing.create_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.create_time
     *
     * @param createTime the value for tb_order_warehousing.create_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.update_time
     *
     * @return the value of tb_order_warehousing.update_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.update_time
     *
     * @param updateTime the value for tb_order_warehousing.update_time
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.create_user
     *
     * @return the value of tb_order_warehousing.create_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.create_user
     *
     * @param createUser the value for tb_order_warehousing.create_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.update_user
     *
     * @return the value of tb_order_warehousing.update_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.update_user
     *
     * @param updateUser the value for tb_order_warehousing.update_user
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.enable
     *
     * @return the value of tb_order_warehousing.enable
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.enable
     *
     * @param enable the value for tb_order_warehousing.enable
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.name
     *
     * @return the value of tb_order_warehousing.name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.name
     *
     * @param name the value for tb_order_warehousing.name
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.serial_num
     *
     * @return the value of tb_order_warehousing.serial_num
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.serial_num
     *
     * @param serialNum the value for tb_order_warehousing.serial_num
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.unit
     *
     * @return the value of tb_order_warehousing.unit
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.unit
     *
     * @param unit the value for tb_order_warehousing.unit
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.quantity
     *
     * @return the value of tb_order_warehousing.quantity
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.quantity
     *
     * @param quantity the value for tb_order_warehousing.quantity
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_warehousing.order_no
     *
     * @return the value of tb_order_warehousing.order_no
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_warehousing.order_no
     *
     * @param orderNo the value for tb_order_warehousing.order_no
     *
     * @mbg.generated Sun Aug 01 01:23:13 CST 2021
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
}