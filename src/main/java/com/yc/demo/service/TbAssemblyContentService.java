package com.yc.demo.service;

import com.yc.demo.domain.TbAssemblyContent;
import com.yc.demo.domain.ex.AssemblyContentForm;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbAssemblyContent
 * @Date 2021/2/25 12:05
 * @Description：
 */
public interface TbAssemblyContentService {

    public List<TbAssemblyContent> select(AssemblyContentForm tbAssemblyContent);

    public TbAssemblyContent insert(TbAssemblyContent  tbAssemblyContent);

    public TbAssemblyContent updateById(TbAssemblyContent  tbAssemblyContent);

    void deleteById(Long id);
}
