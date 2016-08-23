package com.sendcloud.sdk.model;

import org.apache.commons.lang.StringUtils;

import com.sendcloud.sdk.config.Config;
import com.sendcloud.sdk.exception.ContentException;

/**
 * 文本格式邮件内容
 * 
 * <pre>
 * 需要设置text与content_type
 * </pre>
 * 
 * @author SendCloud
 *
 */
public class TextContent implements Content {

	/**
	 * 不使用模版发送
	 */
	public boolean useTemplate() {
		return false;
	}

	/**
	 * 邮件内容
	 */
	private String text;

	/**
	 * <pre>
	 * 邮件格式：text/html或者text/plain
	 * 
	 * 默认text/html
	 * </pre>
	 */
	private String content_type = "text/html";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getContent_type() {
		return content_type;
	}

	/**
	 * 邮件格式：text/html或者text/plain
	 * 
	 * @param content_type
	 */
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public boolean validate() throws ContentException {
		if (StringUtils.isBlank(text))
			throw new ContentException("邮件内容为空");
		if (!StringUtils.equals(content_type, Config.CONTENT_TYPE_HTML)
				&& !StringUtils.equals(content_type, Config.CONTENT_TYPE_PLAIN))
			throw new ContentException("邮件content type不正确");
		if (text.length() > Config.MAX_CONTENT_SIZE)
			throw new ContentException("邮件内容过长");
		return true;
	}
}