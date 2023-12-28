package com.ms.usermicrosrevice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailDto {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
