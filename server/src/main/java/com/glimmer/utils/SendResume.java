package com.glimmer.utils;

import com.glimmer.constant.Url;
import com.glimmer.entity.PdfUrl;
import com.glimmer.entity.User;
import com.glimmer.mapper.FillInResumeMapper;
import com.glimmer.rro.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class SendResume {
    @Autowired
    private static IdUtils idUtils;
    @Autowired
    private static FillInResumeMapper fillInResumeMapper;

//    public static void sendResume() {
//        PdfUrl[] pdfUrls = fillInResumeMapper.getResumePdfUrl(idUtils.getId(new User()).getId());
//
//        String url = pdfUrls[0].getUrl();
//
//        String mlUrl = "http://" + Url.mlUrl + ":" + Url.port + "/comment";
//
//        if (url == null) {
//            return null;
//        } else {
//            MultipartFile multipartFile = UrlToMultipartFile.urlToMultipartFile(url);
//
//            RestTemplate restTemplate = new RestTemplate();
//
//            File fileTmp = new File(System.getProperty("user.dir") + "\\temp2" + "\\" + multipartFile.getOriginalFilename());
//
//            try {
//                multipartFile.transferTo(fileTmp);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            HttpHeaders httpHeaders = new HttpHeaders();
//
//            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//            params.add("resumePdf", new FileSystemResource(fileTmp));
//
//            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, httpHeaders);
//            ResponseEntity<Jobs> responseEntity = restTemplate.postForEntity(mlUrl, requestEntity, Jobs.class);
//            // System.out.println(responseEntity);
//            Jobs jobs = responseEntity.getBody();
//            fileTmp.delete();
//        }
//    }
}
