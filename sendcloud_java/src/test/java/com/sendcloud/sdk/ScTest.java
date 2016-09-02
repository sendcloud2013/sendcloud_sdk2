package com.sendcloud.sdk;

import java.io.File;
import java.io.FileInputStream;

import com.sendcloud.sdk.builder.SendCloudBuilder;
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

		// 创建邮件body
		MailBody body = new MailBody();
		body.setFrom("test@163.com");
		body.setFromName("张三");
		body.setReplyTo("service@qq.com");
		body.setSubject("测试");
		// 创建文件附件
		body.addAttachments(new File("D:/test.txt"));
		// 创建流附件
		body.addAttachments(new FileInputStream(new File("D:/ff.png")));
		// 邮箱收件人
		MailAddressReceiver receiver = new MailAddressReceiver();
		receiver.setBroadcastSend(true);// 广播发送(收件人会全部显示)
		receiver.addTo("1234@qq.com");

		// 地址列表收件人
		// MailListReceiver receiver=new MailListReceiver();
		// 添加邮件地址列表
		// receiver.addMailList("developers@sendcloud.com");

		// 创建模版邮件内容
		TemplateContent content = new TemplateContent();
		content.setTemplateInvokeName("kolui");

		// 创建文本邮件内容
		// TextContent content = new TextContent();
		// content.setContent_type(ScContentType.html);
		// content.setText("hello world");

		// 创建邮件
		SendCloudMail scmail = new SendCloudMail();
		scmail.setBody(body);
		scmail.setContent(content);
		scmail.setTo(receiver);

		// 发信
		ResponseData result = sc.sendMail(scmail);
		System.out.println(JSONObject.fromObject(result).toString());

	}

}