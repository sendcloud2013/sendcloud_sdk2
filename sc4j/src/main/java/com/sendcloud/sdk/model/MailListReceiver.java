package com.sendcloud.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.sendcloud.sdk.config.Config;
import com.sendcloud.sdk.exception.ReceiverException;

/**
 * 邮件列表收件人
 * 
 * @author SendCloud
 *
 */
public class MailListReceiver implements Receiver {

	public boolean useAddressList() {
		return true;
	}

	/**
	 * 地址列表
	 */
	private List<String> mailList = new ArrayList<String>();

	public List<String> getMailList() {
		return mailList;
	}

	public void addMailList(String maillist) {
		mailList.add(maillist);
	}

	public boolean validate() throws ReceiverException {
		if (CollectionUtils.isEmpty(mailList))
			throw new ReceiverException("地址列表为空");
		if (mailList.size() > Config.MAX_MAILLIST)
			throw new ReceiverException("地址列表超过上限");
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String address : mailList) {
			if (sb.length() > 0)
				sb.append(";");
			sb.append(address);
		}
		return sb.toString();
	}
}