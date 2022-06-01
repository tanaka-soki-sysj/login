package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ProductInfo;
import com.example.domain.UserInfo;
import com.example.persistence.ProductInfoMapper;
import com.example.web.UserForm;

@Service
public class DBIO {

    @Autowired
    private ProductInfoMapper mapper;

    // データ登録処理メソッド
    public void insertProductInfo(ProductInfo productInfo) {

    	productInfo.setTheDate(productInfo.getYear()+"-"+productInfo.getMonth()+"-"+productInfo.getDay());
    	productInfo.setStartTime(productInfo.getStartHour()+":"+productInfo.getStartMinutes());
    	productInfo.setEndTime(productInfo.getFinishHour()+":"+productInfo.getFinishMinutes());

        // データ登録
        mapper.insert(productInfo);
    }

    // データ検索処理メソッド
    public boolean countProductInfo(ProductInfo productInfo) {

    	//
    	boolean flag = false;
        // データ検索
        Integer mapperCount = mapper.selectcount(productInfo);

        if(mapperCount > 0) {
        	flag = true;
        }

        return flag;
    }

    // データ登録処理メソッド
    public void insertUserinfo(UserForm userForm) {

        // データ登録
        mapper.insertUser(userForm);
    }

    // データ検索処理メソッド
    public boolean checkId(UserInfo userForm) {

    	//
    	boolean flag = true;
        // データ検索
        Integer mapperCount = mapper.usercount(userForm);

        if(mapperCount > 0) {
        	flag = false;
        }

        return flag;
    }

    // データ検索処理メソッド
    public boolean chId(UserInfo userForm) {

    	//
    	boolean flag = false;
        // データ検索
        Integer mapperCount = mapper.idcount(userForm);

        if(mapperCount > 0) {
        	flag = true;
        }

        return flag;
    }

    // データ検索処理メソッド
    public int authorityId(UserInfo userForm) {

    	//
    	int flag = 0;
        // データ検索
        Integer mapperCount = mapper.authcount(userForm);

        if(mapperCount > 0) {
        	flag = 1;
        }

        return flag;
    }
}