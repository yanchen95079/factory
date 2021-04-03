package com.yc.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * @ClassName UpdateTicketSelective
 * @Date 2020/12/31 11:49
 * @Description：
 */
@Getter
@Setter
@AllArgsConstructor
public class UpdateTicketSelective {
private Long ticketId;
private Integer state;
}
