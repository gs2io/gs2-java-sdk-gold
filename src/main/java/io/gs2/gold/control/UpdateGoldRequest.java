/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.gold.control;

import org.json.JSONObject;
import java.util.List;
import io.gs2.gold.Gs2Gold;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class UpdateGoldRequest extends Gs2BasicRequest<UpdateGoldRequest> {

	public static class Constant extends Gs2Gold.Constant {
		public static final String FUNCTION = "UpdateGold";
	}

	/** ゴールドの名前を指定します。 */
	private String goldName;

	/** 説明文 */
	private String description;

	/** 期間内の取得量をリセットする時 */
	private Integer resetHour;

	/** サービスクラス */
	private String serviceClass;

	/** 各ウォレットの残高の最大値 */
	private Integer balanceMax;

	/** 期間内の最大取得量 */
	private Integer periodicalLimit;

	/** 期間内の取得量をリセットする日にち */
	private Integer resetDayOfMonth;

	/** 期間内の取得量をリセットする曜日 */
	private String resetDayOfWeek;

	/** 通知先 URL */
	private String notificationUrl;

	/** 取得量の期間制限のタイプ */
	private String restrictionType;


	/**
	 * ゴールドの名前を指定します。を取得
	 *
	 * @return ゴールドの名前を指定します。
	 */
	public String getGoldName() {
		return goldName;
	}

	/**
	 * ゴールドの名前を指定します。を設定
	 *
	 * @param goldName ゴールドの名前を指定します。
	 */
	public void setGoldName(String goldName) {
		this.goldName = goldName;
	}

	/**
	 * ゴールドの名前を指定します。を設定
	 *
	 * @param goldName ゴールドの名前を指定します。
	 * @return this
	 */
	public UpdateGoldRequest withGoldName(String goldName) {
		setGoldName(goldName);
		return this;
	}

	/**
	 * 説明文を取得
	 *
	 * @return 説明文
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 説明文を設定
	 *
	 * @param description 説明文
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 説明文を設定
	 *
	 * @param description 説明文
	 * @return this
	 */
	public UpdateGoldRequest withDescription(String description) {
		setDescription(description);
		return this;
	}

	/**
	 * 期間内の取得量をリセットする時を取得
	 *
	 * @return 期間内の取得量をリセットする時
	 */
	public Integer getResetHour() {
		return resetHour;
	}

	/**
	 * 期間内の取得量をリセットする時を設定
	 *
	 * @param resetHour 期間内の取得量をリセットする時
	 */
	public void setResetHour(Integer resetHour) {
		this.resetHour = resetHour;
	}

	/**
	 * 期間内の取得量をリセットする時を設定
	 *
	 * @param resetHour 期間内の取得量をリセットする時
	 * @return this
	 */
	public UpdateGoldRequest withResetHour(Integer resetHour) {
		setResetHour(resetHour);
		return this;
	}

	/**
	 * サービスクラスを取得
	 *
	 * @return サービスクラス
	 */
	public String getServiceClass() {
		return serviceClass;
	}

	/**
	 * サービスクラスを設定
	 *
	 * @param serviceClass サービスクラス
	 */
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	/**
	 * サービスクラスを設定
	 *
	 * @param serviceClass サービスクラス
	 * @return this
	 */
	public UpdateGoldRequest withServiceClass(String serviceClass) {
		setServiceClass(serviceClass);
		return this;
	}

	/**
	 * 各ウォレットの残高の最大値を取得
	 *
	 * @return 各ウォレットの残高の最大値
	 */
	public Integer getBalanceMax() {
		return balanceMax;
	}

	/**
	 * 各ウォレットの残高の最大値を設定
	 *
	 * @param balanceMax 各ウォレットの残高の最大値
	 */
	public void setBalanceMax(Integer balanceMax) {
		this.balanceMax = balanceMax;
	}

	/**
	 * 各ウォレットの残高の最大値を設定
	 *
	 * @param balanceMax 各ウォレットの残高の最大値
	 * @return this
	 */
	public UpdateGoldRequest withBalanceMax(Integer balanceMax) {
		setBalanceMax(balanceMax);
		return this;
	}

	/**
	 * 期間内の最大取得量を取得
	 *
	 * @return 期間内の最大取得量
	 */
	public Integer getPeriodicalLimit() {
		return periodicalLimit;
	}

	/**
	 * 期間内の最大取得量を設定
	 *
	 * @param periodicalLimit 期間内の最大取得量
	 */
	public void setPeriodicalLimit(Integer periodicalLimit) {
		this.periodicalLimit = periodicalLimit;
	}

	/**
	 * 期間内の最大取得量を設定
	 *
	 * @param periodicalLimit 期間内の最大取得量
	 * @return this
	 */
	public UpdateGoldRequest withPeriodicalLimit(Integer periodicalLimit) {
		setPeriodicalLimit(periodicalLimit);
		return this;
	}

	/**
	 * 期間内の取得量をリセットする日にちを取得
	 *
	 * @return 期間内の取得量をリセットする日にち
	 */
	public Integer getResetDayOfMonth() {
		return resetDayOfMonth;
	}

	/**
	 * 期間内の取得量をリセットする日にちを設定
	 *
	 * @param resetDayOfMonth 期間内の取得量をリセットする日にち
	 */
	public void setResetDayOfMonth(Integer resetDayOfMonth) {
		this.resetDayOfMonth = resetDayOfMonth;
	}

	/**
	 * 期間内の取得量をリセットする日にちを設定
	 *
	 * @param resetDayOfMonth 期間内の取得量をリセットする日にち
	 * @return this
	 */
	public UpdateGoldRequest withResetDayOfMonth(Integer resetDayOfMonth) {
		setResetDayOfMonth(resetDayOfMonth);
		return this;
	}

	/**
	 * 期間内の取得量をリセットする曜日を取得
	 *
	 * @return 期間内の取得量をリセットする曜日
	 */
	public String getResetDayOfWeek() {
		return resetDayOfWeek;
	}

	/**
	 * 期間内の取得量をリセットする曜日を設定
	 *
	 * @param resetDayOfWeek 期間内の取得量をリセットする曜日
	 */
	public void setResetDayOfWeek(String resetDayOfWeek) {
		this.resetDayOfWeek = resetDayOfWeek;
	}

	/**
	 * 期間内の取得量をリセットする曜日を設定
	 *
	 * @param resetDayOfWeek 期間内の取得量をリセットする曜日
	 * @return this
	 */
	public UpdateGoldRequest withResetDayOfWeek(String resetDayOfWeek) {
		setResetDayOfWeek(resetDayOfWeek);
		return this;
	}

	/**
	 * 通知先 URLを取得
	 *
	 * @return 通知先 URL
	 */
	public String getNotificationUrl() {
		return notificationUrl;
	}

	/**
	 * 通知先 URLを設定
	 *
	 * @param notificationUrl 通知先 URL
	 */
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	/**
	 * 通知先 URLを設定
	 *
	 * @param notificationUrl 通知先 URL
	 * @return this
	 */
	public UpdateGoldRequest withNotificationUrl(String notificationUrl) {
		setNotificationUrl(notificationUrl);
		return this;
	}

	/**
	 * 取得量の期間制限のタイプを取得
	 *
	 * @return 取得量の期間制限のタイプ
	 */
	public String getRestrictionType() {
		return restrictionType;
	}

	/**
	 * 取得量の期間制限のタイプを設定
	 *
	 * @param restrictionType 取得量の期間制限のタイプ
	 */
	public void setRestrictionType(String restrictionType) {
		this.restrictionType = restrictionType;
	}

	/**
	 * 取得量の期間制限のタイプを設定
	 *
	 * @param restrictionType 取得量の期間制限のタイプ
	 * @return this
	 */
	public UpdateGoldRequest withRestrictionType(String restrictionType) {
		setRestrictionType(restrictionType);
		return this;
	}

}