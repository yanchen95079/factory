package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbCheckInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yanchen
 * @ClassName CheckInfoSelectPage
 * @Date 2021/4/9 18:31
 * @Description：
 */
@Getter
@Setter
public class CheckInfoSelectPage extends TbCheckInfo {
    private Integer offset;
    private Integer limit;
    private String orderNoLike;
    private String productNoLike;
    private String serialNoLike;
    private Date createTimeStart;
    private Date createTimeEnd;
}
