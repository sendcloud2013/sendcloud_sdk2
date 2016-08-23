package com.sendcloud.sdk.builder;

import com.sendcloud.sdk.config.Config;
import com.sendcloud.sdk.core.SendCloud;

public class SendCloudBuilder {

	public static SendCloud build() {
		SendCloud sc = new SendCloud();
		sc.setServer(Config.SERVER);
		sc.setMailAPI(Config.SENDURI);
		sc.setTemplateAPI(Config.SENDTEMPLATEURI);
		sc.setSmsAPI(Config.SENDSMSURI);
		sc.setVoiceAPI(Config.SENDVOICEURI);
		return sc;
	}
}