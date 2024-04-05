package com.glimmer.server.impl;

import com.glimmer.clients.JobRecommendationClient;
import com.glimmer.entity.PdfUrl;
import com.glimmer.entity.User;
import com.glimmer.mapper.FillInResumeMapper;
import com.glimmer.rro.CapaEvaluaRespond;
import com.glimmer.rro.JobRecommendRespond;
import com.glimmer.rro.Jobs;
import com.glimmer.server.JobCommandService;
import com.glimmer.utils.IdUtils;
import com.glimmer.utils.UrlToMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JobCommendServiceImpl implements JobCommandService {

    @Autowired
    private IdUtils idUtils;
//    @Autowired
//    private JobRecommendationClient jobRecommendationClient;
    @Autowired
    private FillInResumeMapper fillInResumeMapper;

    @Override
    public Jobs getJobRecon() {
        PdfUrl[] pdfUrls = fillInResumeMapper.getResumePdfUrl(idUtils.getId(new User()).getId());

        String url = pdfUrls[0].getUrl();

        String mlUrl = "http://113.54.236.190:5000/commend";

        if (url==null){
            return  null;
        }else {
            MultipartFile multipartFile = UrlToMultipartFile.urlToMultipartFile(url);

            RestTemplate restTemplate = new RestTemplate();

            File fileTmp = new File(System.getProperty("user.dir")+"\\temp2"+"\\"+multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(fileTmp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HttpHeaders httpHeaders = new HttpHeaders();

            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
            params.add("resumePdf",new FileSystemResource(fileTmp));

            HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(params,httpHeaders);
            ResponseEntity<Jobs> responseEntity = restTemplate.postForEntity(mlUrl,requestEntity,Jobs.class);

            Jobs jobs = responseEntity.getBody();
            fileTmp.delete();
            return jobs;
        }
    }
}
