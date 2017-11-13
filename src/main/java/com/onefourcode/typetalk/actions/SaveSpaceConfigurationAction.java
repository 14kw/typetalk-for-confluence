package com.onefourcode.typetalk.actions;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.security.SpacePermission;
import com.atlassian.confluence.spaces.SpaceManager;
import com.atlassian.xwork.RequireSecurityToken;
import com.onefourcode.typetalk.components.ConfigurationManager;
import com.opensymphony.xwork.Action;

public class SaveSpaceConfigurationAction extends ConfluenceActionSupport {
  private static final Logger  LOGGER = LoggerFactory.getLogger(SaveSpaceConfigurationAction.class);
  private static final long    serialVersionUID = -3368277537107958205L;

  private ConfigurationManager configurationManager;
  private SpaceManager         spaceManager;

  private String               key;
  private String               webhookUrl;

  @Override
   public void validate() {
    super.validate();

    if (StringUtils.isBlank(key) || spaceManager.getSpace(key) == null) {
      addActionError(getText("typetalk.spaceconfig.spacekeyerror"));
    }
  }

  @Override
   public boolean isPermitted() {
    return spacePermissionManager.hasPermissionForSpace(
      getAuthenticatedUser(), 
      Arrays.asList(SpacePermission.ADMINISTER_SPACE_PERMISSION), 
      spaceManager.getSpace(key)
    );
  }

  @Override
  @RequireSecurityToken(true)
   public String execute() throws Exception {
    try {
      configurationManager.setSpaceWebhookUrl(key, webhookUrl);
    } catch (NullPointerException e) {
      LOGGER.error("Error when save webhook url", e);
    }
      
    return Action.SUCCESS;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }

  public void setConfigurationManager(ConfigurationManager configurationManager) {
    this.configurationManager = configurationManager;
  }

  public void setSpaceManager(SpaceManager spaceManager) {
    this.spaceManager = spaceManager;
  }

}