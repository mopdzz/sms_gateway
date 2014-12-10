package com.sp.platform.gateway.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author zhengqiang.shi
 */
@Provider
public class RuntimeExceptionMapper extends AbstractExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        return super.toResponse(e);
    }

}
