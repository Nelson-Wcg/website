package cc.xiaoerbi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

   @ExceptionHandler({ Exception.class })
   @ResponseStatus(HttpStatus.OK)
   public ModelAndView processException(HttpServletRequest request, Exception exception) {
       System.out.println(request.getRequestURL());
       System.out.println("URI"+request.getRequestURI());
     //  logger.info("自定义异常处理-Exception");
       ModelAndView mav = new ModelAndView();
       mav.addObject("url", request.getRequestURL());
       mav.addObject("exception", exception.getMessage());
       mav.setViewName(DEFAULT_ERROR_VIEW);
       return mav;
   }

}