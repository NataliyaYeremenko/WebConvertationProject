package com.webConvertation.Managers;

import com.webConvertation.dao.entity.ImageFormatType;
import com.webConvertation.dao.entity.ImageType;
import com.webConvertation.dao.entity.OperationType;


/**
 * Created by Nataliya on 25.02.2017.
 */
public class EnumManager {
    public String getImageType(ImageType type) {
        String imageType = null;
        switch (type) {
            case INPUT:
                imageType = "com.webConvertation.dao.entity.InputFile";
                break;
            case OUTPUT:
                imageType = "com.webConvertation.dao.entity.OutputFile";
                break;
        }
        return imageType;
    }

    public String getImageFormatType(ImageFormatType imageFormatType) {
        String imageFormat = null;
        switch (imageFormatType) {
            case JPG:
                imageFormat = "jpg";
                break;
            case PNG:
                imageFormat = "png";
                break;
        }
        return imageFormat;
    }

    public String getOperationType(OperationType type) {
        String operationType = null;
        switch (type) {
            case CONVERT:
                operationType = "Convert";
                break;
            case TOGRAYSCALE:
                operationType = "com.webConvertation.dao.entity.OutputFile";
                break;
        }
        return operationType;
    }
}
