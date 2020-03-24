package com.zhangqi.javaee.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.zhangqi.javaee.readResourceFile.ResourcesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    public static String createToken() throws ParseException {

        String secret = "secret";// token 密钥
        Algorithm algorithm = Algorithm.HMAC256("secret");

        // 头部信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        Date nowDate = new Date();
        Date expireDate = getAfterDate();
        ;// 2小过期

        String token = JWT.create()
                .withHeader(map)// 设置头部信息 Header
                .withIssuer("SERVICE")//设置 载荷 签名是有谁生成 例如 服务器
                .withSubject("this is test token")//设置 载荷 签名的主题
                // .withNotBefore(new Date())//设置 载荷 定义在什么时间之前，该jwt都是不可用的.
                .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(nowDate) //设置 载荷 生成签名的时间
                .withExpiresAt(expireDate)//设置 载荷 签名过期的时间
                .sign(algorithm);//签名 Signature

        return token;
    }


    /**
     * 自定义payload信息
     * @return
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    public static String createTokenWithChineseClaim2() throws UnsupportedEncodingException, ParseException {

        Date nowDate = new Date();
        Date expireDate = getAfterDate();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        User user = new User();
        user.setUsername("张三");
        user.setDeptName("技术部");
        Gson gson = new Gson();
        String userJson = gson.toJson(user);

        String userJsonBase64 = BaseEncoding.base64().encode(userJson.getBytes());

        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withHeader(map)

                .withClaim("loginName", "zhuoqianmingyue")
                .withClaim("user", userJsonBase64)
                .withIssuer("SERVICE")// 签名是有谁生成
                .withSubject("this is test token")// 签名的主题
                // .withNotBefore(new Date())//该jwt都是不可用的时间
                .withAudience("APP")// 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(nowDate) // 生成签名的时间
                .withExpiresAt(expireDate)// 签名过期的时间
                .sign(algorithm);//签名 Signature

        return token;
    }


    /**
     * 校验jwt的合法性
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    public static void verifyToken() throws UnsupportedEncodingException, ParseException {
        String token = createTokenWithChineseClaim2();

        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("SERVICE").build(); // Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);

        String subject = jwt.getSubject();
        List<String> audience = jwt.getAudience();
        Map<String, Claim> claims = jwt.getClaims();
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            String key = entry.getKey();
            Claim claim = entry.getValue();
            log.info("key:" + key + " value:" + claim.asString());
            System.out.println("key:" + key + " value:" + claim.asString());

        }
        Claim claim = claims.get("loginName");

        System.out.println(claim.asString());
        System.out.println(subject);
        System.out.println(audience.get(0));

    }

    public static Date getAfterDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(new Date());
        format.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        Date date = format.parse(dateStr);
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        dateStr = format.format(date);
        Date date1 = format.parse(dateStr);
        return date1;
    }


}
