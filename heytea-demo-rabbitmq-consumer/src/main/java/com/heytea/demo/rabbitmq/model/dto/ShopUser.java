package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author weizibin
 * @since 2020/10/26 下午5:22
 */
@Data
@Accessors(chain = true)
public class ShopUser {
	/**
	 * 唯一标示id
	 */
	private String id;
	/**
	 * 编号
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 板块
	 */
	private String departmentCode;

	/**
	 * 职位
	 */
	private String position;

	/**
	 * 状态：0 - 停用 1 - 启用
	 */
	private String status;

	/**
	 * 城市代码
	 */
	private String customString3;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 上级
	 */
	private String managerId;

	/**
	 * 语言
	 * 日本：ja-JP
	 * 简体中文：zh-CN
	 * 繁体中文：zh-HK
	 * 英语：en-US
	 */
	private String language;

	/**
	 * 语言（oa系统专用）
	 */
	private String customOaLanguage;

	/**
	 * 安全等级
	 */
	private String securityLevel;

}
