package com.yc.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbStatusFlowRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public TbStatusFlowRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeIsNull() {
            addCriterion("work_user_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeIsNotNull() {
            addCriterion("work_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeEqualTo(String value) {
            addCriterion("work_user_code =", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeNotEqualTo(String value) {
            addCriterion("work_user_code <>", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeGreaterThan(String value) {
            addCriterion("work_user_code >", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("work_user_code >=", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeLessThan(String value) {
            addCriterion("work_user_code <", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeLessThanOrEqualTo(String value) {
            addCriterion("work_user_code <=", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeLike(String value) {
            addCriterion("work_user_code like", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeNotLike(String value) {
            addCriterion("work_user_code not like", value, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeIn(List<String> values) {
            addCriterion("work_user_code in", values, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeNotIn(List<String> values) {
            addCriterion("work_user_code not in", values, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeBetween(String value1, String value2) {
            addCriterion("work_user_code between", value1, value2, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserCodeNotBetween(String value1, String value2) {
            addCriterion("work_user_code not between", value1, value2, "workUserCode");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameIsNull() {
            addCriterion("work_user_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameIsNotNull() {
            addCriterion("work_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameEqualTo(String value) {
            addCriterion("work_user_name =", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameNotEqualTo(String value) {
            addCriterion("work_user_name <>", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameGreaterThan(String value) {
            addCriterion("work_user_name >", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_user_name >=", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameLessThan(String value) {
            addCriterion("work_user_name <", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameLessThanOrEqualTo(String value) {
            addCriterion("work_user_name <=", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameLike(String value) {
            addCriterion("work_user_name like", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameNotLike(String value) {
            addCriterion("work_user_name not like", value, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameIn(List<String> values) {
            addCriterion("work_user_name in", values, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameNotIn(List<String> values) {
            addCriterion("work_user_name not in", values, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameBetween(String value1, String value2) {
            addCriterion("work_user_name between", value1, value2, "workUserName");
            return (Criteria) this;
        }

        public Criteria andWorkUserNameNotBetween(String value1, String value2) {
            addCriterion("work_user_name not between", value1, value2, "workUserName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andAclCodeIsNull() {
            addCriterion("acl_code is null");
            return (Criteria) this;
        }

        public Criteria andAclCodeIsNotNull() {
            addCriterion("acl_code is not null");
            return (Criteria) this;
        }

        public Criteria andAclCodeEqualTo(String value) {
            addCriterion("acl_code =", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeNotEqualTo(String value) {
            addCriterion("acl_code <>", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeGreaterThan(String value) {
            addCriterion("acl_code >", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeGreaterThanOrEqualTo(String value) {
            addCriterion("acl_code >=", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeLessThan(String value) {
            addCriterion("acl_code <", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeLessThanOrEqualTo(String value) {
            addCriterion("acl_code <=", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeLike(String value) {
            addCriterion("acl_code like", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeNotLike(String value) {
            addCriterion("acl_code not like", value, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeIn(List<String> values) {
            addCriterion("acl_code in", values, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeNotIn(List<String> values) {
            addCriterion("acl_code not in", values, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeBetween(String value1, String value2) {
            addCriterion("acl_code between", value1, value2, "aclCode");
            return (Criteria) this;
        }

        public Criteria andAclCodeNotBetween(String value1, String value2) {
            addCriterion("acl_code not between", value1, value2, "aclCode");
            return (Criteria) this;
        }

        public Criteria andDefTypeIsNull() {
            addCriterion("def_type is null");
            return (Criteria) this;
        }

        public Criteria andDefTypeIsNotNull() {
            addCriterion("def_type is not null");
            return (Criteria) this;
        }

        public Criteria andDefTypeEqualTo(Integer value) {
            addCriterion("def_type =", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeNotEqualTo(Integer value) {
            addCriterion("def_type <>", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeGreaterThan(Integer value) {
            addCriterion("def_type >", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("def_type >=", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeLessThan(Integer value) {
            addCriterion("def_type <", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeLessThanOrEqualTo(Integer value) {
            addCriterion("def_type <=", value, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeIn(List<Integer> values) {
            addCriterion("def_type in", values, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeNotIn(List<Integer> values) {
            addCriterion("def_type not in", values, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeBetween(Integer value1, Integer value2) {
            addCriterion("def_type between", value1, value2, "defType");
            return (Criteria) this;
        }

        public Criteria andDefTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("def_type not between", value1, value2, "defType");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated do_not_delete_during_merge Fri Jun 04 15:47:16 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}