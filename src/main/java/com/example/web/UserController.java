package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.service.Check;
import com.example.service.DBIO;

@Controller
//セッションで管理するオブジェクトのキー名を指定
@SessionAttributes("userForm")
public class UserController {

    @Autowired
    private DBIO service;

    @Autowired
    private Check check;

    @ModelAttribute("userForm")
    public UserForm setForm() {
        return new UserForm();
    }

    @RequestMapping("/login")
    public String first() {
        return "userHandle/login";
    }

    @RequestMapping("/regist")
    public String registDisp() {

        return "userHandle/userRegist";
    }

    @RequestMapping(value = "/userConf", params = "back" )
    public String registBack(SessionStatus sessionStatus) {

    	//SessionAttributesで指定したオブジェクトをセッションから破棄
    	sessionStatus.setComplete();

        return "userHandle/login";
    }

    @RequestMapping(value = "/userConf", params = "conf" )
    public String confDisp(@Validated UserForm form, BindingResult result) {

    	check.errorAcountCheck(form, result);

        // エラー判定
        if(result.hasErrors()) {
            return "userHandle/userRegist";
        }

        return "userHandle/userConf";
    }

    @RequestMapping(value = "/userEnd", params = "back" )
    public String confBack() {
        return "redirect:/regist";
    }

    @RequestMapping(value = "/userEnd", params = "conf")
    public String confActionRegist(UserForm form) {

        // データ登録を行うためのサービス処理呼び出し
        service.insertUserinfo(form);

        // 完了画面へのリダイレクト
        return "redirect:/regist-userEnd?finish";
    }

    @RequestMapping(value = "/regist-userEnd", params = "finish" )
    public String endDisp(SessionStatus sessionStatus) {

    	//SessionAttributesで指定したオブジェクトをセッションから破棄
    	sessionStatus.setComplete();

        return "userHandle/userEnd";
    }

}
