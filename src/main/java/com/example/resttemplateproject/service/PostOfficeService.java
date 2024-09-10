package com.example.resttemplateproject.service;

import com.example.resttemplateproject.response.PostOfficeResponse;

public interface PostOfficeService {
    PostOfficeResponse fetchPostOfficeDetailsByCity(String city);
}
