package io.mykit.weixin.sdk.mp.builder.outxml;

import io.mykit.weixin.sdk.mp.bean.message.WxMpXmlOutNewsMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图文消息builder
 *
 * @author liuyazhuang
 */
public final class NewsBuilder extends BaseBuilder<NewsBuilder, WxMpXmlOutNewsMessage> {
  private List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();

  public NewsBuilder addArticle(WxMpXmlOutNewsMessage.Item... items) {
    Collections.addAll(this.articles, items);
    return this;
  }

  public NewsBuilder articles(List<WxMpXmlOutNewsMessage.Item> articles){
    this.articles = articles;
    return this;
  }

  @Override
  public WxMpXmlOutNewsMessage build() {
    WxMpXmlOutNewsMessage m = new WxMpXmlOutNewsMessage();
    for (WxMpXmlOutNewsMessage.Item item : this.articles) {
      m.addArticle(item);
    }
    setCommon(m);
    return m;
  }

}
