package com.example.fabrikaline_backend.DTO;

public class LabelValueObject {

    public String label;
    public Integer value;

    public LabelValueObject() {
    }

    public LabelValueObject(String label, Integer value) {
        this.label = label;
        this.value = value;
    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
