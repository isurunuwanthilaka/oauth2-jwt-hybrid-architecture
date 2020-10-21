package lk.isumalab.authservice.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiStatus {

    @JsonIgnore
    private HttpStatus status;
    @JsonIgnore
    private LocalDateTime timestamp;
    private String message;
    @JsonIgnore
    private String debugMessage;

    private ApiStatus() {
        timestamp = LocalDateTime.now();
    }

    public ApiStatus(HttpStatus status) {
        this();
        this.status = status;
        this.message = null;
        this.debugMessage = null;
        timestamp = LocalDateTime.now();
    }


    public ApiStatus(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = null;
        timestamp = LocalDateTime.now();
    }

    public ApiStatus(HttpStatus status, String message, String debugMessage) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage;
        timestamp = LocalDateTime.now();
    }

}