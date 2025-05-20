package com.ghani.bms.request;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class TicketRequest {

    private Long userId;
    private List<Long> showSeatIds;
}
