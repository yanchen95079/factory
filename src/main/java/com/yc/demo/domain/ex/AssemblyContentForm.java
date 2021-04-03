package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbAssemblyContent;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbAssemblyContentForm
 * @Date 2021/3/5 16:44
 * @Description：
 */
@Setter
@Getter
public class AssemblyContentForm extends TbAssemblyContent {
    private List<Long> ids;
}
