package com.idcut.mosmqtt.util;

import java.util.UUID;

public class UniqueId {

    public static Long getLongId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
