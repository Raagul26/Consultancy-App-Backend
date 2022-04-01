package com.consulting.app.consultingappbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(collection = "jobs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Job {

    @Id
    private String id;

    ///////////////
    @Field("job_id")
    private String jobId;

    @NotBlank(message = "Enter title")
    private String title;

    @NotBlank(message = "Enter overview")
    private String overview;

    @NotEmpty
    private List<String> qualifications;

    @NotBlank(message = "Enter location")
    private String location;

    @NotEmpty
    private List<String> skills;

    @NotEmpty
    private List<String> responsibilities;

    private String status;

    @Field("created_on")
    private String createdOn;

    @Field("last_updated_on")
    private String lastUpdatedOn;

}
