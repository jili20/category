package com.test.jili20.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bing  @create 2020/12/20-下午12:18
 */
@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class Jili20Exception extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息

}
