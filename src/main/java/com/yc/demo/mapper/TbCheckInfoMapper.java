package com.yc.demo.mapper;

import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbCheckInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCheckInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    long countByExample(TbCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int deleteByExample(TbCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int insert(TbCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int insertSelective(TbCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    List<TbCheckInfo> selectByExample(TbCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    TbCheckInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int updateByExampleSelective(@Param("record") TbCheckInfo record, @Param("example") TbCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int updateByExample(@Param("record") TbCheckInfo record, @Param("example") TbCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int updateByPrimaryKeySelective(TbCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_check_info
     *
     * @mbg.generated Thu Apr 15 20:05:58 CST 2021
     */
    int updateByPrimaryKey(TbCheckInfo record);

    List<String> selectAllConfigKey(TbCheckInfo record);
}