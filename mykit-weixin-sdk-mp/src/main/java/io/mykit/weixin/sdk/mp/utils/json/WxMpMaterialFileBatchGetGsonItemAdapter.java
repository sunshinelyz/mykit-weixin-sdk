package io.mykit.weixin.sdk.mp.utils.json;

import com.google.gson.*;
import io.mykit.weixin.sdk.common.utils.json.GsonHelper;
import io.mykit.weixin.sdk.mp.bean.material.WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author liuyazhuang
 */
public class WxMpMaterialFileBatchGetGsonItemAdapter implements JsonDeserializer<WxMaterialFileBatchGetNewsItem> {

    @Override
    public WxMaterialFileBatchGetNewsItem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxMaterialFileBatchGetNewsItem newsItem = new WxMaterialFileBatchGetNewsItem();
        JsonObject json = jsonElement.getAsJsonObject();
        if (json.get("media_id") != null && !json.get("media_id").isJsonNull()) {
            newsItem.setMediaId(GsonHelper.getAsString(json.get("media_id")));
        }
        if (json.get("update_time") != null && !json.get("update_time").isJsonNull()) {
            newsItem.setUpdateTime(new Date(1000 * GsonHelper.getAsLong(json.get("update_time"))));
        }
        if (json.get("name") != null && !json.get("name").isJsonNull()) {
            newsItem.setName(GsonHelper.getAsString(json.get("name")));
        }
        if (json.get("url") != null && !json.get("url").isJsonNull()) {
            newsItem.setUrl(GsonHelper.getAsString(json.get("url")));
        }
        return newsItem;
    }
}
