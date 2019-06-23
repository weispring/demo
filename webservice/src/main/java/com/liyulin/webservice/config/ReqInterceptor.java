package com.liyulin.webservice.config;

/**
 * @Auther: lixianchun
 * @Date: 2019/6/23 12:36
 * @Description:
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.util.StringUtils;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * <p>ClassName: CAbstractPhaseInterceptor</p>
 * <p>Description: cxf拦截器</p>
 * <p>Author: hff</p>
 * <p>Date: 2017-4-13</p>
 */
@Slf4j
public class ReqInterceptor extends AbstractPhaseInterceptor<Message> {
    /**
     * <p>Description: TODO</p>
     */


    private static final String USERNAME="root";
    private static final String PASSWORD="admin";


    public ReqInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        InputStream is = message.getContent(InputStream.class);
        if (is != null) {
            try {
                String str = IOUtils.toString(is);
                // 原请求报文
                log.info("====> request xml:{}", str);
                InputStream ism = new ByteArrayInputStream(str.getBytes("UTF-8"));
                message.setContent(InputStream.class, ism);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        checkPassword(message);
    }

    private void checkPassword(Message message){
        SoapMessage soapMessage = (SoapMessage) message;
        List<Header> headers = null;
        String username=null;
        String password=null;
        try {
            headers = soapMessage.getHeaders();
        } catch (Exception e) {
            log.error("getSOAPHeader error: {}",e.getMessage(),e);
        }

        if (headers == null) {
            throw new Fault(new IllegalArgumentException("找不到Header，无法验证用户信息"));
        }
        //获取用户名,密码
        for (Header header : headers) {
            SoapHeader soapHeader = (SoapHeader) header;
            org.w3c.dom.Element e = (org.w3c.dom.Element) soapHeader.getObject();
            NodeList usernameNode = e.getElementsByTagName("username");
            NodeList pwdNode = e.getElementsByTagName("password");
            username=usernameNode.item(0).getTextContent();
            password=pwdNode.item(0).getTextContent();
            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
                throw new Fault(new IllegalArgumentException("用户信息为空"));
            }
        }
        //校验用户名密码
        if(!(USERNAME.equals(username) && PASSWORD.equals(password))){
            SOAPException soapExc = new SOAPException("认证失败");
            log.debug("用户认证信息错误");
            throw new Fault(soapExc);
        }
    }

}

