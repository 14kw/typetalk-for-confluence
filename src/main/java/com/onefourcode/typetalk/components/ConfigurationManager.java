package com.onefourcode.typetalk.components;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;

public class ConfigurationManager {
  private BandanaManager bandanaManager;

  public ConfigurationManager(BandanaManager bandanaManager) {
    this.bandanaManager = bandanaManager;
  }

  public void setSpaceWebhookUrl(String spaceKey, String webhookUrl) {
    bandanaManager.setValue(
        new ConfluenceBandanaContext(spaceKey), 
        ConfigurationOption.WEBHOOK_URL.getBandanaKey(), 
        webhookUrl
    );
  }

  public String getSpaceWebhookUrl(String spaceKey) {
    return getBandanaValue(
             new ConfluenceBandanaContext(spaceKey), 
             ConfigurationOption.WEBHOOK_URL
           );
  }

  private String getBandanaValue(BandanaContext bandanaContext, 
                                 ConfigurationOption configurationOption) {
    Object fromBandana = bandanaManager.getValue(
                           bandanaContext, 
                           configurationOption.getBandanaKey()
                         );
    if (fromBandana == null) {
      return "";
    }
    return fromBandana.toString();
  }

}