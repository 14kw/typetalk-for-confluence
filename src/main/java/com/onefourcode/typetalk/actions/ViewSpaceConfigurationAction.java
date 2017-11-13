package com.onefourcode.typetalk.actions;

import com.atlassian.confluence.spaces.actions.AbstractSpaceAdminAction;
import com.onefourcode.typetalk.components.ConfigurationManager;
import com.opensymphony.xwork.Action;

public final class ViewSpaceConfigurationAction extends AbstractSpaceAdminAction {
   private static final long          serialVersionUID = 5691912273454934901L;

   private final ConfigurationManager configurationManager;
   private String                     webhookUrl;
   private boolean                    successFullUpdate;

   public ViewSpaceConfigurationAction(ConfigurationManager configurationManager) {
      this.configurationManager = configurationManager;
   }

   public void setResult(String result) {
      if ("success".equals(result)) {
         successFullUpdate = true;
      }
   }

   @Override
   public String execute() {
      setWebhookUrl(configurationManager.getSpaceWebhookUrl(key));
      return Action.SUCCESS;
   }

   public void setWebhookUrl(String webhookUrl) {
      this.webhookUrl = webhookUrl;
   }

   public String getWebhookUrl() {
      return webhookUrl;
   }

   public boolean isSuccessFullUpdate() {
      return successFullUpdate;
   }
}