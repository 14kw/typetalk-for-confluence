package com.onefourcode.typetalk.webhook;

import in.ashwanthkumar.utils.lang.StringUtils;

/**
 * Formatting message.
 */
public class TypetalkMessage {
  private StringBuilder textBuffer = new StringBuilder();

  public TypetalkMessage() {
  }

  public TypetalkMessage(String text) {
    text(text);
  }

  public TypetalkMessage text(String text) {
    textBuffer.append(text);
    return this;
  }

  /**
   * Make link formatting.
   * 
   * @param url link href
   * @param text link text
   */
  public TypetalkMessage link(String url, String text) {
    if (StringUtils.isNotEmpty(text)) {
      textBuffer.append("[").append(text).append("](").append(url).append(")");
    } else {
      textBuffer.append(url);
    }

    return this;
  }

  public TypetalkMessage code(String code) {
    textBuffer.append("`").append(code).append("`");
    return this;
  }

  public TypetalkMessage preformatted(String text) {
    textBuffer.append("```").append(text).append("```");
    return this;
  }

  public TypetalkMessage quote(String text) {
    textBuffer.append("\n> ").append(text).append("\n");
    return this;
  }

  public String toString() {
    return textBuffer.toString();
  }

  /**
   * Remove wiki formatting.
   */
  public String rawText() {
    // We're not removing link because it's readable the way it is.
    return textBuffer.toString()
            .replaceAll("(.*)```(.*)```(.*)", "$1$2$3") // Remove pretext formatting
            .replaceAll("(.*)`(.*)`(.*)", "$1$2$3")     // Remove code formatting
            .replaceAll("\n>\\s+(.*)\n", "$1");         // Remove Quote formatting
  }
}
