package com.healthcare.gateway.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Circuit-breaker fallback: returned with HTTP 503 when a downstream service
 * is unavailable and the gateway circuit is open.
 */
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping
    public ResponseEntity<Map<String, Object>> fallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of(
                "success", false,
                "message", "Service temporarily unavailable. Please retry shortly.",
                "timestamp", LocalDateTime.now().toString()));
    }
}
