package com.glimmer.exception;

/**
 * PDF URL为NULL异常
 */
public class PdfNullException extends BaseException{
    public PdfNullException(){

    }
    public PdfNullException(String msg){
        super(msg);
    }
}
