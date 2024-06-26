package com.thuydev.app_ban_an.DTO;

import java.util.List;

public class ProductDetailDTO {
    String _id,IDProduct,IDCategory,Date;
    int Amount;
    List<String> Size;


    public ProductDetailDTO() {
    }

    public ProductDetailDTO(String _id, String IDProduct, String IDCategory, String date, int amount, List<String> size) {
        this._id = _id;
        this.IDProduct = IDProduct;
        this.IDCategory = IDCategory;
        Date = date;
        Amount = amount;
        Size = size;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(String IDProduct) {
        this.IDProduct = IDProduct;
    }

    public String getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(String IDCategory) {
        this.IDCategory = IDCategory;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public List<String> getSize() {
        return Size;
    }

    public void setSize(List<String> size) {
        Size = size;
    }
}
