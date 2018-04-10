package com.cxc.common.sms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


/***
 * 手机短信接口
 * @author Administrator
 *
 */
public class SmsUtil {
	public static final String  appKey = "23319343";  //应用列表中可以找到
    public static final String appSecret = "659a9e55ddbaa001ed6be67f9bc5bc81";//secret
    //public static final String url="http://gw.api.taobao.com/router/rest";   //网址
    //public static final String smsTemplateCode ="SMS_104615016";    //模板ID 3分钟过期
    public static final String smsTemplateCode ="SMS_106335023";	//模板ID 10分钟过期
    public static final String smsFreeSignName ="辰星测";    //短信签名 

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIm0Qnq0BjFFas";
    static final String accessKeySecret = "NbYAaIXciuFycOS9hrhfnc9iwoJ9YM";
    
    

	/***
     * 发送短信
     * @param phone
     * @param code
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendSms(String phone,String code) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(smsFreeSignName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(smsTemplateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{ \"code\":\""+code+"\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    
    /***
     * 流水号
     * @param bizId
     * @return
     */
    public static QuerySendDetailsResponse querySendDetails(String bizId,String phone) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phone);
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
    
    
    

    public static void main(String[] args) throws ClientException, InterruptedException {
    	String phone="15220196219"; 
    	String code = "123456";
        //发短信
        SendSmsResponse response = sendSms(phone,code);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

        Thread.sleep(3000L);

        //查明细
        if(response.getCode() != null && response.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId(),phone);
            System.out.println("短信明细查询接口返回数据----------------");
            System.out.println("Code=" + querySendDetailsResponse.getCode());
            System.out.println("Message=" + querySendDetailsResponse.getMessage());
            int i = 0;
            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
            {
                System.out.println("SmsSendDetailDTO["+i+"]:");
                System.out.println("Content=" + smsSendDetailDTO.getContent());
                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
            }
            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
        }

    }
    
    
    /***
     * 注册验证
     * key:手机号，
     * val(key:code(验证码),Key:time(发送的当时的毫秒数))
     */
    public static Map<String, Map<String,String>> registerCache = new HashMap<String, Map<String,String>>();
	
	public static Map<String, Map<String, String>> getRegisterCache() {
		return registerCache;
	}

	public synchronized static void setRegisterCache(
			Map<String, Map<String, String>> registerCache) {
		Map<String, Map<String, String>> cache = getRegisterCache();
		cache.putAll(registerCache);
		SmsUtil.registerCache = cache;
	}

	/***
     * 获取6位数的随机验证码
     * @return
     */
    public synchronized static String randoms(){
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<6;i++){
    		int x=(int)(Math.random()*10);
    		sb.append(x);
    	}
    	return sb.toString();
    }
    
    /***
     * 注册发送验证码
     * @param phone
     * @return
     */
    public static String getCode(String phone){
    	String rand = randoms();
    	Map<String, Map<String,String>> smsCodecache = new HashMap<String, Map<String,String>>();//获取缓存
    	Map<String,String> map = new HashMap<String, String>();
    	map.put("code", rand);
    	long time = new Date().getTime();
    	map.put("time", String.valueOf(time));
    	smsCodecache.put(phone, map);
    	try {
			sendSms(phone,rand);
			setRegisterCache(smsCodecache);
		} catch (ClientException e) {
			e.printStackTrace();
		}
    	return rand;
    }
    
    
}
