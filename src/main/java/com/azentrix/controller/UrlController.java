package com.azentrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import com.azentrix.dto.ShortenRequest;
import com.azentrix.dto.ShortenResponse;
import com.azentrix.dto.StatsResponse;
import com.azentrix.entity.Url;
import com.azentrix.service.UrlService;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ShortenResponse shortenUrl(
            @RequestBody ShortenRequest request) {

        String shortCode =
                urlService.shortenUrl(request.getUrl());

        return new ShortenResponse(
                shortCode,
                "http://localhost:8080/" + shortCode
        );
    }

    @GetMapping("/{code}")
    public RedirectView redirectToOriginalUrl(
            @PathVariable String code) {

        Url url = urlService.getUrlByCode(code);

        if (url == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Short URL not found");
        }

        urlService.incrementClicks(url);

        return new RedirectView(url.getOriginalUrl());
    }
    @GetMapping("/stats/{code}")
    public StatsResponse getStats(@PathVariable String code) {

        Url url = urlService.getUrlByCode(code);

        if (url == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Short URL not found");
        }

        return new StatsResponse(
                url.getOriginalUrl(),
                url.getShortCode(),
                url.getClickCount()
        );
    }
}