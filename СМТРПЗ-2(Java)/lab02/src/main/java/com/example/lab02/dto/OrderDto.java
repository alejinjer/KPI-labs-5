package com.example.lab02.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long userId;
    private List<OrderElementDto> list;

    public OrderDto() {
        this.list = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderElementDto> getList() {
        return list;
    }

    public void setList(List<OrderElementDto> list) {
        this.list = list;
    }
}
