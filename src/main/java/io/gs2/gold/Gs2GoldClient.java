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

package io.gs2.gold;

import java.util.ArrayList;
import java.util.List;

import io.gs2.util.EncodingUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.gs2.AbstractGs2Client;
import io.gs2.Gs2Constant;
import io.gs2.model.IGs2Credential;
import io.gs2.gold.control.*;

/**
 * GS2 Gold API クライアント
 *
 * @author Game Server Services, Inc.
 *
 */
public class Gs2GoldClient extends AbstractGs2Client<Gs2GoldClient> {

	public static String ENDPOINT = "gold";

	/**
	 * コンストラクタ。
	 *
	 * @param credential 認証情報
	 */
	public Gs2GoldClient(IGs2Credential credential) {
		super(credential);
	}


	/**
	 * ゴールドを新規作成します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public CreateGoldResult createGold(CreateGoldRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("name", request.getName())
				.put("serviceClass", request.getServiceClass());

        if(request.getDescription() != null) body.put("description", request.getDescription());
        if(request.getBalanceMax() != null) body.put("balanceMax", request.getBalanceMax());
        if(request.getResetType() != null) body.put("resetType", request.getResetType());
        if(request.getResetDayOfMonth() != null) body.put("resetDayOfMonth", request.getResetDayOfMonth());
        if(request.getResetDayOfWeek() != null) body.put("resetDayOfWeek", request.getResetDayOfWeek());
        if(request.getResetHour() != null) body.put("resetHour", request.getResetHour());
        if(request.getLatestGainMax() != null) body.put("latestGainMax", request.getLatestGainMax());
        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getCreateWalletTriggerScript() != null) body.put("createWalletTriggerScript", request.getCreateWalletTriggerScript());
        if(request.getCreateWalletDoneTriggerScript() != null) body.put("createWalletDoneTriggerScript", request.getCreateWalletDoneTriggerScript());
        if(request.getDepositIntoWalletTriggerScript() != null) body.put("depositIntoWalletTriggerScript", request.getDepositIntoWalletTriggerScript());
        if(request.getDepositIntoWalletDoneTriggerScript() != null) body.put("depositIntoWalletDoneTriggerScript", request.getDepositIntoWalletDoneTriggerScript());
        if(request.getWithdrawFromWalletTriggerScript() != null) body.put("withdrawFromWalletTriggerScript", request.getWithdrawFromWalletTriggerScript());
        if(request.getWithdrawFromWalletDoneTriggerScript() != null) body.put("withdrawFromWalletDoneTriggerScript", request.getWithdrawFromWalletDoneTriggerScript());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold",
				credential,
				ENDPOINT,
				CreateGoldRequest.Constant.MODULE,
				CreateGoldRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(post, CreateGoldResult.class);

	}


	/**
	 * ゴールドを削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void deleteGold(DeleteGoldRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				DeleteGoldRequest.Constant.MODULE,
				DeleteGoldRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            delete.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		doRequest(delete, null);

	}


	/**
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DepositIntoMyWalletResult depositIntoMyWallet(DepositIntoMyWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/self/action/deposit",
				credential,
				ENDPOINT,
				DepositIntoMyWalletRequest.Constant.MODULE,
				DepositIntoMyWalletRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(post, DepositIntoMyWalletResult.class);

	}


	/**
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DepositIntoWalletResult depositIntoWallet(DepositIntoWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/action/deposit",
				credential,
				ENDPOINT,
				DepositIntoWalletRequest.Constant.MODULE,
				DepositIntoWalletRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(post, DepositIntoWalletResult.class);

	}


	/**
	 * ゴールドの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DescribeGoldResult describeGold(DescribeGoldRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeGoldRequest.Constant.MODULE,
				DescribeGoldRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, DescribeGoldResult.class);

	}


	/**
	 * サービスクラスの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DescribeServiceClassResult describeServiceClass(DescribeServiceClassRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/serviceClass";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeServiceClassRequest.Constant.MODULE,
				DescribeServiceClassRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, DescribeServiceClassResult.class);

	}


	/**
	 * ゴールドを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetGoldResult getGold(GetGoldRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetGoldRequest.Constant.MODULE,
				GetGoldRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, GetGoldResult.class);

	}


	/**
	 * ゴールドの状態を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetGoldStatusResult getGoldStatus(GetGoldStatusRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/status";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetGoldStatusRequest.Constant.MODULE,
				GetGoldStatusRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, GetGoldStatusResult.class);

	}


	/**
	 * ウォレットを取得します<br>
	 * <br>
	 * - 消費クオータ: 5<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetMyWalletResult getMyWallet(GetMyWalletRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/self";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetMyWalletRequest.Constant.MODULE,
				GetMyWalletRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }

        get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(get, GetMyWalletResult.class);

	}


	/**
	 * ウォレットを取得します<br>
	 * <br>
	 * - 消費クオータ: 5<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetWalletResult getWallet(GetWalletRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetWalletRequest.Constant.MODULE,
				GetWalletRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, GetWalletResult.class);

	}


	/**
	 * ウォレットの設定を取得します<br>
	 * <br>
	 * - 消費クオータ: 5<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetWalletSettingsResult getWalletSettings(GetWalletSettingsRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/settings";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetWalletSettingsRequest.Constant.MODULE,
				GetWalletSettingsRequest.Constant.FUNCTION);
        if(request.getRequestId() != null) {
            get.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(get, GetWalletSettingsResult.class);

	}


	/**
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public ResetLatestGainResult resetLatestGain(ResetLatestGainRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/action/reset",
				credential,
				ENDPOINT,
				ResetLatestGainRequest.Constant.MODULE,
				ResetLatestGainRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(post, ResetLatestGainResult.class);

	}


	/**
	 * ゴールドを更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public UpdateGoldResult updateGold(UpdateGoldRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("serviceClass", request.getServiceClass());

        if(request.getDescription() != null) body.put("description", request.getDescription());
        if(request.getBalanceMax() != null) body.put("balanceMax", request.getBalanceMax());
        if(request.getResetType() != null) body.put("resetType", request.getResetType());
        if(request.getResetDayOfMonth() != null) body.put("resetDayOfMonth", request.getResetDayOfMonth());
        if(request.getResetDayOfWeek() != null) body.put("resetDayOfWeek", request.getResetDayOfWeek());
        if(request.getResetHour() != null) body.put("resetHour", request.getResetHour());
        if(request.getLatestGainMax() != null) body.put("latestGainMax", request.getLatestGainMax());
        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getCreateWalletTriggerScript() != null) body.put("createWalletTriggerScript", request.getCreateWalletTriggerScript());
        if(request.getCreateWalletDoneTriggerScript() != null) body.put("createWalletDoneTriggerScript", request.getCreateWalletDoneTriggerScript());
        if(request.getDepositIntoWalletTriggerScript() != null) body.put("depositIntoWalletTriggerScript", request.getDepositIntoWalletTriggerScript());
        if(request.getDepositIntoWalletDoneTriggerScript() != null) body.put("depositIntoWalletDoneTriggerScript", request.getDepositIntoWalletDoneTriggerScript());
        if(request.getWithdrawFromWalletTriggerScript() != null) body.put("withdrawFromWalletTriggerScript", request.getWithdrawFromWalletTriggerScript());
        if(request.getWithdrawFromWalletDoneTriggerScript() != null) body.put("withdrawFromWalletDoneTriggerScript", request.getWithdrawFromWalletDoneTriggerScript());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "",
				credential,
				ENDPOINT,
				UpdateGoldRequest.Constant.MODULE,
				UpdateGoldRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            put.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(put, UpdateGoldResult.class);

	}


	/**
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public WithdrawFromMyWalletResult withdrawFromMyWallet(WithdrawFromMyWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/self/action/withdraw",
				credential,
				ENDPOINT,
				WithdrawFromMyWalletRequest.Constant.MODULE,
				WithdrawFromMyWalletRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(post, WithdrawFromMyWalletResult.class);

	}


	/**
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public WithdrawFromWalletResult withdrawFromWallet(WithdrawFromWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/action/withdraw",
				credential,
				ENDPOINT,
				WithdrawFromWalletRequest.Constant.MODULE,
				WithdrawFromWalletRequest.Constant.FUNCTION,
				body.toString());
        if(request.getRequestId() != null) {
            post.setHeader("X-GS2-REQUEST-ID", request.getRequestId());
        }


		return doRequest(post, WithdrawFromWalletResult.class);

	}


}