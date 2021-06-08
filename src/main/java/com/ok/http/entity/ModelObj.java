package com.ok.http.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Request object sent to model

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelObj {

    private byte[] data;
    private int no;

    // Represents response from Model
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        private String action;
        private String red_detect;
        private String blue_detect;
        private String time_taken;
    }

}
