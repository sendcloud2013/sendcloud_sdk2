package com.sendcloud.sdk;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.config.Credential;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.exception.SmsException;
import com.sendcloud.sdk.model.SendCloudSms;
import com.sendcloud.sdk.util.ResponseData;

import net.sf.json.JSONObject;

public class SmsTest {

	public static void main(String[] args) throws ClientProtocolException, IOException, SmsException {
		// TODO Auto-generated method stub
		SendCloud sc = SendCloudBuilder.build();
		Credential cr = new Credential("sms user", "sms key");

		SendCloudSms sms = new SendCloudSms();
		sms.setMsgType(0);
		sms.setTemplateId(1);
		sms.addPhone("15527869841");
		sms.addVars("code", "654321");

		ResponseData result = sc.sendSms(cr, sms);

		System.out.println(JSONObject.fromObject(result).toString());
	}

}