package com.doftec.AutoCap.controller;

import com.doftec.AutoCap.dto.CaptionResponse;
import com.doftec.AutoCap.dto.GenerateCaptionRequest;
import com.doftec.AutoCap.services.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
