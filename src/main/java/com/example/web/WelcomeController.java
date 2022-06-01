package com.example.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.domain.ProductInfo;
import com.example.service.Check;
import com.example.service.DBIO;

@Controller
//セッションで管理するオブジェクトのキー名を指定
@SessionAttributes("courseForm")
public class WelcomeController {

    @Autowired
    private DBIO service;

    @Autowired
    private Check check;

    @ModelAttribute("courseForm")
    public CourseForm setForm() {
        return new CourseForm();
    }

    @ModelAttribute("userForm")
    public UserForm setUserForm() {
        return new UserForm();
    }

    @RequestMapping(value = "/menu")
    public String firstGuest() {
        return "menu";
    }

    @RequestMapping(value = "/menu",params = "login")
    public String first(@Validated UserForm form, BindingResult result) {

    	check.errorUserCheck(form, result);

        // エラー判定
        if(result.hasErrors()) {
            return "userHandle/login";
        }

        String path = check.authorityCheck(form);

        return path;
    }

    @RequestMapping(value = "/input", params = "regist")
    public String menuAction() {

        return "input";
    }

    //戻るボタンを押したとき
    @RequestMapping(value = "/conf", params = "back")
    public String inputActionBack() {
        return "menu";
    }

    //確認ボタンを押したとき
    @RequestMapping(value = "/conf", params = "next")
    public String inputActionNext(@Validated CourseForm form, BindingResult result, Model model) {
    	model.addAttribute(form);

    	check.errorCheck(form, result);

        // エラー判定
        if(result.hasErrors()) {
            return "input";
        }

        return "conf";
    }

    @RequestMapping(value = "/end", params = "back")
    public String confActionBack(CourseForm form) {
        return "input";
    }

    @RequestMapping(value = "/end", params = "regist")
    public String confActionRegist(CourseForm form) {

        // データ登録に利用するドメインクラスのインスタンス化
        ProductInfo productInfo = new ProductInfo();

        // Formクラスの値をドメインクラスにコピー
        BeanUtils.copyProperties(form, productInfo);

        // データ登録を行うためのサービス処理呼び出し
        service.insertProductInfo(productInfo);

        // 完了画面へのリダイレクト
        return "redirect:/insert-sample-end?finish";
    }

    // リダイレクト後に呼び出される処理メソッド
    @RequestMapping(value = "/insert-sample-end", params = "finish")
    public String endFinish(SessionStatus sessionStatus) {

    	//SessionAttributesで指定したオブジェクトをセッションから破棄
    	sessionStatus.setComplete();

        return "end";
    }

    @RequestMapping(value = "/fin", params = "menu")
    public String endActionMenu(CourseForm form) {
        return "menu";
    }

    @RequestMapping(value = "/fin", params = "add")
    public String endActionAdd(CourseForm form) {
        return "input";
    }
}