package com.idcut.mosmqtt.constant;

public class MessageDefine {

    /**
     * 消息体内容类型
     */
    public enum PayloadType {
        /**
         * 纯字符串
         */
        STRING,
        /**
         * JSON格式字符串
         */
        JSON,
        /**
         * 平台特定字符串
         */
        PLATFORM
    }

    public enum MessageType {
        /**
         * 系统消息
         */
        SYSTEM,
        /**
         * 聊天室消息
         */
        PUBLICCHAT,
        /**
         * 私聊消息
         */
        PRIVATECHAT
    }
}
