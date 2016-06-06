package com.blog.util;

import com.blog.model.Article;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 *
 * Created by Black on 2016/6/6.
 */
public class UploadUtil {
    public UploadUtil() {
    }

    public static String upload(CommonsMultipartFile file,
                              Article article, HttpServletRequest request) throws IOException {
        if(file != null){
            String originalFileName = file.getOriginalFilename();
            String newFileName = article.getCategoryId() + "-" + article.getTitle()
                    + "-" + originalFileName;
            String realPathDir = request.getSession().getServletContext().getRealPath("/");
            String path = "";
            for (String s: realPathDir.split("\\\\")) {
                if (s.equalsIgnoreCase("target"))
                {
                    break;
                }
                else {
                    s = s + "\\";
                }
                path += s;
            }
            String picPath = path +"\\src\\main\\webapp\\resources\\article\\" + newFileName;
            File newfile = new File(picPath);
            if (!newfile.exists())
                newfile.mkdirs();
            file.transferTo(newfile);
            return "resources\\article\\" + newFileName;
        }
        return null;
    }
}
