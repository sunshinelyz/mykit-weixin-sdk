package io.mykit.weixin.sdk.mp.utils.json;

import com.google.gson.*;
import io.mykit.weixin.sdk.common.utils.json.GsonHelper;
import io.mykit.weixin.sdk.mp.bean.material.WxMpMaterialNews;
import io.mykit.weixin.sdk.mp.bean.material.WxMpMaterialNewsBatchGetResult;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author liuyazhuang
 */
public class WxMpMaterialNewsBatchGetGsonItemAdapter implements JsonDeserializer<WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem> {

    @Override
    public WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem wxMaterialNewsBatchGetNewsItem = new WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem();
        JsonObject json = jsonElement.getAsJsonObject();
        if (json.get("media_id") != null && !json.get("media_id").isJsonNull()) {
            wxMaterialNewsBatchGetNewsItem.setMediaId(GsonHelper.getAsString(json.get("media_id")));
        }
        if (json.get("update_time") != null && !json.get("update_time").isJsonNull()) {
            wxMaterialNewsBatchGetNewsItem.setUpdateTime(new Date(1000 * GsonHelper.getAsLong(json.get("update_time"))));
        }
        if (json.get("content") != null && !json.get("content").isJsonNull()) {
            JsonObject newsItem = json.getAsJsonObject("content");
            wxMaterialNewsBatchGetNewsItem.setContent(WxMpGsonBuilder.create().fromJson(newsItem, WxMpMaterialNews.class));
        }
        return wxMaterialNewsBatchGetNewsItem;
    }
}
