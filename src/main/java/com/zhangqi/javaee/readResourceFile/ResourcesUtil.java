package com.zhangqi.javaee.readResourceFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 读取resource目录下的配置文件（文件为文档类型的配置文件）
 */
public class ResourcesUtil {
    private static final Logger logger = LoggerFactory.getLogger(ResourcesUtil.class);

    public String configurationFileName;

    public File file;

    //读取配置文件中的键值对
    public Map<String, String> configurationMap = new HashMap<>();

    //参数为配置文件的名称
    public ResourcesUtil(String configurationFileName) {
        this.configurationFileName = configurationFileName;
        try {
            Resource res = new ClassPathResource(configurationFileName);
            File f = res.getFile();
            if (!f.exists()) {
                logger.error("预处理转换类初始化出错，找不见" + configurationFileName + "文件...");
                return;
            }
            this.file = f;
            //存放配置文件中的每一行
            List<String> lines = FileUtils.readLines(f, "UTF-8");

            configurationMap = new HashMap<String, String>();
            for (String line : lines) {
                if (StringUtils.isBlank(line)) {
                    continue; //读取的行为空值的场合
                }
                line = line.trim();
                if (line.startsWith("#")) {
                    continue; //读取行以字符"#"开头，为注释的场合
                }
                //查询配置行中是否有"="符号
                //如果你们项目的文件中不是以=相隔  这里就需要替换代码为你的符号
                int equalFlagIndex = line.indexOf("=");
                //提取"="之前的字符串作为key
                String key = line.substring(0, equalFlagIndex).trim();
                //提取"="之后的字符串作为value
                String value = line.substring(equalFlagIndex + 1).trim();
                configurationMap.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取配置文件configuration中的指定字段的值
     *
     * @param key ..
     * @return ..
     */
    public String getValue(String key) {
        return configurationMap.get(key);
    }

    public void setValue(Map<String, String> valueMap) {
        BufferedWriter writer = null;
        Set<Map.Entry<String, String>> entries = valueMap.entrySet();
        List<String> list = new ArrayList<>(0);
        for (Map.Entry<String, String> map : entries) {
            list.add(map.getKey() + "=" + map.getValue());
        }
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String s : list) {
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //main方法测试读取
    public static void main(String[] args) {
        ResourcesUtil resourcesUtil = new ResourcesUtil("application.properties");
        String userName = resourcesUtil.getValue("userName");
        System.out.println(userName);
        System.out.println(resourcesUtil.configurationMap);
        Map<String,String>  map = new HashMap<>();
        map.put("userage","13");
        map.put("useradress","洛阳");
        map.put("usersex","man");
        map.put("userinfo","haha");
        resourcesUtil.setValue(map);

    }
}