package com.glimmer.handler;

import com.glimmer.constant.HttpStatusConstant;
import com.glimmer.constant.MessageConstant;
import com.glimmer.exception.*;
import com.glimmer.result.Result;
import com.glimmer.vo.StatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类,处理业务抛出的异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity exceptionHandler(BaseException ex) {
        //处理简历基本信息填写失败异常
        if (ex instanceof ResumeBaseInfoFillException) {
            log.info("简历基本信息填写失败", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }
        //处理简历社团信息填写失败异常
        if (ex instanceof ResumeClubInfoFillException) {
            log.info("简历社团信息填写失败", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }
        //处理简历教育信息填写失败异常
        if (ex instanceof ResumeEducationInfoFillException) {
            log.info("简历教育信息填写失败", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }
        //处理简历学生职务信息填写失败异常
        if (ex instanceof ResumePositionInfoFillException) {
            log.info("简历学生职务信息填写失败", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }

        //处理简历项目经历信息填写失败异常
        if(ex instanceof ResumeProjectExperienceException){
            log.info("简历项目经历信息填写失败",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }

        //处理简历奖学金信息填写失败异常
        if(ex instanceof ResumeScholarshipInfoException){
            log.info("简历奖学金信息填写失败",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }

        //处理简历社会实践经历信息填写失败异常
        if(ex instanceof ResumeSocialActException){
            log.info("简历社会实践信息填写失败",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }

        //处理简历工作经历经历信息填写失败异常
        if(ex instanceof ResumeWorkExperienceException){
            log.info("简历工作经历信息填写失败",ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.ADD_ERROR, HttpStatusConstant.BAD_REQUEST, statusVo), HttpStatus.BAD_REQUEST);
        }
        //Oss访问配置失败异常
        if (ex instanceof OssConfigException) {
            log.info("Oss访问配置失败", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.CONFIG_ERROR, HttpStatusConstant.INTERNAL_SERVER_ERROR, statusVo), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //从环境变量获取访问拍配置异常
        if (ex instanceof EnvirVarException) {
            log.info("从环境变量获取访问拍配置异常", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.CONFIG_ERROR, HttpStatusConstant.INTERNAL_SERVER_ERROR, statusVo), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //简历url为null异常
        if (ex instanceof PdfNullException) {
            log.info("简历url为null异常", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.URL_IS_NULL, HttpStatusConstant.INTERNAL_SERVER_ERROR, statusVo), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //获取简历url为null异常
        if (ex instanceof PdfNullException) {
            log.info("获取简历url为null异常", ex.getMessage());
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message(ex.getMessage())
                    .build();
            return new ResponseEntity(Result.error(MessageConstant.GET_URL_IS_NULL, HttpStatusConstant.INTERNAL_SERVER_ERROR, statusVo), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //其他业务异常
        log.info("异常信息", ex.getMessage());
        StatusVo statusVo = StatusVo.builder()
                .status(0)
                .message(ex.getMessage())
                .build();
        return new ResponseEntity(Result.error(ex.getMessage(), HttpStatusConstant.SERVICE_UNAVAILABLE, statusVo), HttpStatus.SERVICE_UNAVAILABLE);
    }

}
