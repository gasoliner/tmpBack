package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.Special;
import cn.tmp.po.Page;
import cn.tmp.service.SpecialService;
import cn.tmp.util.PageUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ww on 2018/5/12.
 */
@Controller
@RequestMapping(value = "/special",produces = {"application/json;charset=UTF-8"} )
public class SpecialController {

    @Autowired
    SpecialService specialService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(specialService.vo(specialService.list(page)));
        dataGrid.setTotal(specialService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Special special, @RequestParam("img_file") CommonsMultipartFile file, HttpServletRequest request) {
        try {
            if (file.getSize() > 0) {
                special.setImg(PageUtil.uploadAnnex(request,file,"special",special.getName()));
            }
            specialService.insert(special);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Special special,@RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        special.setSid(id);
        try {
            if (file.getSize() > 0) {
                special.setImg(PageUtil.uploadAnnex(request,file,"special",special.getName()));
            }
            specialService.update(special);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            specialService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/img/{id}")
    public void pic(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        PageUtil.showImg(specialService.selectByPrimaryKey(id).getImg(),response);
    }
    
}
