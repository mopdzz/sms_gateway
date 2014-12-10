package com.sp.platform.gateway.exception;

import com.sp.platform.gateway.constant.Status;

import java.util.Arrays;
import java.util.Map;

/**
 * @author yang lei
 */
public class BusinessException extends AbstractException{

    private static final long serialVersionUID = 1L;

    public BusinessException(Status status) {
        super(status.getHttpStatusCode(), status.getReasonPhrase(), Arrays.asList(status.getReasonPhrase()), new BusinessException());
    }
    
    public BusinessException(){
    }
    
    public BusinessException(Status status,Object parameter) {
        super(status.getHttpStatusCode(), String.format(status.getReasonPhrase(),parameter), Arrays.asList(String.format(status.getReasonPhrase(),parameter)), new BusinessException());
    }
    
    public BusinessException(Status status,Object parameter,Map<String, Object> attributes) {
        super(status.getHttpStatusCode(), String.format(status.getReasonPhrase(),parameter), Arrays.asList(String.format(status.getReasonPhrase(),parameter)),attributes, new BusinessException());
    }
    
}
