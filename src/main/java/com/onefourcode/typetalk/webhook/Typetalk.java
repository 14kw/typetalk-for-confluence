package com.onefourcode.typetalk.webhook;

import com.onefourcode.typetalk.webhook.service.TypetalkService;
import in.ashwanthkumar.utils.collections.Lists;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static in.ashwanthkumar.utils.lang.StringUtils.isEmpty;


/**
 * Typetalk provides programmatic access to Typetalk api
 */
public class Typetalk {
  private String endpointUrl;
  private TypetalkService typetalkService;

  public Typetalk(String endpointUrl, Proxy proxy) {
    if (isEmpty(endpointUrl)) {
      throw new IllegalArgumentException("Endpoint url is not provided");
    }
    this.endpointUrl = endpointUrl;
    this.typetalkService = new TypetalkService(proxy);
  }

  public Typetalk(String endpointUrl) {
        this(endpointUrl, (Proxy) null);
  }

  public Typetalk(String endpointUrl, String hostname, int port) {
        this(endpointUrl, new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port)));
  }

  /**
   * Used for tests
   */
  Typetalk(String endpointUrl, TypetalkService mockService) {
    this.endpointUrl = endpointUrl;
    typetalkService = mockService;
  }

  /**
   * Update the webhook url of the underlying Typetalk service
   * @param endpointUrl
   * @return
   */
  public Typetalk setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

  /**
   * Publishes messages to Typetalk Endpoint
   *
   * @param message Message to send
   * @throws IOException
   */
  public void push(TypetalkMessage message) throws IOException {
    if (message != null) {
      typetalkService.push(endpointUrl, message);
    }
  }

  /**
   * Publish message as TypetalkAttachment
   *
   * @param attachment TypetalkAttachment to send
   * @throws IOException
   */
  public void push(TypetalkAttachment attachment) throws IOException {
    if (attachment != null) {
      typetalkService.push(endpointUrl, new TypetalkMessage(), Lists.of(attachment));
    }
  }

  /**
   * Publish message as TypetalkAttachment
   *
   * @param attachments TypetalkAttachment to send
   * @throws IOException
   */
  public void push(List<TypetalkAttachment> attachments) throws IOException {
    if (!attachments.isEmpty()) {
      typetalkService.push(endpointUrl, new TypetalkMessage(), attachments);
    }
  }

  /**
   * Publish message to Typetalk Endpoint with Attachment
   *
   * @param message Message to send
   * @param attachment TypetalkAttachment to send
   * @throws IOException
   */
  public void push(TypetalkMessage message, 
                   TypetalkAttachment attachment) throws IOException {
    if (message != null && attachment != null) {
      typetalkService.push(endpointUrl, message, Lists.of(attachment));
    }
  }

  /**
   * Publish message to Typetalk Endpoint with Attachments
   *
   * @param message Message to send
   * @param attachments TypetalkAttachment to send
   * @throws IOException
   */
  public void push(TypetalkMessage message, 
                   List<TypetalkAttachment> attachments) throws IOException {
    if (message != null && !attachments.isEmpty()) {
      typetalkService.push(endpointUrl, message, attachments);
    }
  }
}
