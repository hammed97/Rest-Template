package com.example.resttemplateproject.serviceImpl;

import com.example.resttemplateproject.model.PostOfficeDetails;
import com.example.resttemplateproject.response.PostOfficeResponse;
import com.example.resttemplateproject.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {


    private final RestTemplate restTemplate;

    @Autowired
    public PostOfficeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PostOfficeResponse fetchPostOfficeDetailsByCity(String cityValue) {

        String url ="https://api.postalpincode.in/postoffice/{city}";
        url = url.replace("{city}", cityValue);
        System.out.println("Url is : " + url);

        ResponseEntity<PostOfficeResponse[]> postalResponseEntity =
        restTemplate.getForEntity(url, PostOfficeResponse[].class);

        System.out.println("Response Status Code is : " + postalResponseEntity.getStatusCodeValue());

        PostOfficeResponse[] responseArray = postalResponseEntity.getBody();

        for (PostOfficeResponse responseBean : responseArray){
            List<PostOfficeDetails> postOffficeList = responseBean.getPostOffice();
            for (PostOfficeDetails pob : postOffficeList){
                System.out.println(pob.getName() + " *******" + pob.getCountry() + " ******" + pob.getPinCode());
            }
        }
        return responseArray[0];
    }
}
