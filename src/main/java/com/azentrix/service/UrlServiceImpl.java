package com.azentrix.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azentrix.entity.Url;
import com.azentrix.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;
    
    @Override
    public Url getUrlByCode(String code) {
        return urlRepository.findByShortCode(code).orElse(null);
    }

    @Override
    public void incrementClicks(Url url) {
        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);
    }

    @Override
    public String shortenUrl(String url) {

        String shortCode =
                UUID.randomUUID()
                .toString()
                .substring(0, 6);

        Url urlEntity = new Url();

        urlEntity.setOriginalUrl(url);
        urlEntity.setShortCode(shortCode);
        urlEntity.setClickCount(0L);

        urlRepository.save(urlEntity);

        return shortCode;
    }
}