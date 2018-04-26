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
 * ウォレット設定
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class WalletSettings implements Serializable {

	/** 各ウォレットの残高の最大値 */
	private Long balanceMax;

	/** 取得量の期間制限のタイプ */
	private String resetType;

	/** 期間内の取得量をリセットする日にち */
	private Integer resetDayOfMonth;

	/** 期間内の取得量をリセットする曜日 */
	private String resetDayOfWeek;

	/** 期間内の取得量をリセットする時 */
	private Integer resetHour;

	/** 期間内の最大取得量 */
	private Long latestGainMax;

	/** 作成日時(エポック秒) */
	private Integer createAt;

	/** 最終更新日時(エポック秒) */
	private Integer updateAt;


	/**
	 * 各ウォレットの残高の最大値を取得
	 *
	 * @return 各ウォレットの残高の最大値
	 */
	public Long getBalanceMax() {
		return balanceMax;
	}

	/**
	 * 各ウォレットの残高の最大値を設定
	 *
	 * @param balanceMax 各ウォレットの残高の最大値
	 */
	public void setBalanceMax(Long balanceMax) {
		this.balanceMax = balanceMax;
	}

	/**
	 * 取得量の期間制限のタイプを取得
	 *
	 * @return 取得量の期間制限のタイプ
	 */
	public String getResetType() {
		return resetType;
	}

	/**
	 * 取得量の期間制限のタイプを設定
	 *
	 * @param resetType 取得量の期間制限のタイプ
	 */
	public void setResetType(String resetType) {
		this.resetType = resetType;
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
	 * 期間内の最大取得量を取得
	 *
	 * @return 期間内の最大取得量
	 */
	public Long getLatestGainMax() {
		return latestGainMax;
	}

	/**
	 * 期間内の最大取得量を設定
	 *
	 * @param latestGainMax 期間内の最大取得量
	 */
	public void setLatestGainMax(Long latestGainMax) {
		this.latestGainMax = latestGainMax;
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

}