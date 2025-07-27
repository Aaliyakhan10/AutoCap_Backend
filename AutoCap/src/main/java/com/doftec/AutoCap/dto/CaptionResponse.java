package com.doftec.AutoCap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptionResponse {
    private String shortCaption;
    private String longCaption;
}
