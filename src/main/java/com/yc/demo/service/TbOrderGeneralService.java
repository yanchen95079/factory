package com.yc.demo.service;

/**
 * @author Yanchen
 * date 2021/5/29 20:34
 */
public interface TbOrderGeneralService {
    void insert(boolean next);

    /**
     * 下一步
     */
    void nextStep();
    /**
     * 上一步
     */
    void backStep();

    /**
     * 保存当前这步
     */
    void saveStep();

    /**
     * 受理
     */
    void acceptance();
    void delete();

    void select();
}
