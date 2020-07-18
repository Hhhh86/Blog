package com.hyp.controller.admin;

import com.hyp.pojo.Type;
import com.hyp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @ProjectName blog
 * @ClassName TypeController
 * @create 2020-07-10 20:02
 * @Author by hyp
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //分页展示
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    //跳转添加页
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    //添加操作
    @PostMapping("/types")
    public String post(@Validated Type type, BindingResult result, RedirectAttributes attributes) {
        Type typename = typeService.getTypeByName(type.getName());
        if (typename != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.saveType(type);
        if (t == null ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    //跳转修改页
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    //修改操作
    @PostMapping("/types/{id}")   //@Valid是配合@NotBlank校验是否为空
    public String editType(Type type, @PathVariable Long id, RedirectAttributes attributes) {

        Type typeResult = typeService.updateType(id, type);

        if (typeResult == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    //删除操作
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
            typeService.deleteType(id);
            attributes.addFlashAttribute("message","删除成功");
            return "redirect:/admin/types";
    }
}
