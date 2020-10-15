package com.heytea.demo.rabbitmq.model;
public final class HeyteaCodeConstant {

    public static final String ROOT = HeyteaConstant.EN_NAME;
    public static final String ROOT_SHORT = HeyteaConstant.EN_NAME_SHORT;

    /**
     * 系统编码系类
     */
    public static final class NS_SYS {
        public static final String NAME = "sys";
        public static final String NAME_SHORT = "s";
    }

    /**
     * 业务编码系类
     */
    public static final class NS_BIZ {
        public static final String NAME = "biz";
        public static final String NAME_SHORT = "b";
    };

    /**
     * 外部系统编码系类
     */
    public static final class NS_EXT {
        public static final String NAME = "ext";
        public static final String NAME_SHORT = "e";
    };

    /**
     * 系统编码
     * 
     * @author huahouye xuzhimin@heytea.com
     * @date 2019/12/28
     */
    public static class SysCode {

        /**
         * DEMO 类父编码
         */
        public static final String DEMO = "demo";

        /**
         * 通知类父编码
         */
        public static final String NOTIFY = "notify";

        /**
         * 日志类父编码
         */
        public static final String log = "log";

        /**
         * 数据类父编码
         */
        public static final String DATA = "data";
    }

    /**
     * 业务编码
     * 
     * @author huahouye xuzhimin@heytea.com
     * @date 2019/12/28
     */
    public static class BizCode {

        /**
         * DEMO 类父编码
         */
        public static final String DEMO = "demo";

        /**
         * 通知类父编码
         */
        public static final String NOTIFY = "notify";

        /**
         * 日志类父编码
         */
        public static final String log = "log";

        /**
         * 数据类父编码
         */
        public static final String DATA = "data";

        /**
         * 用户类父编码
         */
        public static final String USER = "user";

        /**
         * 会员类父编码
         */
        public static final String MEMBER = "member";

        /**
         * 帐号类父编码
         */
        public static final String ACCOUNT = "account";

        /**
         * 产品/商品类父编码
         */
        public static final String PROD = "prod";

        /**
         * 产品/商品类父编码
         */
        public static final String PRODUCTION = "production";

        /**
         * 产品/商品类父编码
         */
        public static final String GOODS = "goods";

        /**
         * 规格类父编码
         */
        public static final String SPEC = "spec";

        /**
         * 库存类父编码
         */
        public static final String INVENTORY = "inventory";

        /**
         * 库存类父编码
         */
        public static final String STOCK = "stock";

        /**
         * 订单类父编码
         */
        public static final String ORDER = "order";

        /**
         * 支付类父编码
         */
        public static final String PAY = "pay";

        /**
         * 结算类父编码
         */
        public static final String SETTLE = "settle";

        /**
         * 配送类父编码
         */
        public static final String DELIVERY = "delivery";

        /**
         * 管理类父编码
         */
        public static final String ADMIN = "admin";

        /**
         * 售后/客服类父编码
         */
        public static final String SERVICE = "service";
    }

    /**
     * 外部系统空间编码
     * 
     * @author huahouye xuzhimin@heytea.com
     * @date 2019/12/28
     */
    public static class ExtCode {

        /**
         * DEMO 类父编码
         */
        public static final String DEMO = "demo";

        /**
         * 微信类父编码
         */
        public static final String WEIXIN = "weixin";

        /**
         * 支付宝类父编码
         */
        public static final String ALIPAY = "alipay";

        /**
         * boh 父编码
         */
        public static final String boh = "boh";

    }

}
