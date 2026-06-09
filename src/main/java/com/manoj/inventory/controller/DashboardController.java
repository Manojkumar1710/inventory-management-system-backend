package com.manoj.inventory.controller;

import com.manoj.inventory.dto.DashboardResponseDto;
import com.manoj.inventory.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponseDto>
    getDashboard() {

        return ResponseEntity.ok(
                dashboardService.getDashboard());
    }
}