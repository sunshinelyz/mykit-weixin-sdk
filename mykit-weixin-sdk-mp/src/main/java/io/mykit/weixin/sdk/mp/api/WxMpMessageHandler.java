package io.mykit.weixin.sdk.mp.api;

import io.mykit.weixin.sdk.common.error.WxErrorException;
import io.mykit.weixin.sdk.common.session.WxSessionManager;
import io.mykit.weixin.sdk.mp.bean.message.WxMpXmlMessage;
import io.mykit.weixin.sdk.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

/**
 * 处理微信推送消息的处理器接口
 *
 * @author liuyazhuang
 */
public interface WxMpMessageHandler {

  /**
   * @param wxMessage
   * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
   * @param wxMpService
   * @param sessionManager
   * @return xml格式的消息，如果在异步规则里处理的话，可以返回null
   */
  WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                           Map<String, Object> context,
                           WxMpService wxMpService,
                           WxSessionManager sessionManager) throws WxErrorException;

}
