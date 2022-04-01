package com.consulting.app.consultingappbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "admin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Admin {

    @Field("email_id")
    @NotBlank(message = "Enter email id")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "must be a valid email id")
    private String emailId;

    @NotBlank(message = "Enter password")
    @Size(min = 5, max = 15)
    private String password;

}
