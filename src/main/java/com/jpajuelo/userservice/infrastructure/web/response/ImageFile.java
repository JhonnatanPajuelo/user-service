package com.jpajuelo.userservice.infrastructure.web.response;

public class ImageFile {
    private final byte[] content;
    private final String contentType;

    public ImageFile(byte[] content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }
}

