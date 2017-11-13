package com.onefourcode.typetalk.webhook;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TypetalkMessageTest {

  @Test
    public void shouldAddNormalText() {
    String normalText = new TypetalkMessage("Hey").toString();
    assertThat(normalText, is("Hey"));
  }

  @Test
    public void shouldAddCodeText() {
    TypetalkMessage message = new TypetalkMessage().text("class ").code("TypetalkText").text(" {}");
    assertThat(message.toString(), is("class `TypetalkText` {}"));
    assertThat(message.rawText(), is("class TypetalkText {}"));
  }

  @Test
    public void shouldAddPreformattedText() {
    TypetalkMessage message = new TypetalkMessage().preformatted("random preformatted text");
    assertThat(message.toString(), is("```random preformatted text```"));
    assertThat(message.rawText(), is("random preformatted text"));
  }

  @Test
    public void shouldAddQuoteText() {
    TypetalkMessage message = new TypetalkMessage().quote("Krishna says ...");
    assertThat(message.toString(), is("\n> Krishna says ...\n"));
    assertThat(message.rawText(), is("Krishna says ..."));
  }

  @Test
    public void shouldAddLinkWithText() {
    TypetalkMessage message = new TypetalkMessage().link("https://14code.com", "14kw");
    assertThat(message.toString(), is("[14kw](https://14code.com)"));
    assertThat(message.rawText(), is("[14kw](https://14code.com)"));
  }


}