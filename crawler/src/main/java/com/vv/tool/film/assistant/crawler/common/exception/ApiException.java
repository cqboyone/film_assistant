package com.vv.tool.film.assistant.crawler.common.exception;

import com.vv.tool.film.assistant.crawler.common.enums.CommonErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @creator vv
 * @date 2021/5/17 19:37
 */
@NoArgsConstructor
@Getter
public class ApiException extends RuntimeException {

    public String code;
    public String message;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ApiException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.getMsg());
        this.code = commonErrorCode.getCode();
        this.message = commonErrorCode.getMsg();
    }
}
