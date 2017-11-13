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

public class TypetalkService {
  private final HttpRequestFactory requestFactory;

  public TypetalkService(Proxy proxy) {
    NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
    builder.setProxy(proxy);
    requestFactory = builder.build().createRequestFactory();
  }

  public TypetalkService() {
        this(null);
  }

  public void push(String endpointUrl, TypetalkMessage text, List<TypetalkAttachment> attachments) throws IOException {
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

  public void execute(String endpointUrl, Map<String, Object> payload) throws IOException {
    requestFactory.buildPostRequest(new GenericUrl(endpointUrl), new UrlEncodedContent(payload))
                .execute();
  }
}
