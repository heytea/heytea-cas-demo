package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author weizibin
 * @since 2020/10/26 下午5:22
 */
@Data
@Accessors(chain = true)
public class SfShopAccount {
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

}
