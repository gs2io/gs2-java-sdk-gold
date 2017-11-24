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
 * ウォレット
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Wallet implements Serializable {

	/** ユーザID */
	private String userId;

	/** 残高 */
	private Integer balance;

	/** 最終更新日時(エポック秒) */
	private Integer updateAt;

	/** 直近の期間の取得量 */
	private Integer latestGain;

	/** 作成日時(エポック秒)

ウォレットは初回の更新処理時に永続化されるため、それまでは取得の都度、作成日時は変化します。
 */
	private Integer createAt;


	/**
	 * ユーザIDを取得
	 *
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザIDを設定
	 *
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 残高を取得
	 *
	 * @return 残高
	 */
	public Integer getBalance() {
		return balance;
	}

	/**
	 * 残高を設定
	 *
	 * @param balance 残高
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
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
	 * 直近の期間の取得量を取得
	 *
	 * @return 直近の期間の取得量
	 */
	public Integer getLatestGain() {
		return latestGain;
	}

	/**
	 * 直近の期間の取得量を設定
	 *
	 * @param latestGain 直近の期間の取得量
	 */
	public void setLatestGain(Integer latestGain) {
		this.latestGain = latestGain;
	}

	/**
	 * 作成日時(エポック秒)

ウォレットは初回の更新処理時に永続化されるため、それまでは取得の都度、作成日時は変化します。
を取得
	 *
	 * @return 作成日時(エポック秒)

ウォレットは初回の更新処理時に永続化されるため、それまでは取得の都度、作成日時は変化します。

	 */
	public Integer getCreateAt() {
		return createAt;
	}

	/**
	 * 作成日時(エポック秒)

ウォレットは初回の更新処理時に永続化されるため、それまでは取得の都度、作成日時は変化します。
を設定
	 *
	 * @param createAt 作成日時(エポック秒)

ウォレットは初回の更新処理時に永続化されるため、それまでは取得の都度、作成日時は変化します。

	 */
	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

}