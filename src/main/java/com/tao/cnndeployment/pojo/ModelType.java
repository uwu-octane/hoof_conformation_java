package com.tao.cnndeployment.pojo;

public enum ModelType {
    CASCADE_MASK_RCNN("Cacade_Mask_RCNN"),
    MASK_RCNN_R50("Mask_RCNN_R50"),
    MASK_RCNN_R101("Mask_RCNN_R101"),
    ALL("ALL");

    private final String value;

    ModelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModelType fromValue(String value) {
        for (ModelType type : ModelType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown model type: " + value);
    }
}