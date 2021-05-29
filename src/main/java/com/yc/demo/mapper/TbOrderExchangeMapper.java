package com.yc.demo.mapper;

import com.yc.demo.domain.TbOrderExchange;
import com.yc.demo.domain.TbOrderExchangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderExchangeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    long countByExample(TbOrderExchangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int deleteByExample(TbOrderExchangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int insert(TbOrderExchange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int insertSelective(TbOrderExchange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    List<TbOrderExchange> selectByExample(TbOrderExchangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    TbOrderExchange selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbOrderExchange record, @Param("example") TbOrderExchangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int updateByExample(@Param("record") TbOrderExchange record, @Param("example") TbOrderExchangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int updateByPrimaryKeySelective(TbOrderExchange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_exchange
     *
     * @mbg.generated Sat May 29 19:25:54 CST 2021
     */
    int updateByPrimaryKey(TbOrderExchange record);
}