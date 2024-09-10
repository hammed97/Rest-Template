package com.example.resttemplateproject.controller;


import com.example.resttemplateproject.response.PostOfficeResponse;
import com.example.resttemplateproject.serviceImpl.PostOfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postal")
public class PostDetailsController {

    private final PostOfficeServiceImpl postOfficeService;

    @Autowired
    public PostDetailsController(PostOfficeServiceImpl postOfficeService) {
        this.postOfficeService = postOfficeService;
    }

    @GetMapping(value = "/by-city")
    public PostOfficeResponse getPostalByCity(@RequestParam String city){
        PostOfficeResponse postOfficeResponse;
        postOfficeResponse = postOfficeService.fetchPostOfficeDetailsByCity(city);
        return postOfficeResponse;

    }
}
