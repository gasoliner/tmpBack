package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.Page;
import cn.tmp.po.Attraction;
import cn.tmp.service.AttractionService;
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
import java.util.List;

@Controller
@RequestMapping(value = "/attraction",produces = {"application/json;charset=UTF-8"} )
public class AttractionController {

    @Autowired
    AttractionService attractionService;

    @RequestMapping("/attr_option/{id}")
    @ResponseBody
    public String ddlList(@PathVariable Integer id){
        return JSON.toJSONString(attractionService.listByRegion(id));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(attractionService.vo(attractionService.list(page)));
        dataGrid.setTotal(attractionService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Attraction attraction, @RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        try {
            attraction.setImg(PageUtil.uploadAnnex(request,file,"attraction",attraction.getAid().toString() +"-" + attraction.getName()));
            attractionService.insert(attraction);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Attraction attraction,@RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        attraction.setAid(id);
        try {
            if (file.getSize() > 0) {
                attraction.setImg(PageUtil.uploadAnnex(request,file,"attraction",attraction.getAid().toString() +"-" + attraction.getName()));
            }
            attractionService.update(attraction);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            attractionService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/img/{id}")
    public void pic(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        PageUtil.showImg(attractionService.selectByPrimaryKey(id).getImg(),response);
    }

}
