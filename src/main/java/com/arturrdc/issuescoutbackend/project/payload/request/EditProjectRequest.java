package com.arturrdc.issuescoutbackend.project.payload.request;

import jakarta.validation.constraints.NotBlank;

public class EditProjectRequest {
    @NotBlank
    public String name;
    @NotBlank
    public String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
