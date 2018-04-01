package online.wangxuan.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by wx
 * Date: 2018/3/25
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    // 过滤器类型，它决定过滤器在请求的哪个生命周期中执行，这里定义为 pre 代表会在请求被路由之前执行
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器执行的顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断该过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
