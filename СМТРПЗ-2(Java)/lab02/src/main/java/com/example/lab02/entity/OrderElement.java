package com.example.lab02.entity;

public class OrderElement { // Order element

    private Long id; // primary key элемента
    private Long orderNumber; // ссылка на Order
    private Long productId;
    private int productCount;

    public OrderElement() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "OrderElement{" +
                "id=" + id +
                ", productId=" + productId +
                '}';
    }

}
