package com.yc.demo.mapper;

import com.yc.demo.domain.TbStatusFlowRecord;
import com.yc.demo.domain.TbStatusFlowRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStatusFlowRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    long countByExample(TbStatusFlowRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int deleteByExample(TbStatusFlowRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int insert(TbStatusFlowRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int insertSelective(TbStatusFlowRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    List<TbStatusFlowRecord> selectByExample(TbStatusFlowRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    TbStatusFlowRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbStatusFlowRecord record, @Param("example") TbStatusFlowRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int updateByExample(@Param("record") TbStatusFlowRecord record, @Param("example") TbStatusFlowRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int updateByPrimaryKeySelective(TbStatusFlowRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_status_flow_record
     *
     * @mbg.generated Fri Jun 04 15:47:16 CST 2021
     */
    int updateByPrimaryKey(TbStatusFlowRecord record);

    void batchInsert(List<TbStatusFlowRecord> list);
}