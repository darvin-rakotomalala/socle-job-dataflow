package com.poc.constraint.factory;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DTFormatter {
    public static Instant etaPlannedSiteToInstant(String stringDate, String timeZone) {
        final DateTimeFormatter etaPlannedFormatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        if (StringUtils.isBlank(timeZone)) {
            return Instant.from(etaPlannedFormatter.withZone(ZoneOffset.UTC).parse(stringDate));
        } else {
            return Instant.from(etaPlannedFormatter.withZone(ZoneId.of(timeZone)).parse(stringDate));
        }
    }
}
