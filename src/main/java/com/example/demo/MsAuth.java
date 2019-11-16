package com.example.demo;

import ea.sof.shared.showcases.MsAuthShowcase;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-auth", url = "http://localhost:8888")
public interface MsAuth extends MsAuthShowcase {
}
