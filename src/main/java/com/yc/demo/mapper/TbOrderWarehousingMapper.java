package com.yc.demo.mapper;

import com.yc.demo.domain.TbOrderWarehousing;
import com.yc.demo.domain.TbOrderWarehousingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderWarehousingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    long countByExample(TbOrderWarehousingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int deleteByExample(TbOrderWarehousingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int insert(TbOrderWarehousing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int insertSelective(TbOrderWarehousing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    List<TbOrderWarehousing> selectByExample(TbOrderWarehousingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    TbOrderWarehousing selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbOrderWarehousing record, @Param("example") TbOrderWarehousingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int updateByExample(@Param("record") TbOrderWarehousing record, @Param("example") TbOrderWarehousingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int updateByPrimaryKeySelective(TbOrderWarehousing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_warehousing
     *
     * @mbg.generated Sat May 29 19:26:35 CST 2021
     */
    int updateByPrimaryKey(TbOrderWarehousing record);

    void batchInsert(List<TbOrderWarehousing> list);

    void batchUpdate(List<TbOrderWarehousing> list);
}