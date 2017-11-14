package com.onefourcode.typetalk.webhook;

import static org.mockito.Mockito.mock;

import com.onefourcode.typetalk.webhook.service.TypetalkService;

import org.junit.Test;

public class TypetalkTest {

  TypetalkService typetalkService = mock(TypetalkService.class);

  @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegaArgumentExceptionWhenWebHookUrlIsNotGiven() {
    new Typetalk(null);
  }

}