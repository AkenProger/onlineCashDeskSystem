package kg.store.storeRestApi.models;

import lombok.Data;

@Data
public class RestResponse {
    private int statusCode;
    private String message;
    private Object data;

    public RestResponse(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
