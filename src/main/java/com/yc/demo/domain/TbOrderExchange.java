package com.yc.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_order_exchange
 *
 * @mbg.generated do_not_delete_during_merge Sun Aug 01 01:11:07 CST 2021
 */
public class TbOrderExchange {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.id
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String groupUuid;

    /**
     * Database Column Remarks:
     *   处理意见
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.handling_opinions
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String handlingOpinions;

    /**
     * Database Column Remarks:
     *   产线名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String productionLineName;

    /**
     * Database Column Remarks:
     *   工单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.order_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String orderNo;

    /**
     * Database Column Remarks:
     *   料号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.item_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String itemNo;

    /**
     * Database Column Remarks:
     *   数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.quantity
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Integer quantity;

    /**
     * Database Column Remarks:
     *   产品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String name;

    /**
     * Database Column Remarks:
     *   原因
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.reason
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String reason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.standard_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private BigDecimal standardCost;

    /**
     * Database Column Remarks:
     *   总成本
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.total_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private BigDecimal totalCost;

    /**
     * Database Column Remarks:
     *   说明
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.explain_remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String explainRemark;

    /**
     * Database Column Remarks:
     *   仓库
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.warehouse
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String warehouse;

    /**
     * Database Column Remarks:
     *   库位
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.location
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.create_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.update_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.create_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.update_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Long updateUser;

    /**
     * Database Column Remarks:
     *   1可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_exchange.enable
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    private Integer enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.id
     *
     * @return the value of tb_order_exchange.id
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.id
     *
     * @param id the value for tb_order_exchange.id
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.group_uuid
     *
     * @return the value of tb_order_exchange.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getGroupUuid() {
        return groupUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.group_uuid
     *
     * @param groupUuid the value for tb_order_exchange.group_uuid
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid == null ? null : groupUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.handling_opinions
     *
     * @return the value of tb_order_exchange.handling_opinions
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getHandlingOpinions() {
        return handlingOpinions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.handling_opinions
     *
     * @param handlingOpinions the value for tb_order_exchange.handling_opinions
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setHandlingOpinions(String handlingOpinions) {
        this.handlingOpinions = handlingOpinions == null ? null : handlingOpinions.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.production_line_name
     *
     * @return the value of tb_order_exchange.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getProductionLineName() {
        return productionLineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.production_line_name
     *
     * @param productionLineName the value for tb_order_exchange.production_line_name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setProductionLineName(String productionLineName) {
        this.productionLineName = productionLineName == null ? null : productionLineName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.order_no
     *
     * @return the value of tb_order_exchange.order_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.order_no
     *
     * @param orderNo the value for tb_order_exchange.order_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.item_no
     *
     * @return the value of tb_order_exchange.item_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.item_no
     *
     * @param itemNo the value for tb_order_exchange.item_no
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.quantity
     *
     * @return the value of tb_order_exchange.quantity
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.quantity
     *
     * @param quantity the value for tb_order_exchange.quantity
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.name
     *
     * @return the value of tb_order_exchange.name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.name
     *
     * @param name the value for tb_order_exchange.name
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.reason
     *
     * @return the value of tb_order_exchange.reason
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.reason
     *
     * @param reason the value for tb_order_exchange.reason
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.standard_cost
     *
     * @return the value of tb_order_exchange.standard_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public BigDecimal getStandardCost() {
        return standardCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.standard_cost
     *
     * @param standardCost the value for tb_order_exchange.standard_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.total_cost
     *
     * @return the value of tb_order_exchange.total_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.total_cost
     *
     * @param totalCost the value for tb_order_exchange.total_cost
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.explain_remark
     *
     * @return the value of tb_order_exchange.explain_remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getExplainRemark() {
        return explainRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.explain_remark
     *
     * @param explainRemark the value for tb_order_exchange.explain_remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setExplainRemark(String explainRemark) {
        this.explainRemark = explainRemark == null ? null : explainRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.warehouse
     *
     * @return the value of tb_order_exchange.warehouse
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getWarehouse() {
        return warehouse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.warehouse
     *
     * @param warehouse the value for tb_order_exchange.warehouse
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.location
     *
     * @return the value of tb_order_exchange.location
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.location
     *
     * @param location the value for tb_order_exchange.location
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.remark
     *
     * @return the value of tb_order_exchange.remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.remark
     *
     * @param remark the value for tb_order_exchange.remark
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.create_time
     *
     * @return the value of tb_order_exchange.create_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.create_time
     *
     * @param createTime the value for tb_order_exchange.create_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.update_time
     *
     * @return the value of tb_order_exchange.update_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.update_time
     *
     * @param updateTime the value for tb_order_exchange.update_time
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.create_user
     *
     * @return the value of tb_order_exchange.create_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.create_user
     *
     * @param createUser the value for tb_order_exchange.create_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.update_user
     *
     * @return the value of tb_order_exchange.update_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.update_user
     *
     * @param updateUser the value for tb_order_exchange.update_user
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_exchange.enable
     *
     * @return the value of tb_order_exchange.enable
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_exchange.enable
     *
     * @param enable the value for tb_order_exchange.enable
     *
     * @mbg.generated Sun Aug 01 01:11:07 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}