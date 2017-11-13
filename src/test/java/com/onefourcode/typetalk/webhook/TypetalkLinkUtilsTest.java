package com.onefourcode.typetalk.webhook;

import org.junit.Test;

import static com.onefourcode.typetalk.webhook.TypetalkLinkUtils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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