package com.example.persistence;

import com.example.domain.ProductInfo;
import com.example.domain.UserInfo;
import com.example.web.UserForm;

public interface ProductInfoMapper {

    public void insert(ProductInfo productInfo);

    public Integer selectcount(ProductInfo productInfo);

	public void insertUser(UserForm userForm);

	 public Integer usercount(UserInfo userForm);

	 public Integer idcount(UserInfo userForm);

	 public Integer authcount(UserInfo userForm);
}