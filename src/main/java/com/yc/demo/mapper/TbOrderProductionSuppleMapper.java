package com.yc.demo.mapper;

import com.yc.demo.domain.TbOrderProductionSupple;
import com.yc.demo.domain.TbOrderProductionSuppleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderProductionSuppleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    long countByExample(TbOrderProductionSuppleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int deleteByExample(TbOrderProductionSuppleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int insert(TbOrderProductionSupple record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int insertSelective(TbOrderProductionSupple record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    List<TbOrderProductionSupple> selectByExample(TbOrderProductionSuppleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    TbOrderProductionSupple selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbOrderProductionSupple record, @Param("example") TbOrderProductionSuppleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int updateByExample(@Param("record") TbOrderProductionSupple record, @Param("example") TbOrderProductionSuppleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int updateByPrimaryKeySelective(TbOrderProductionSupple record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_production_supple
     *
     * @mbg.generated Sat May 29 19:26:14 CST 2021
     */
    int updateByPrimaryKey(TbOrderProductionSupple record);

    void batchInsert(List<TbOrderProductionSupple> list);

    void batchUpdate(List<TbOrderProductionSupple> list);
}