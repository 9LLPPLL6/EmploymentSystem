package com.glimmer.utils;

import com.dtflys.forest.backend.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;

/**
 * 获取url的pdf简历转化为MultipartFile
 */
@Slf4j
public class UrlToMultipartFile {
    public static MultipartFile urlToMultipartFile(String url) {
        File file = null;
        MultipartFile multipartFile = null;

        file = getFileByHttpURL(url);

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return multipartFile;
    }

//    public static File getNetUrl(String netUrl) {
//        //判断http和https
//        File file = null;
//        if (netUrl.startsWith("https://")) {
//            file = getNetUrlHttps(netUrl);
//        } else {
//            file = getNetUrlHttp(netUrl);
//        }
//        return file;
//    }
//
//    public static File getNetUrlHttp(String netUrl) {
//        //对本地文件命名
//        String[] urlSplit = StringUtils.split("/");
//        String fileName = urlSplit[urlSplit.length-1];
//        File file = null;
//
//
//        URL urlfile;
//        InputStream inStream = null;
//        OutputStream os = null;
//        try {
//            file = File.createTempFile("net_url", fileName);
//            //下载
//            urlfile = new URL(netUrl);
//            inStream = urlfile.openStream();
//            os = new FileOutputStream(file);
//
//            int bytesRead = 0;
//            byte[] buffer = new byte[8192];
//            while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
//                os.write(buffer, 0, bytesRead);
//            }
//        } catch (Exception e) {
//            log.error("远程图片获取错误："+netUrl);
//            e.printStackTrace();
//        } finally {
//            try {
//                if (null != os) {
//                    os.close();
//                }
//                if (null != inStream) {
//                    inStream.close();
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return file;
//    }
//
//    /**
//     * 下载文件到本地(支持https)
//     *
//     * @param fileUrl 远程地址
//     * @throws Exception
//     */
//    public static File getNetUrlHttps(String fileUrl) {
//        //对本地文件进行命名
//        String[] urlSplit = StringUtils.split("/");
//        String file_name = urlSplit[urlSplit.length-1];
//        File file = null;
//
//        DataInputStream in = null;
//        DataOutputStream out = null;
//        try {
//            file = File.createTempFile("net_url", file_name);
//
//            SSLContext sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
//            sslcontext.init(null, new TrustManager[]{new X509TrustUtiil()}, new java.security.SecureRandom());
//            URL url = new URL(fileUrl);
//            HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
//                @Override
//                public boolean verify(String s, SSLSession sslsession) {
//                    log.warn("WARNING: Hostname is not matched for cert.");
//                    return true;
//                }
//            };
//            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
//            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
//            HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();
//            urlCon.setConnectTimeout(6000);
//            urlCon.setReadTimeout(6000);
//            int code = urlCon.getResponseCode();
//            if (code != HttpURLConnection.HTTP_OK) {
//                throw new Exception("文件读取失败");
//            }
//            // 读文件流
//            in = new DataInputStream(urlCon.getInputStream());
//            out = new DataOutputStream(new FileOutputStream(file));
//            byte[] buffer = new byte[2048];
//            int count = 0;
//            while ((count = in.read(buffer)) > 0) {
//                out.write(buffer, 0, count);
//            }
//            out.close();
//            in.close();
//        } catch (Exception e) {
//            log.error("远程图片获取错误："+fileUrl);
//            e.printStackTrace();
//        } finally {
//            try {
//                if (null != out) {
//                    out.close();
//                }
//                if (null != in) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//
//        return file;
//    }

    private static File getFileByHttpURL(String path) {
        String newUrl = path.split("[?]")[0];
        String[] suffix = newUrl.split("/");
        //得到最后一个分隔符后的名字
        String fileName = suffix[suffix.length - 1];
        File file = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            file = File.createTempFile("report", fileName);//创建临时文件
            URL urlFile = new URL(newUrl);
            inputStream = urlFile.openStream();
            outputStream = new FileOutputStream(file);

            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
