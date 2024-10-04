package com.tao.cnndeployment.config;


import com.tao.cnndeployment.pojo.ModelType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CNNModelConfig {
    public CNNModelConfig() {
    }

    @Value("${cnnmodels.cascade_rcnn.path}")
    private String cascade_rcnn_path;

    @Value("${cnnmodels.mask_rcnn_50.path}")
    private String mask_rcnn_50_path;

    @Value("${cnnmodels.mask_rcnn_101.path}")
    private String mask_rcnn_101_path;

    public String getCascade_rcnn_path() {
        return cascade_rcnn_path;
    }

    public String getMask_rcnn_50_path() {
        return mask_rcnn_50_path;
    }

    public String getMask_rcnn_101_path() {
        return mask_rcnn_101_path;
    }

    public String[] getModelPath(ModelType modelType) {
        switch (modelType) {
            case CASCADE_MASK_RCNN:
                return new String[] {getCascade_rcnn_path()};
            case MASK_RCNN_R50:
                return new String[] {getMask_rcnn_50_path()};
            case MASK_RCNN_R101:
                return new String[] {getMask_rcnn_101_path()};
            case ALL:
                return new String[] {        getCascade_rcnn_path(),
                        getMask_rcnn_50_path(),
                        getMask_rcnn_101_path()};
            default:
                throw new IllegalArgumentException("Unknown model type: " + modelType);
        }
    }

}
