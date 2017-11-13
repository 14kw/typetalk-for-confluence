package com.onefourcode.typetalk.components;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;

/**
 * Confluence Bandana manager.
 */
public class ConfigurationManager {
  private BandanaManager bandanaManager;

  public ConfigurationManager(BandanaManager bandanaManager) {
    this.bandanaManager = bandanaManager;
  }

  /**
   * Set inputfield value in Confluence Bandana.
   * 
   * @param spaceKey space key
   * @param webhookUrl Typetalk api endpoint
   */
  public void setSpaceWebhookUrl(String spaceKey, String webhookUrl) {
    bandanaManager.setValue(
        new ConfluenceBandanaContext(spaceKey), 
        ConfigurationOption.WEBHOOK_URL.getBandanaKey(), 
        webhookUrl
    );
  }

  /**
   * Get space setting value from Confluence Bandana.
   * 
   * @param spaceKey space key
   */
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