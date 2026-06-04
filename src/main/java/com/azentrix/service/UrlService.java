package com.azentrix.service;

import com.azentrix.entity.Url;

public interface UrlService {

    String shortenUrl(String url);

    Url getUrlByCode(String code);

    void incrementClicks(Url url);
}