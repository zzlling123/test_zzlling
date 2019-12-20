package cn.com.ebook_web.controller;

import cn.com.ebook_web.pojo.Category;
import cn.com.ebook_web.pojo.Entry;
import cn.com.ebook_web.service.EbookService;
import com.java23.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class EbookController {
    @Resource
    private EbookService ebookServiceImpl;
    private Student student;
    @RequestMapping("list")
    public String list(String categoryId, String currentPage, Model model){
        int pageSize=3;
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        List<Entry> list=ebookServiceImpl.getEbooks(categoryId, pageSize,Integer.parseInt(currentPage));
        int num=ebookServiceImpl.getEbookscount(categoryId);
        model.addAttribute("list", list);
        List<Category> arr= ebookServiceImpl.getCategorys();
        model.addAttribute("arr",arr);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage",num%pageSize==0?num/pageSize:num/pageSize+1);
        return "list";
    }
    @RequestMapping("addSave")
    public String addSave(@ModelAttribute("entry")Entry entry, Model model){
        if(entry.getTitle()==null||"".equals(entry.getTitle())){
            model.addAttribute("error","图书名称不能为空！");
            return "redirect:/add.html";
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String date=sf.format(entry.getCreatedate());
        if(date==null||"".equals(date)){
            model.addAttribute("error","上传时间不能为空！");
            return "redirect:/add.html";
        }
        if(ebookServiceImpl.add(entry)>0){
            return "redirect:/list.html";
        }
        return "/add.html";
    }
    @RequestMapping("getEntry")
    public String getEntry(int id,Model model){
        Entry entry=ebookServiceImpl.getEntry(id);
        model.addAttribute("entry",entry);
        return "update";
    }
    @RequestMapping("updateSave")
    public String update(@ModelAttribute("entry") Entry entry,Model model){
        if(ebookServiceImpl.update(entry)>0){
            model.addAttribute("text","修改成功");
        }else{
            model.addAttribute("text","修改失败");
        }
        return "/list";
    }
    @RequestMapping("delete")
    public String delete(int id,Model model){
        if(ebookServiceImpl.delete(id)>0){
            model.addAttribute("text","修改成功");
        }else{
            model.addAttribute("text","修改失败");
        }
        return "redirect:/list";
    }
}
