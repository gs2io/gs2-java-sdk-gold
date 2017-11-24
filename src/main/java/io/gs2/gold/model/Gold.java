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

package io.gs2.gold.model;

import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ゴールド
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Gold implements Serializable {

	/** 取得量の期間制限のタイプ */
	private String restrictionType;

	/** ゴールド名 */
	private String name;

	/** 期間内の取得量をリセットする時

restrictionType が monthly, weekly, daily のときに指定してください。
0 〜 23 で指定し、 UTC として解釈されます。
 */
	private Integer resetHour;

	/** サービスクラス */
	private String serviceClass;

	/** 各ウォレットの残高の最大値 */
	private Integer balanceMax;

	/** ゴールドGRN */
	private String goldId;

	/** 期間内の最大取得量

指定しなかった場合は 99999999 として扱われます。
 */
	private Integer periodicalLimit;

	/** 作成日時(エポック秒) */
	private Integer createAt;

	/** 期間内の取得量をリセットする日にち

restrictionType が monthly のときに指定してください。
月末日を超える値を指定した場合、月末日に丸められます。
 */
	private Integer resetDayOfMonth;

	/** 期間内の取得量をリセットする曜日

restrictionType が weekly のときに指定してください。
 */
	private String resetDayOfWeek;

	/** オーナーID */
	private String ownerId;

	/** 最終更新日時(エポック秒) */
	private Integer updateAt;

	/** 通知先 URL */
	private String notificationUrl;

	/** 説明文 */
	private String description;


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
	 * ゴールド名を取得
	 *
	 * @return ゴールド名
	 */
	public String getName() {
		return name;
	}

	/**
	 * ゴールド名を設定
	 *
	 * @param name ゴールド名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 期間内の取得量をリセットする時

restrictionType が monthly, weekly, daily のときに指定してください。
0 〜 23 で指定し、 UTC として解釈されます。
を取得
	 *
	 * @return 期間内の取得量をリセットする時

restrictionType が monthly, weekly, daily のときに指定してください。
0 〜 23 で指定し、 UTC として解釈されます。

	 */
	public Integer getResetHour() {
		return resetHour;
	}

	/**
	 * 期間内の取得量をリセットする時

restrictionType が monthly, weekly, daily のときに指定してください。
0 〜 23 で指定し、 UTC として解釈されます。
を設定
	 *
	 * @param resetHour 期間内の取得量をリセットする時

restrictionType が monthly, weekly, daily のときに指定してください。
0 〜 23 で指定し、 UTC として解釈されます。

	 */
	public void setResetHour(Integer resetHour) {
		this.resetHour = resetHour;
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
	 * ゴールドGRNを取得
	 *
	 * @return ゴールドGRN
	 */
	public String getGoldId() {
		return goldId;
	}

	/**
	 * ゴールドGRNを設定
	 *
	 * @param goldId ゴールドGRN
	 */
	public void setGoldId(String goldId) {
		this.goldId = goldId;
	}

	/**
	 * 期間内の最大取得量

指定しなかった場合は 99999999 として扱われます。
を取得
	 *
	 * @return 期間内の最大取得量

指定しなかった場合は 99999999 として扱われます。

	 */
	public Integer getPeriodicalLimit() {
		return periodicalLimit;
	}

	/**
	 * 期間内の最大取得量

指定しなかった場合は 99999999 として扱われます。
を設定
	 *
	 * @param periodicalLimit 期間内の最大取得量

指定しなかった場合は 99999999 として扱われます。

	 */
	public void setPeriodicalLimit(Integer periodicalLimit) {
		this.periodicalLimit = periodicalLimit;
	}

	/**
	 * 作成日時(エポック秒)を取得
	 *
	 * @return 作成日時(エポック秒)
	 */
	public Integer getCreateAt() {
		return createAt;
	}

	/**
	 * 作成日時(エポック秒)を設定
	 *
	 * @param createAt 作成日時(エポック秒)
	 */
	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

	/**
	 * 期間内の取得量をリセットする日にち

restrictionType が monthly のときに指定してください。
月末日を超える値を指定した場合、月末日に丸められます。
を取得
	 *
	 * @return 期間内の取得量をリセットする日にち

restrictionType が monthly のときに指定してください。
月末日を超える値を指定した場合、月末日に丸められます。

	 */
	public Integer getResetDayOfMonth() {
		return resetDayOfMonth;
	}

	/**
	 * 期間内の取得量をリセットする日にち

restrictionType が monthly のときに指定してください。
月末日を超える値を指定した場合、月末日に丸められます。
を設定
	 *
	 * @param resetDayOfMonth 期間内の取得量をリセットする日にち

restrictionType が monthly のときに指定してください。
月末日を超える値を指定した場合、月末日に丸められます。

	 */
	public void setResetDayOfMonth(Integer resetDayOfMonth) {
		this.resetDayOfMonth = resetDayOfMonth;
	}

	/**
	 * 期間内の取得量をリセットする曜日

restrictionType が weekly のときに指定してください。
を取得
	 *
	 * @return 期間内の取得量をリセットする曜日

restrictionType が weekly のときに指定してください。

	 */
	public String getResetDayOfWeek() {
		return resetDayOfWeek;
	}

	/**
	 * 期間内の取得量をリセットする曜日

restrictionType が weekly のときに指定してください。
を設定
	 *
	 * @param resetDayOfWeek 期間内の取得量をリセットする曜日

restrictionType が weekly のときに指定してください。

	 */
	public void setResetDayOfWeek(String resetDayOfWeek) {
		this.resetDayOfWeek = resetDayOfWeek;
	}

	/**
	 * オーナーIDを取得
	 *
	 * @return オーナーID
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * オーナーIDを設定
	 *
	 * @param ownerId オーナーID
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * 最終更新日時(エポック秒)を取得
	 *
	 * @return 最終更新日時(エポック秒)
	 */
	public Integer getUpdateAt() {
		return updateAt;
	}

	/**
	 * 最終更新日時(エポック秒)を設定
	 *
	 * @param updateAt 最終更新日時(エポック秒)
	 */
	public void setUpdateAt(Integer updateAt) {
		this.updateAt = updateAt;
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

}