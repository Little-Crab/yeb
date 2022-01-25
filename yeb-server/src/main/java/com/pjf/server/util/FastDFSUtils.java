package com.pjf.server.util;

import cn.hutool.core.io.resource.ClassPathResource;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pjf
 * @Date 2022/1/13 17:43
 * fastDFS工具类
 **/
@Slf4j
public class FastDFSUtils {
    /*
      初始化客户端
      ClientGlobal.init(filePath);读取配置文件，并开始初始划属性
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();

            ClientGlobal.init(filePath);
        } catch (IOException | MyException e) {
            log.error("初始化FastDFS失败======>{}", e.getMessage());
        }
    }


    /**
     * 生产TrackerServer
     *
     * @return 返回TrackerServer
     * @throws IOException 异常
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        return trackerClient.getTrackerServer();
    }

    /**
     * 生产StorageClient 客户端
     *
     * @return StorageClient
     * @throws IOException 异常
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        return new StorageClient(trackerServer, null);
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return 返回数组，
     */
    public static String[] upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        log.info("文件名：{}", filename);
        StorageClient storageClient = null;
        String[] uploadResult = null;
        try {
            //获取storageClient客户端
            storageClient = getStorageClient();
            assert filename != null;
            uploadResult = storageClient.upload_file(file.getBytes(), filename.substring(filename.lastIndexOf(".") + 1), null);
        } catch (IOException | MyException e) {
            log.error("上传文件失败：{}", e.getMessage());
        }
        if (null == uploadResult) {
            log.error("上传失败，错误码{}", storageClient.getErrorCode());
        }
        return uploadResult;
    }

    /**
     * 获取文件信息
     *
     * @param groupName      组名
     * @param remoteFileName 文件名
     * @return 返回信息
     */
    public static FileInfo getFileInfo(String groupName, String remoteFileName) {
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (IOException | MyException e) {
            log.error("文件信息获取失败==>{}", e.getMessage());
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            return new ByteArrayInputStream(fileByte);
        } catch (IOException e) {
            log.error("文件下载失败==>{}", e.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param groupName
     * @param remoteFileName
     */
    public static void deleteFile(String groupName, String remoteFileName) {
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            storageClient.delete_file(groupName, remoteFileName);
        } catch (IOException | MyException e) {
            log.error("文件删除失败==>{}", e.getMessage());
        }
    }

    /**
     * 获取文件路径
     *
     * @return 返回文件路径
     */
    public static String getTrackerUrl() {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        StorageServer storeStorage = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
            storeStorage = trackerClient.getStoreStorage(trackerServer);
        } catch (IOException | MyException e) {
            log.error("文件路径获取失败====》{}", e.getMessage());
        }
        return "http://" + storeStorage.getInetSocketAddress().getHostString() + ":8888/";
    }
}
