package com.taotao.imagesUpload;

import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.imagesPathMapper;
import com.taotao.pojo.ImagePath;
import com.taotao.utils.FastDFSClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;


public class ImagesUpload {
    @Test
    public void load() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        imagesPathMapper imagespathMapper = applicationContext.getBean(imagesPathMapper.class);

        String path = "E:\\QQ\\数据\\1154867045\\FileRecv\\淘淘商城开发课前资料\\day08（淘淘商城07 - Solr入门以及搜索系统实现）\\京东商品爬虫\\jd";
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();
        FastDFSClient fastDFSClient = new FastDFSClient("E:\\IDEA\\IDEAproject\\taotao430\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
        for(int i=0;i<array.length;i++){
            if(array[i].isFile()){
                // only take file name
                //System.out.println(array[i].getName());
                // take file path and name
                //System.out.println("#####" + array[i]);
                // take file path and name
                //System.out.println(array[i].getPath());
                ImagePath imagePath = new ImagePath();
                String imgPath = fastDFSClient.uploadFile(array[i].getPath());
                System.out.println(imgPath);
                String newpath = "http://192.168.30.130:8888/" + imgPath;
                String oldpath = "http://image.taotao.com/jd/" + array[i].getName();
                System.out.print(newpath + " *********" + oldpath);
                imagePath.setOldPath(oldpath);
                imagePath.setNewPath(newpath);
                if(imagespathMapper == null){
                    System.out.println("null");
                }
                else{
                    System.out.println(imagespathMapper.updateImagePath(imagePath));
                }
            }
        }

    }
}
