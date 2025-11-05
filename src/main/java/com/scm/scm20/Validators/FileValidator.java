package com.scm.scm20.Validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileValidator implements ConstraintValidator<ValidFile,MultipartFile> {


    private static final long MAX_FILE_SIZE=1024 * 1024 *2; //5mb

    //type

    //height


    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        
        if (file==null || file.isEmpty()) {
            
            //  context.disableDefaultConstraintViolation();
            //  context.buildConstraintViolationWithTemplate("File can't be empty").addConstraintViolation();
            return true;
        }

        //file size

        if (file.getSize()>MAX_FILE_SIZE) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File size should be less 2 MB").addConstraintViolation();
            return false;
            
        }


        return true;
    }

}
