package com.glimmer.server.impl;

import com.glimmer.clients.CapaEvaluaClient;
import com.glimmer.entity.PdfUrl;
import com.glimmer.mapper.FillInResumeMapper;
import com.glimmer.rro.CapaEvaluaRespond;
import com.glimmer.server.CapaEvaluaService;
import com.glimmer.utils.IdUtils;
import com.glimmer.utils.UrlToMultipartFile;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
@Service
public class CapaEvaluaServiceImpl implements CapaEvaluaService {
    @Autowired
    private FillInResumeMapper fillInResumeMapper;
    @Autowired
    private IdUtils idUtils;

    //    @Autowired
//    private CapaEvaluaClient capaEvaluaClient;
    @Override
    public CapaEvaluaRespond getcapaEvalua(String desiredPosition) {
        PdfUrl[] pdfUrls = fillInResumeMapper.getResumePdfUrl(idUtils.getId());

        String mlUrl = "http://localhost:15213/evaluatetest";

        if (pdfUrls == null) {
            return null;
        } else {
            String url = pdfUrls[0].getUrl();
            MultipartFile multipartFile = UrlToMultipartFile.urlToMultipartFile(url);

            RestTemplate restTemplate = new RestTemplate();

            File fileTmp = new File(System.getProperty("user.dir")+"\\temp"+"\\"+multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(fileTmp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HttpHeaders httpHeaders = new HttpHeaders();

            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
            params.add("resumePdf",new FileSystemResource(fileTmp));
            params.add("desiredPosition",desiredPosition);

            HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(params,httpHeaders);
            ResponseEntity<CapaEvaluaRespond> responseEntity = restTemplate.postForEntity(mlUrl,requestEntity, CapaEvaluaRespond.class);

            CapaEvaluaRespond capaEvaluaRespond = responseEntity.getBody();
            fileTmp.delete();

            return capaEvaluaRespond;
        }
    }
}
