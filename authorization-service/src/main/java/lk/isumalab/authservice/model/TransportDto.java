package lk.isumalab.authservice.model;

import lk.isumalab.authservice.utils.ApiStatus;
import lombok.Data;

@Data
public class TransportDto {

    public TransportDto(ApiStatus error, Object response) {
        this.error = error;
        this.response = response;
    }

    private ApiStatus error;
    private Object response;
}
