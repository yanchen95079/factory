package com.yc.demo.mapper;

import com.yc.demo.domain.TbAclRoleRelation;
import com.yc.demo.domain.TbAclRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAclRoleRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    long countByExample(TbAclRoleRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int deleteByExample(TbAclRoleRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int insert(TbAclRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int insertSelective(TbAclRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    List<TbAclRoleRelation> selectByExample(TbAclRoleRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    TbAclRoleRelation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbAclRoleRelation record, @Param("example") TbAclRoleRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int updateByExample(@Param("record") TbAclRoleRelation record, @Param("example") TbAclRoleRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int updateByPrimaryKeySelective(TbAclRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_acl_role_relation
     *
     * @mbg.generated Sat May 29 19:24:45 CST 2021
     */
    int updateByPrimaryKey(TbAclRoleRelation record);

    void batchInsert(List<TbAclRoleRelation> list);
}