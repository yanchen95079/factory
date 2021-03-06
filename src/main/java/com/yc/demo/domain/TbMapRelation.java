package com.yc.demo.domain;

import com.yc.demo.domain.ex.BasePoJo;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_map_relation
 *
 * @mbg.generated do_not_delete_during_merge Sat Apr 03 23:06:19 CST 2021
 */
public class TbMapRelation extends BasePoJo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.id
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   配置类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.config_type
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String configType;

    /**
     * Database Column Remarks:
     *   第1级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level1
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level1;

    /**
     * Database Column Remarks:
     *   第2级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level2
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level2;

    /**
     * Database Column Remarks:
     *   第3级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level3
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level4
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level4;

    /**
     * Database Column Remarks:
     *   第5级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level5
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level5;

    /**
     * Database Column Remarks:
     *   第6级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level6
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level6;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level7
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level7;

    /**
     * Database Column Remarks:
     *   第8级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level8
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level8;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level9
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level9;

    /**
     * Database Column Remarks:
     *   第10级数据
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.level10
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private String level10;

    /**
     * Database Column Remarks:
     *   位置顺序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.position
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Integer position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.create_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.update_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   1可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.enable
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Integer enable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.create_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Long createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_map_relation.update_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    private Long updateUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.id
     *
     * @return the value of tb_map_relation.id
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.id
     *
     * @param id the value for tb_map_relation.id
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.config_type
     *
     * @return the value of tb_map_relation.config_type
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.config_type
     *
     * @param configType the value for tb_map_relation.config_type
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level1
     *
     * @return the value of tb_map_relation.level1
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel1() {
        return level1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level1
     *
     * @param level1 the value for tb_map_relation.level1
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel1(String level1) {
        this.level1 = level1 == null ? null : level1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level2
     *
     * @return the value of tb_map_relation.level2
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel2() {
        return level2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level2
     *
     * @param level2 the value for tb_map_relation.level2
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel2(String level2) {
        this.level2 = level2 == null ? null : level2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level3
     *
     * @return the value of tb_map_relation.level3
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel3() {
        return level3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level3
     *
     * @param level3 the value for tb_map_relation.level3
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel3(String level3) {
        this.level3 = level3 == null ? null : level3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level4
     *
     * @return the value of tb_map_relation.level4
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel4() {
        return level4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level4
     *
     * @param level4 the value for tb_map_relation.level4
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel4(String level4) {
        this.level4 = level4 == null ? null : level4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level5
     *
     * @return the value of tb_map_relation.level5
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel5() {
        return level5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level5
     *
     * @param level5 the value for tb_map_relation.level5
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel5(String level5) {
        this.level5 = level5 == null ? null : level5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level6
     *
     * @return the value of tb_map_relation.level6
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel6() {
        return level6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level6
     *
     * @param level6 the value for tb_map_relation.level6
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel6(String level6) {
        this.level6 = level6 == null ? null : level6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level7
     *
     * @return the value of tb_map_relation.level7
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel7() {
        return level7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level7
     *
     * @param level7 the value for tb_map_relation.level7
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel7(String level7) {
        this.level7 = level7 == null ? null : level7.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level8
     *
     * @return the value of tb_map_relation.level8
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel8() {
        return level8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level8
     *
     * @param level8 the value for tb_map_relation.level8
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel8(String level8) {
        this.level8 = level8 == null ? null : level8.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level9
     *
     * @return the value of tb_map_relation.level9
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel9() {
        return level9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level9
     *
     * @param level9 the value for tb_map_relation.level9
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel9(String level9) {
        this.level9 = level9 == null ? null : level9.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.level10
     *
     * @return the value of tb_map_relation.level10
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public String getLevel10() {
        return level10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.level10
     *
     * @param level10 the value for tb_map_relation.level10
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setLevel10(String level10) {
        this.level10 = level10 == null ? null : level10.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.position
     *
     * @return the value of tb_map_relation.position
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.position
     *
     * @param position the value for tb_map_relation.position
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.create_time
     *
     * @return the value of tb_map_relation.create_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.create_time
     *
     * @param createTime the value for tb_map_relation.create_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.update_time
     *
     * @return the value of tb_map_relation.update_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.update_time
     *
     * @param updateTime the value for tb_map_relation.update_time
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.enable
     *
     * @return the value of tb_map_relation.enable
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.enable
     *
     * @param enable the value for tb_map_relation.enable
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.create_user
     *
     * @return the value of tb_map_relation.create_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.create_user
     *
     * @param createUser the value for tb_map_relation.create_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_map_relation.update_user
     *
     * @return the value of tb_map_relation.update_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_map_relation.update_user
     *
     * @param updateUser the value for tb_map_relation.update_user
     *
     * @mbg.generated Sat Apr 03 23:06:19 CST 2021
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}