package com.azentrix.dto;

public class StatsResponse {

    private String originalUrl;
    private String shortCode;
    private Long clickCount;

    public StatsResponse(String originalUrl, String shortCode, Long clickCount) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.clickCount = clickCount;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Long getClickCount() {
        return clickCount;
    }
}