package io.mykit.weixin.sdk.mp.bean;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author liuyazhuang
 */
@Data
public class WxMpShakeQuery implements Serializable {
  private static final long serialVersionUID = 4316527352035275412L;

  private String ticket;

  private int needPoi;

  public String toJsonString() {
    Map<String, Object> map = new HashMap<>();
    map.put("ticket", this.ticket);
    map.put("need_poi", this.needPoi);
    return new Gson().toJson(map);
  }

}
