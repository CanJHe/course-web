package com.canJ.controller;

import com.canJ.pojo.*;
import com.canJ.service.CollectionStuService;
import com.canJ.service.CollectionTeaService;
import com.canJ.service.ResourceService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * 资源Controller
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CollectionStuService collectionStuService;

    @Autowired
    private CollectionTeaService collectionTeaService;

    @Autowired
    private HttpSession session;

    @Value("${FILE_LOCATION_URL}")
    private String FILE_LOCATION_URL;

    @Value("${FILE_STU_LOCATION}")
    private String FILE_STU_LOCATION;

    @Value("${FILE_TEA_LOCATION}")
    private String FILE_TEA_LOCATION;

    @Value("${SUCCESS_CODE}")
    private int SUCCESS_CODE;

    @RequestMapping("/stu/uploadPrompt")
    public String stuUploadPrompt(){
        return "stuUploadFile";
    }

    @RequestMapping("/tea/uploadPrompt")
    public String teaUploadPrompt(){
        return "teaUploadFile";
    }

    /**
     * 学生上传资源
     * @param image code
     * @return
     */
    @RequestMapping(value = "/stu/upload",method = RequestMethod.POST)
    public String uploadStuResource( String name,String level,String desc,
                                        @RequestParam (value = "image") MultipartFile image,
                                         @RequestParam (value = "code") MultipartFile code){
       try {
           Resource resource = new Resource();
;          String imageFileNameUrl = executeUploadFile(image);
           String codeFileNameUrl= executeUploadFile(code);
           resource.setName(name);
           resource.setImage(imageFileNameUrl);
           resource.setCode(codeFileNameUrl);
           resource.setUploadTime(new Date());
           resource.setLevel(level);
           resource.setDescn(desc);
           ResponseResult result = resourceService.uploadResource(resource);
           if (result.getStatus() == SUCCESS_CODE){
                return "redirect:/resource/myResource";
           }
           return "error/error";
       }catch (Exception e){
            e.printStackTrace();
           return "error/error";
       }
    }

    /**
     * 学生上传资源
     * @param image code
     * @return
     */
    @RequestMapping(value = "/tea/upload",method = RequestMethod.POST)
    public String uploadTeaResource(String name,String level,String desc,
                                    @RequestParam (value = "image") MultipartFile image,
                                 @RequestParam (value = "code") MultipartFile code){
        try {
            String imageNameUrl = executeUploadFile(image);
            String codeNameUrl= executeUploadFile(code);
            Resource resource = new Resource();
            resource.setName(name);
            resource.setImage(imageNameUrl);
            resource.setCode(codeNameUrl);
            resource.setUploadTime(new Date());
            resource.setLevel(level);
            resource.setDescn(desc);
            ResponseResult result = resourceService.uploadResource(resource);
            if (result.getStatus() == SUCCESS_CODE){
                return  "redirect:/resource/myResource";
            }
            return "error/error";
        }catch (Exception e){
            e.printStackTrace();
            return "error/error";
        }
    }

    /**
     * 返回上传文件的URL
     * @param uploadFile
     * @return
     */
    private String executeUploadFile(MultipartFile uploadFile) throws Exception{
           //获取源文件名
           String originalFilename = uploadFile.getOriginalFilename();
           //获取文件的后缀名
           String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
           //获取文件在硬盘中的真实路径
            Student student = (Student) session.getAttribute("student");
            Teacher teacher = (Teacher) session.getAttribute("teacher");
            String path;
            if (student != null){
                 path = session.getServletContext().getRealPath(FILE_STU_LOCATION);
            }else if (teacher != null){
                path = session.getServletContext().getRealPath(FILE_TEA_LOCATION);
            }else{
                return null;
            }
           //设置文件在硬盘中的文件名
           File file = new File(path,System.nanoTime()+"_"+originalFilename);
           //完成文件写入服务器端
           if (!file.getParentFile().exists()){
               file.getParentFile().mkdir();
           }
           if (!file.exists()){
               file.createNewFile();
           }
           uploadFile.transferTo(file);
            if (student != null){
                return FILE_STU_LOCATION + file.getName();
            }
           return FILE_TEA_LOCATION + file.getName();
    }

    /**
     * 下载资源
     * @return
     */
    @RequestMapping("/download/{resourceId}")
    public void downloadResource(@PathVariable int resourceId, HttpServletResponse response){
        Resource resource = resourceService.downloadResource(resourceId);
        String codeUrl = resource.getCode();
        String filename;
        filename = codeUrl.substring(codeUrl.lastIndexOf("/")+1);
        String realPath = session.getServletContext().getRealPath(codeUrl);
        File file = new File(realPath);
        OutputStream out = null;
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        if (file.exists()){
            try {
                response.reset();
                //设置MIME类型
                response.setContentType("application/octet-stream; charset=utf-8");

                //设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
                response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes(),"ISO8859-1"));

                out = response.getOutputStream();

                out.write(FileUtils.readFileToByteArray(file));

                out.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if (out != null){
                    try {
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 展示所有资源
     * @param model
     * @return
     */
    @RequestMapping("/resources")
    public String showResources(Model model){
        List<Resource> resources = resourceService.getAllResources();
        model.addAttribute("resources",resources);
        return "listResources";
    }

    /**
     * 通过资源名查找资源
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/resource")
    public String showResourcesByName(String name,Model model){
        List<Resource> resources = resourceService.getResourcesByName(name);
        model.addAttribute("resources",resources);
        return "listResources";
    }

    /**
     * 查看我的资源
     * @param model
     * @return
     */
    @RequestMapping("/myResource")
    public String showMyResources(Model model){
        List<Resource> resources = resourceService.getMyResources();
        if (resources != null){
            model.addAttribute("resources",resources);
        }
        return "myResources";
    }

    /**
     * 根据id查看资源详情
     * @param resourceId
     * @param model
     * @return
     */
    @RequestMapping("/resourceDetail/{resourceId}")
    public String resourceDetail(@PathVariable int resourceId,Model model){
        ResponseResourceBody resource = resourceService.getResourceById(resourceId);
        List<Resource> resources = resourceService.getResourcesByName(resource.getName());
        boolean collection = collectionStuService.isCollection(resourceId);
        if (resource != null){
            model.addAttribute("resource",resource);
            model.addAttribute("resources",resources);
            if (collection){
                model.addAttribute("isCollection","取消收藏");
            }
            return "resourceDetail";
        }
        return "error/error";
    }

    /**
     * 根据id删除资源
     * @param resourceId
     * @return
     */
    @RequestMapping("/delete/{resourceId}")
    public String deleteResource(@PathVariable int resourceId){
        boolean result = resourceService.deleteResourceById(resourceId);
        if (result){
            return "redirect:/resource/myResource";
        }
       return "error/error";
    }

    /**
     * 更新资源
     * @param resource
     * @return
     */
    @RequestMapping("/update")
    public String updateResource(Resource resource){
        boolean result = resourceService.updateResource(resource);
        if (result){
            return "resourceDetail";
        }
        return "error/error";
    }

    /**
     * 管理员删除资源
     * @param resourceId
     * @return
     */
    @RequestMapping("/deleteByAdmin/{resourceId}")
    public String deleteResourceByAdmin(@PathVariable int resourceId){
        boolean result = resourceService.deleteResourceById(resourceId);
        if (result){
            return "redirect:/resource/resources";
        }
        return "error/error";
    }

}
