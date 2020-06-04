package com.logistics.userdame.uilt;

//登入过滤器

import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//用户登入拦截
@WebFilter("/*")
public class LogFilter implements Filter {
    //实例化一个静态的集合(这里可以改用map集合，提高性能，每次过滤可以不用for匹配)
    private static List<String> urls = new ArrayList<>();
    //静态代码块中向集合中存放所有可以放行的请求或网页地址（不用账号密码即可访问）
    static {
        urls.add("/index");
        urls.add("/Enter");
//        urls.add("/EList");
        urls.add("/static/**");
        urls.add("/js/bootstrap.min.js");
        urls.add("/favicon.ico");
        urls.add("/templates/**");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//注意：ServletRequest是HttpServletRequest父接口,因此需要强转
//同样，ServletResponse是HttpServletResponse父接口,因此需要强转
//        System.out.println(request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        //HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(res);
//得到当前页面所在目录下全名称
        String urlPattern=req.getServletPath();
//        System.out.println("当前页面所在目录下全名称"+urlPattern);
//得到页面所在服务器的绝对路径
        String path = req.getRequestURI();
//        System.out.println("页面所在服务器的绝对路径"+path);
//对比路径
        for (String url : urls) {
            if(url.equals(urlPattern) || path.contains(url)) {
//                System.out.println("放行");
                chain.doFilter(request, response);
                //防止重复响应
                return;
            }
        }
        //如果用户session为null，表示没有登录，跳转到登入界面
        if(req.getSession().getAttribute("logUser")==null) {
//            System.out.println("阻止");
            res.sendRedirect("/index");
        }else {
            //放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
