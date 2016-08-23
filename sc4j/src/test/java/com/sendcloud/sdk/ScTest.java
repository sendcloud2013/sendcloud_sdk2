package com.sendcloud.sdk;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.config.Credential;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TemplateContent;
import com.sendcloud.sdk.util.ResponseData;

import net.sf.json.JSONObject;

public class ScTest {

	public static void main(String[] args) throws Throwable {
		SendCloud sc = SendCloudBuilder.build();
		
		//创建邮件body
		MailBody body = new MailBody();
		body.setFrom("fangqing@sendcloud.im");
		body.setFromName("张三");
		body.setReplyTo("b@sendcloud.im");
		body.setSubject("测试");
		
//		body.addAttachments(new FileInputStream(new File("D:/workspace/sendcloud/sendcloud/sendcloud-backend/src/main/webapp/img/item/close_16.png")));
		
		//创建收件人
		MailAddressReceiver receiver = new MailAddressReceiver();
		receiver.addTo("37441185@qq.com");
		
		//创建邮件内容
		TemplateContent content = new TemplateContent();
		content.setTemplateInvokeName("kolui");
		
		//创建邮件
		SendCloudMail smail = new SendCloudMail();
		smail.setBody(body);
		smail.setContent(content);
		smail.setTo(receiver);
		
		Credential cr = new Credential("user", "key");

		//发信
		ResponseData result = sc.sendMail(cr, smail);
		System.out.println(JSONObject.fromObject(result).toString());
		
		
	}

}