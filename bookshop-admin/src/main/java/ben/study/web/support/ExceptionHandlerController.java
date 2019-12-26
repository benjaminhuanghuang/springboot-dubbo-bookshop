package ben.study.web.support;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerException(RuntimeException exception)
    {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "fail");
        result.put("errMsg", exception.getMessage());

        return result;
    }

}
