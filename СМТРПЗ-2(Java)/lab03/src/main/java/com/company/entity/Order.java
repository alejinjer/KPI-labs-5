package com.company.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "order_number")
    private Integer order_number;

    @Column (name = "id_user")
    private Integer id_user;

    @Column (name = "id_product")
    private Integer id_product;

    @Column (name = "product_count")
    private Integer product_count;

    @Column (name = "creation_date")
    private Date creation_date;

    @Column (name = "total_sum")
    private Long totalSum;

    public Order() {
    }


    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getProduct_count() {
        return product_count;
    }

    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
    }
}
