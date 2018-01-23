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
	 * ウォレットの残高を加算します<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public AddToMyWalletResult addToMyWallet(AddToMyWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/self/action/add",
				credential,
				ENDPOINT,
				AddToMyWalletRequest.Constant.MODULE,
				AddToMyWalletRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(post, AddToMyWalletResult.class);

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

	public AddToWalletResult addToWallet(AddToWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/action/add",
				credential,
				ENDPOINT,
				AddToWalletRequest.Constant.MODULE,
				AddToWalletRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(post, AddToWalletResult.class);

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
        if(request.getRestrictionType() != null) body.put("restrictionType", request.getRestrictionType());
        if(request.getResetDayOfMonth() != null) body.put("resetDayOfMonth", request.getResetDayOfMonth());
        if(request.getResetDayOfWeek() != null) body.put("resetDayOfWeek", request.getResetDayOfWeek());
        if(request.getResetHour() != null) body.put("resetHour", request.getResetHour());
        if(request.getPeriodicalLimit() != null) body.put("periodicalLimit", request.getPeriodicalLimit());
        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getCreateWalletTriggerScript() != null) body.put("createWalletTriggerScript", request.getCreateWalletTriggerScript());
        if(request.getCreateWalletDoneTriggerScript() != null) body.put("createWalletDoneTriggerScript", request.getCreateWalletDoneTriggerScript());
        if(request.getAddToWalletTriggerScript() != null) body.put("addToWalletTriggerScript", request.getAddToWalletTriggerScript());
        if(request.getAddToWalletDoneTriggerScript() != null) body.put("addToWalletDoneTriggerScript", request.getAddToWalletDoneTriggerScript());
        if(request.getSubtractFromWalletTriggerScript() != null) body.put("subtractFromWalletTriggerScript", request.getSubtractFromWalletTriggerScript());
        if(request.getSubtractFromWalletDoneTriggerScript() != null) body.put("subtractFromWalletDoneTriggerScript", request.getSubtractFromWalletDoneTriggerScript());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold",
				credential,
				ENDPOINT,
				CreateGoldRequest.Constant.MODULE,
				CreateGoldRequest.Constant.FUNCTION,
				body.toString());


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


		doRequest(delete, null);

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


		return doRequest(get, DescribeServiceClassResult.class);

	}


	/**
	 * ウォレットの一覧を取得します<br>
	 * <br>
	 * - 消費クオータ: 50件あたり5<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void describeWallet(DescribeWalletRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet";

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
				DescribeWalletRequest.Constant.MODULE,
				DescribeWalletRequest.Constant.FUNCTION);

        get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		doRequest(get, null);

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


		return doRequest(get, GetWalletResult.class);

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


		return doRequest(post, ResetLatestGainResult.class);

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

	public SubtractFromMyWalletResult subtractFromMyWallet(SubtractFromMyWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/self/action/subtract",
				credential,
				ENDPOINT,
				SubtractFromMyWalletRequest.Constant.MODULE,
				SubtractFromMyWalletRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(post, SubtractFromMyWalletResult.class);

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

	public SubtractFromWalletResult subtractFromWallet(SubtractFromWalletRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("value", request.getValue());

        if(request.getContext() != null) body.put("context", request.getContext());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "/wallet/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/action/subtract",
				credential,
				ENDPOINT,
				SubtractFromWalletRequest.Constant.MODULE,
				SubtractFromWalletRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(post, SubtractFromWalletResult.class);

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
        if(request.getRestrictionType() != null) body.put("restrictionType", request.getRestrictionType());
        if(request.getResetDayOfMonth() != null) body.put("resetDayOfMonth", request.getResetDayOfMonth());
        if(request.getResetDayOfWeek() != null) body.put("resetDayOfWeek", request.getResetDayOfWeek());
        if(request.getResetHour() != null) body.put("resetHour", request.getResetHour());
        if(request.getPeriodicalLimit() != null) body.put("periodicalLimit", request.getPeriodicalLimit());
        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getCreateWalletTriggerScript() != null) body.put("createWalletTriggerScript", request.getCreateWalletTriggerScript());
        if(request.getCreateWalletDoneTriggerScript() != null) body.put("createWalletDoneTriggerScript", request.getCreateWalletDoneTriggerScript());
        if(request.getAddToWalletTriggerScript() != null) body.put("addToWalletTriggerScript", request.getAddToWalletTriggerScript());
        if(request.getAddToWalletDoneTriggerScript() != null) body.put("addToWalletDoneTriggerScript", request.getAddToWalletDoneTriggerScript());
        if(request.getSubtractFromWalletTriggerScript() != null) body.put("subtractFromWalletTriggerScript", request.getSubtractFromWalletTriggerScript());
        if(request.getSubtractFromWalletDoneTriggerScript() != null) body.put("subtractFromWalletDoneTriggerScript", request.getSubtractFromWalletDoneTriggerScript());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/gold/" + (request.getGoldName() == null || request.getGoldName().equals("") ? "null" : request.getGoldName()) + "",
				credential,
				ENDPOINT,
				UpdateGoldRequest.Constant.MODULE,
				UpdateGoldRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(put, UpdateGoldResult.class);

	}


}