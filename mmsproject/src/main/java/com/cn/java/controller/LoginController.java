package com.cn.java.controller;

import com.cn.java.pojo.Account;
import com.cn.java.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Random;

@Controller
@RequestMapping("login")
public class LoginController {
        @Autowired
        private LoginService ls;
        @RequestMapping("login")
        public String panDuan(Account acc, String code1, Model model, HttpServletRequest request) throws SQLException {
            String code = (String)request.getSession().getAttribute("code");
            if(!code.equals(code1)){
                model.addAttribute("user","验证码错误");
                return "../../../index";
            }
            if(!StringUtils.hasLength(acc.getUsername())){
                model.addAttribute("user","请输入用户名");
                return "../../../index";
            }
            if(!StringUtils.hasLength(acc.getPwd())){
                model.addAttribute("user","请输入密码");
                return "../../../index";
            }
            if(ObjectUtils.isEmpty(ls.searchName(acc.getUsername()))){
                model.addAttribute("user","当前账户不存在");
                return "../../../index";
            }
            if(!(ls.searchName(acc.getUsername()).getPwd().equals(acc.getPwd()))){
                model.addAttribute("user","密码错误");
                return "../../../index";
            }
            return "/layui/main";
        }
        private int width = 80;
        private int height = 30;
        @RequestMapping("codeTwo")
        public void getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            //step2,获得画笔
            Graphics g = image.getGraphics();
            //step3,给笔上色
            Random r = new Random();
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            //step4,给画板设置背景颜色
            g.fillRect(0, 0, width, height);
            //step5,绘制一个随机的字符串
            String number = r.nextInt(99999) + "";
            g.setColor(new Color(0, 0, 0));
            //new Font(字体,风格,大小)
            g.setFont(new Font(null, Font.ITALIC, 24));
            g.drawString(number, 5, 25);
            //step6,加一些干扰线
            for (int i = 0; i < 8; i++) {
                g.setColor(new Color(r.nextInt(255),
                        r.nextInt(255), r.nextInt(255)));
                g.drawLine(r.nextInt(width),
                        r.nextInt(height), r.nextInt(width),
                        r.nextInt(height));
            }
            /*
             * 压缩图片并输出到客户端(浏览器)
             */
            request.getSession().setAttribute("code", number);
            response.setContentType("image/jpeg");
            OutputStream ops = response.getOutputStream();
            javax.imageio.ImageIO.write(image, "jpeg", ops);
            ops.close();
        }
        @RequestMapping("toMain")
        public void toMain(HttpServletResponse response) throws IOException {
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write("{\n" +
                    "  \"homeInfo\": {\n" +
                    "    \"title\": \"首页\",\n" +
                    "    \"href\": \"Menu/toWelcome?t=1\"\n" +
                    "  },\n" +
                    "  \"logoInfo\": {\n" +
                    "    \"title\": \"\",\n" +
                    "    \"image\": \"images/logo.jpeg\",\n" +
                    "    \"href\": \"\"\n" +
                    "  },\n" +
                    "  \"menuInfo\": [\n" +
                    "    {\n" +
                    "      \"title\": \"常规管理\",\n" +
                    "      \"icon\": \"fa fa-address-book\",\n" +
                    "      \"href\": \"\",\n" +
                    "      \"target\": \"_self\",\n" +
                    "      \"child\": [\n" +
                    "        {\n" +
                    "          \"title\": \"主页模板\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-home\",\n" +
                    "          \"target\": \"_self\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"主页一\",\n" +
                    "              \"href\": \"page/welcome-1.html\",\n" +
                    "              \"icon\": \"fa fa-tachometer\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"主页二\",\n" +
                    "              \"href\": \"page/welcome-2.html\",\n" +
                    "              \"icon\": \"fa fa-tachometer\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"主页三\",\n" +
                    "              \"href\": \"page/welcome-3.html\",\n" +
                    "              \"icon\": \"fa fa-tachometer\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"菜单管理\",\n" +
                    "          \"href\": \"Menu/toMenu\",\n" +
                    "          \"icon\": \"fa fa-window-maximize\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"系统设置\",\n" +
                    "          \"href\": \"page/setting.html\",\n" +
                    "          \"icon\": \"fa fa-gears\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"表格示例\",\n" +
                    "          \"href\": \"page/table.html\",\n" +
                    "          \"icon\": \"fa fa-file-text\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"表单示例\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-calendar\",\n" +
                    "          \"target\": \"_self\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"普通表单\",\n" +
                    "              \"href\": \"page/form.html\",\n" +
                    "              \"icon\": \"fa fa-list-alt\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"分步表单\",\n" +
                    "              \"href\": \"page/form-step.html\",\n" +
                    "              \"icon\": \"fa fa-navicon\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"登录模板\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-flag-o\",\n" +
                    "          \"target\": \"_self\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"登录-1\",\n" +
                    "              \"href\": \"page/login-1.html\",\n" +
                    "              \"icon\": \"fa fa-stumbleupon-circle\",\n" +
                    "              \"target\": \"_blank\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"登录-2\",\n" +
                    "              \"href\": \"page/login-2.html\",\n" +
                    "              \"icon\": \"fa fa-viacoin\",\n" +
                    "              \"target\": \"_blank\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"登录-3\",\n" +
                    "              \"href\": \"page/login-3.html\",\n" +
                    "              \"icon\": \"fa fa-tags\",\n" +
                    "              \"target\": \"_blank\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"异常页面\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-home\",\n" +
                    "          \"target\": \"_self\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"404页面\",\n" +
                    "              \"href\": \"page/404.html\",\n" +
                    "              \"icon\": \"fa fa-hourglass-end\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"其它界面\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-snowflake-o\",\n" +
                    "          \"target\": \"\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"按钮示例\",\n" +
                    "              \"href\": \"page/button.html\",\n" +
                    "              \"icon\": \"fa fa-snowflake-o\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"title\": \"弹出层\",\n" +
                    "              \"href\": \"page/layer.html\",\n" +
                    "              \"icon\": \"fa fa-shield\",\n" +
                    "              \"target\": \"_self\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"组件管理\",\n" +
                    "      \"icon\": \"fa fa-lemon-o\",\n" +
                    "      \"href\": \"\",\n" +
                    "      \"target\": \"_self\",\n" +
                    "      \"child\": [\n" +
                    "        {\n" +
                    "          \"title\": \"图标列表\",\n" +
                    "          \"href\": \"page/icon.html\",\n" +
                    "          \"icon\": \"fa fa-dot-circle-o\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"图标选择\",\n" +
                    "          \"href\": \"page/icon-picker.html\",\n" +
                    "          \"icon\": \"fa fa-adn\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"颜色选择\",\n" +
                    "          \"href\": \"page/color-select.html\",\n" +
                    "          \"icon\": \"fa fa-dashboard\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"下拉选择\",\n" +
                    "          \"href\": \"page/table-select.html\",\n" +
                    "          \"icon\": \"fa fa-angle-double-down\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"文件上传\",\n" +
                    "          \"href\": \"page/upload.html\",\n" +
                    "          \"icon\": \"fa fa-arrow-up\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"富文本编辑器\",\n" +
                    "          \"href\": \"page/editor.html\",\n" +
                    "          \"icon\": \"fa fa-edit\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"省市县区选择器\",\n" +
                    "          \"href\": \"page/area.html\",\n" +
                    "          \"icon\": \"fa fa-rocket\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"其它管理\",\n" +
                    "      \"icon\": \"fa fa-slideshare\",\n" +
                    "      \"href\": \"\",\n" +
                    "      \"target\": \"_self\",\n" +
                    "      \"child\": [\n" +
                    "        {\n" +
                    "          \"title\": \"多级菜单\",\n" +
                    "          \"href\": \"\",\n" +
                    "          \"icon\": \"fa fa-meetup\",\n" +
                    "          \"target\": \"\",\n" +
                    "          \"child\": [\n" +
                    "            {\n" +
                    "              \"title\": \"按钮1\",\n" +
                    "              \"href\": \"page/button.html?v=1\",\n" +
                    "              \"icon\": \"fa fa-calendar\",\n" +
                    "              \"target\": \"_self\",\n" +
                    "              \"child\": [\n" +
                    "                {\n" +
                    "                  \"title\": \"按钮2\",\n" +
                    "                  \"href\": \"page/button.html?v=2\",\n" +
                    "                  \"icon\": \"fa fa-snowflake-o\",\n" +
                    "                  \"target\": \"_self\",\n" +
                    "                  \"child\": [\n" +
                    "                    {\n" +
                    "                      \"title\": \"按钮3\",\n" +
                    "                      \"href\": \"page/button.html?v=3\",\n" +
                    "                      \"icon\": \"fa fa-snowflake-o\",\n" +
                    "                      \"target\": \"_self\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                      \"title\": \"表单4\",\n" +
                    "                      \"href\": \"page/form.html?v=1\",\n" +
                    "                      \"icon\": \"fa fa-calendar\",\n" +
                    "                      \"target\": \"_self\"\n" +
                    "                    }\n" +
                    "                  ]\n" +
                    "                }\n" +
                    "              ]\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"title\": \"失效菜单\",\n" +
                    "          \"href\": \"page/error.html\",\n" +
                    "          \"icon\": \"fa fa-superpowers\",\n" +
                    "          \"target\": \"_self\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");
        }
}
