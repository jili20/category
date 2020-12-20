package com.test.jili20.exception;

import com.test.jili20.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bing  @create 2020/12/20-下午12:17
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

    //自定义异常
    @ExceptionHandler(Jili20Exception.class)
    @ResponseBody //为了返回数据
    public R error(Jili20Exception e) {
        log.error(e.getMessage()); // 把异常写到本地日志文件
//        log.error(ExceptionUtil.getMessage(e)); // 调用详细异常信息工具类
        e.printStackTrace();

        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
