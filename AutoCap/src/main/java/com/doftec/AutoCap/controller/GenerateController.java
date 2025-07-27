package com.doftec.AutoCap.controller;

import com.doftec.AutoCap.dto.CaptionResponse;
import com.doftec.AutoCap.dto.GenerateCaptionRequest;
import com.doftec.AutoCap.services.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GenerateController {
    @Autowired
    private GenerateService generateService;
    @PostMapping("/caption-generator")
    public CaptionResponse genCap(@RequestBody GenerateCaptionRequest request){
       return generateService.callApi(request.getImgUrl());

  }
}
