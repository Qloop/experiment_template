package com.upc.model.dto;

/**
 * Created by Qloop on 2017/5/21.
 */
public class ImageUrlsDto {

    private String result;
    private String urls;

    public ImageUrlsDto() {
    }

    public ImageUrlsDto(String result, String urls) {
        this.result = result;
        this.urls = urls;
    }

    public String getResult() {
        return result;
    }

    public String getUrls() {
        return urls;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
