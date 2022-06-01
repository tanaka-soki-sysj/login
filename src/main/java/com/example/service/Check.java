package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.domain.ProductInfo;
import com.example.domain.UserInfo;
import com.example.web.CourseForm;
import com.example.web.UserForm;

@Service
public class Check {

	@Autowired
	private DBIO service;

	public BindingResult errorCheck(@Validated CourseForm form, BindingResult result) {

		if (form.getCourseNo() != null && !form.getCourseNo().equals("")) {

			// データ検索に利用するドメインクラスのインスタンス化
			ProductInfo productInfo = new ProductInfo();

			// Formクラスの値をドメインクラスにコピー
			BeanUtils.copyProperties(form, productInfo);

			// 検索を行うためのサービス処理呼び出し
			boolean duplicateFlag = service.countProductInfo(productInfo);

			//照合結果がtrueの場合重複チェック
			if (duplicateFlag) {
				// エラーメッセージの設定
				result.rejectValue("courseNo", "errors.invalid.number");
			}
		}

		// エラーチェックロジックの記述
		if (form.getMonth().equals("") || form.getYear().equals("") || form.getDay().equals("")) {
			// エラーメッセージの設定
			result.reject("errors.invalid.date");
		}
		if (form.getStartHour().equals("") || form.getStartMinutes().equals("")) {
			// エラーメッセージの設定
			result.reject("errors.invalid.start");
		}
		if (form.getFinishHour().equals("") || form.getFinishMinutes().equals("")) {
			// エラーメッセージの設定
			result.reject("errors.invalid.finish");
		}

		if (form.getStartHour() != null && form.getStartMinutes() != null
				&& form.getFinishHour() != null && form.getFinishMinutes() != null
				&& !form.getStartHour().equals("") && !form.getStartMinutes().equals("")
				&& !form.getFinishHour().equals("") && !form.getFinishMinutes().equals("")) {
			String startTime = "";
			String finishTime = "";

			if (form.getStartMinutes().equals("0")) {
				startTime = form.getStartHour() + form.getStartMinutes() + "0";
			} else {
				startTime = form.getStartHour() + form.getStartMinutes();
			}

			if (form.getFinishMinutes().equals("0")) {
				finishTime = form.getFinishHour() + form.getFinishMinutes() + "0";
			} else {
				finishTime = form.getFinishHour() + form.getFinishMinutes();
			}

			if (Integer.parseInt(startTime) > Integer.parseInt(finishTime)) {
				// エラーメッセージの設定
				result.reject("errors.invalid.inverse");
			}
		}
		return result;

	}

	public BindingResult errorUserCheck(@Validated UserForm form, BindingResult result) {

		if (form.getUserId() != null && !form.getUserId().equals("") &&
				form.getPasswd() != null && !form.getPasswd().equals("")) {

	        // データ登録に利用するドメインクラスのインスタンス化
	        UserInfo userInfo = new UserInfo();

	        // Formクラスの値をドメインクラスにコピー
	        BeanUtils.copyProperties(form, userInfo);

			// 検索を行うためのサービス処理呼び出し
			boolean duplicateFlag = service.checkId(userInfo);

			//照合結果がtrueの場合重複チェック
			if (duplicateFlag) {
				// エラーメッセージの設定
				result.rejectValue("userId", "errors.invalid.idCheck");
			}
		}

		if (form.getUserId().equals("") || form.getPasswd().equals("")) {
			// エラーメッセージの設定
			result.reject("errors.invalid.userpass");
		}

		return result;

	}

	public BindingResult errorAcountCheck(@Validated UserForm form, BindingResult result) {

		if (form.getUserId() != null && !form.getUserId().equals("")) {

	        // データ登録に利用するドメインクラスのインスタンス化
	        UserInfo userInfo = new UserInfo();

	        // Formクラスの値をドメインクラスにコピー
	        BeanUtils.copyProperties(form, userInfo);

			// 検索を行うためのサービス処理呼び出し
			boolean duplicateFlag = service.chId(userInfo);

			//照合結果がtrueの場合重複チェック
			if (duplicateFlag) {
				// エラーメッセージの設定
				result.rejectValue("userId", "errors.invalid.idAlready");
			}
		}

		if (form.getUserId().equals("")) {
			// エラーメッセージの設定
						result.reject("errors.invalid.usernot");
		}
		if (form.getPasswd().equals("")) {
			// エラーメッセージの設定
			result.reject("errors.invalid.passnot");
		}

		if(!form.getPasswd().equals(form.getPasswdConf())) {
			result.reject("errors.invalid.passmiss");
		}

		return result;

	}

	public String authorityCheck(UserForm form) {

		String path = "";

		if (form.getUserId() != null && !form.getUserId().equals("")) {

	        // データ登録に利用するドメインクラスのインスタンス化
	        UserInfo userInfo = new UserInfo();

	        // Formクラスの値をドメインクラスにコピー
	        BeanUtils.copyProperties(form, userInfo);

			// 検索を行うためのサービス処理呼び出し
			int flag = service.authorityId(userInfo);

			//照合結果がtrueの場合重複チェック
			if (flag == 0) {
				path = "menu";
			}else if (flag == 1) {
				path = "courseApp/applicationMenu";
			}
		}

		return path;

	}
}
