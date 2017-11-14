package com.onefourcode.typetalk.webhook;

import in.ashwanthkumar.utils.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Formatting attachemnt payload.
 */
public class TypetalkAttachment {
  private Map<String, String> attachment = new HashMap<String, String>();

  public TypetalkAttachment() {
  }

  public TypetalkAttachment(String href) {
    fileUrlWithName(href, "");
  }

  public TypetalkAttachment(String href, String text) {
    fileUrlWithName(href, text);
  }

  private TypetalkAttachment fileUrlWithName(String href, String text) {
    attachment.put("fileUrl", href);
    if (StringUtils.isNotEmpty(text)) {
      attachment.put("fileName", text);
    }
    return this;
  }

}
