package com.glimmer.controller.ml;

import com.glimmer.exception.EnvirVarException;
import com.glimmer.result.Result;
import com.glimmer.rro.CapaEvaluaRespond;
import com.glimmer.server.impl.CapaEvaluaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 能力评价请求处理层
 */
@RestController
@Slf4j
public class CapaEvaluaController {
    @Autowired
    private CapaEvaluaServiceImpl capaEvaluaService;

    /**
     * 能力评价
     */
    @GetMapping("/evaluate")
    public Result<CapaEvaluaRespond> getEvaluate(String desiredPosition){
        log.info("用户请求能力评价");

        CapaEvaluaRespond capaEvaluaRespond = capaEvaluaService.getcapaEvalua(desiredPosition);

        if (capaEvaluaRespond==null){
            throw new EnvirVarException("该用户没有上传简历");
        }

        return Result.success("成功",capaEvaluaRespond);
    }
}
