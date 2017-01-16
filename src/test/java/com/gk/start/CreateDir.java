package com.gk.start;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by pc on 2017/1/11.
 */

public class CreateDir {
    @Test
    public void createDirs() {
        List<String> dirList = new ArrayList<>();
        dirList.add("controller");
        dirList.add("service");
        dirList.add("service\\impl");
        dirList.add("dao");
        dirList.add("entity");
        dirList.add("protocol");
        dirList.add("util");
        String path = System.getProperty("user.dir");
        String packageUrl = "\\src\\main\\java\\com\\gk\\";
        for (String dir : dirList) {
            File file = new File(path + packageUrl + dir);
            if (file.mkdirs()) {
                System.out.println(file.getAbsolutePath());
            } else {
                System.out.println("fail");
            }
        }
    }

}
