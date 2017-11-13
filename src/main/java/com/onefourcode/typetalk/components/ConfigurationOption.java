package com.onefourcode.typetalk.components;

/**
 * Configure Bandana key.
 */
public enum ConfigurationOption {
   WEBHOOK_URL("webhook.url");

  private String suffix;

  private ConfigurationOption(String suffix) {
    this.suffix = suffix;
  }

  public String getBandanaKey() {
    return "typetalk." + suffix;
  }
}
