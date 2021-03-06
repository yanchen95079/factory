package com.yc.demo.mapper;

import com.yc.demo.domain.TbOrderGeneral;
import com.yc.demo.domain.TbOrderGeneralExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderGeneralMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    long countByExample(TbOrderGeneralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int deleteByExample(TbOrderGeneralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int insert(TbOrderGeneral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int insertSelective(TbOrderGeneral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    List<TbOrderGeneral> selectByExample(TbOrderGeneralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    TbOrderGeneral selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbOrderGeneral record, @Param("example") TbOrderGeneralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int updateByExample(@Param("record") TbOrderGeneral record, @Param("example") TbOrderGeneralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int updateByPrimaryKeySelective(TbOrderGeneral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_general
     *
     * @mbg.generated Fri Jun 04 21:11:31 CST 2021
     */
    int updateByPrimaryKey(TbOrderGeneral record);
}