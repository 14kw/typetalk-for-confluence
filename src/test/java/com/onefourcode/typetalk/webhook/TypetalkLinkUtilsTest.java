package com.onefourcode.typetalk.webhook;

import static com.onefourcode.typetalk.webhook.TypetalkLinkUtils.link;
import static com.onefourcode.typetalk.webhook.TypetalkLinkUtils.user;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TypetalkLinkUtilsTest {
  @Test
    public void shouldGenrateHrefsInLinkFormat() {
    assertThat(link("www.foo.com", "Foo"), is("[Foo](www.foo.com)"));
    assertThat(link("www.foo.com"), is("[www.foo.com](www.foo.com)"));
  }

  @Test
    public void shouldGenerateUserHandlesInLinkableFormat() {
    assertThat(user("14kw"), is("@14kw"));
  }

}