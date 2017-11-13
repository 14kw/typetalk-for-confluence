package com.onefourcode.typetalk.webhook.service;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.onefourcode.typetalk.webhook.TypetalkAttachment;
import com.onefourcode.typetalk.webhook.TypetalkMessage;

import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Post message using Typetalk api. 
 */
public class TypetalkService {
  private final HttpRequestFactory requestFactory;

  /**
   * TypetalkService constructor.
   * 
   * @param proxy HTTP proxy
   */
  public TypetalkService(Proxy proxy) {
    NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
    builder.setProxy(proxy);
    requestFactory = builder.build().createRequestFactory();
  }

  public TypetalkService() {
        this(null);
  }

  /**
   * Create payload message and execute post message action.
   * 
   * @param endpointUrl Typetalk api endpoint
   * @param text message text
   * @param attachments attachment files
   * @throws IOException Incorrect args type
   */
  public void push(String endpointUrl, 
                   TypetalkMessage text, 
                   List<TypetalkAttachment> attachments) throws IOException {
    Map<String, Object> payload = new HashMap<String, Object>();
    if (!attachments.isEmpty()) {
      payload.put("attachments", attachments);
    }
    payload.put("message", text.toString());      
    execute(endpointUrl, payload);
  }

  public void push(String endpointUrl, TypetalkMessage text) throws IOException {
    push(endpointUrl, text, new ArrayList<TypetalkAttachment>());
  }

  /**
   * Post message to Typetalk api.
   * 
   * @param endpointUrl Typetalk api endpoint
   * @param payload message data
   * @throws IOException Incorrect URL or payload format
   */
  public void execute(String endpointUrl, Map<String, Object> payload) throws IOException {
    requestFactory.buildPostRequest(new GenericUrl(endpointUrl), new UrlEncodedContent(payload))
                .execute();
  }
}
