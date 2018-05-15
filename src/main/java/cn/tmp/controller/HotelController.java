package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.Page;
import cn.tmp.po.Hotel;
import cn.tmp.service.HotelService;
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

/**
 * Created by Ww on 2018/5/12.
 */
@Controller
@RequestMapping(value = "/hotel",produces = {"application/json;charset=UTF-8"} )
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(hotelService.list(page));
    }


    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(hotelService.list(page));
        dataGrid.setTotal(hotelService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Hotel hotel, @RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        try {
            if (file.getSize() > 0) {
                hotel.setImg(PageUtil.uploadAnnex(request,file,"hotel",hotel.getHid().toString() + "-" + hotel.getName()));
            }
            hotelService.insert(hotel);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Hotel hotel,@RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        hotel.setHid(id);
        try {
            if (file.getSize() > 0) {
                hotel.setImg(PageUtil.uploadAnnex(request,file,"hotel",hotel.getHid().toString() + "-" + hotel.getName()));
            }
            hotelService.update(hotel);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            hotelService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
}
