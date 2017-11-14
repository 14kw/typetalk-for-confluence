package com.onefourcode.typetalk.webhook;

/**
 * Formatting link in message.
 */
public class TypetalkLinkUtils {
  public static String link(String href) {
    return link(href, href);
  }

  public static String link(String href, String name) {
    return String.format("[%s](%s)", name, href);
  }

  public static String user(String handle) {
    return String.format("@%s", handle);
  }

}
