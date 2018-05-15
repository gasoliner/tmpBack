package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.House;
import cn.tmp.po.Page;
import cn.tmp.service.HouseService;
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
@RequestMapping(value = "/house",produces = {"application/json;charset=UTF-8"} )
public class HouseController {

    @Autowired
    HouseService houseService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(houseService.vo(houseService.list(page)));
        dataGrid.setTotal(houseService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(House house, @RequestParam("img_file") CommonsMultipartFile file, HttpServletRequest request) {
        try {
            if (file.getSize() > 0) {
                house.setImg(PageUtil.uploadAnnex(request,file,"house",house.getName()));
            }
            houseService.insert(house);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, House house,@RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        house.setHoid(id);
        try {
            if (file.getSize() > 0) {
                house.setImg(PageUtil.uploadAnnex(request,file,"house",house.getName()));
            }
            houseService.update(house);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            houseService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/img/{id}")
    public void pic(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        PageUtil.showImg(houseService.selectByPrimaryKey(id).getImg(),response);
    }
    
}
