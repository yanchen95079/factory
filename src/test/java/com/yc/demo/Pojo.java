package com.yc.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * @ClassName Pojo
 * @Date 2020/12/31 11:48
 * @Description：
 */
@Setter
@Getter
@AllArgsConstructor
public class Pojo {
    private String project;
    private Long ticketId;
    private UpdateTicketSelective updateTicketSelective;
    private String paramStr;
}
