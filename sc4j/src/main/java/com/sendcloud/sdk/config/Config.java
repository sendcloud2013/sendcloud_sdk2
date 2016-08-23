package com.sendcloud.sdk.config;

public class Config {

	public static final String CHARSET = "utf-8";
	public static final String SERVER = "http://www.sendcloud.net";
	public static final String SENDURI = "http://api.sendcloud.net/apiv2/mail/send";
	public static final String SENDTEMPLATEURI = "http://api.sendcloud.net/apiv2/mail/sendtemplate";
	public static final String SENDSMSURI = "http://www.sendcloud.net/smsapi/send";
	public static final String SENDVOICEURI = "http://www.sendcloud.net/smsapi/sendVoice";
	
	public static int CONNECTION_TIMEOUT = 30 * 1000;
	public static final int MAX_RECEIVERS = 100;
	public static final int MAX_MAILLIST = 5;
	public static final int MAX_CONTENT_SIZE = 1024 * 1024;
	public static final String CONTENT_TYPE_HTML = "text/html";
	public static final String CONTENT_TYPE_PLAIN = "text/plain";
}