package by.digital.chief.musicHub.dto.respons;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime localDateTime;
    private final String phone = "+378 29 568 455 9";

    public ErrorResponse(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }
}
