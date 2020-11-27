package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SfPosition {
	/**
	 * 字段描述：中心
	 * SF对应实体：Position 字段：businessUnit
	 */
	private String bussinessUnit;
	/**
	 * 字段描述：更改原因
	 * SF对应实体：Position 字段：changeReason
	 */
	private String changeReason;
	/**
	 * 字段描述：岗位代码
	 * SF对应实体：Position 字段：code
	 */
	private String code;
	/**
	 * 字段描述：板块
	 * SF对应实体：Position 字段：company
	 */
	private String company;
	/**
	 * 字段描述：区域&组别
	 * SF对应实体：Position 字段：cust_group1
	 */
	private String custGroup1;
	/**
	 * 字段描述：小组
	 * SF对应实体：Position 字段：cust_group2
	 */
	private String custGroup2;
	/**
	 * 字段描述：七级组织
	 * SF对应实体：Position 字段：cust_group3
	 */
	private String custGroup3;
	/**
	 * 字段描述：八级组织
	 * SF对应实体：Position 字段：cust_group4
	 */
	private String custGroup4;
	/**
	 * 字段描述：九级组织
	 * SF对应实体：Position 字段：cust_group5
	 */
	private String custGroup5;
	/**
	 * 字段描述：十级组织
	 * SF对应实体：Position 字段：cust_group6
	 */
	private String custGroup6;
	/**
	 * 字段描述：职级
	 * SF对应实体：Position 字段：cust_jobtitle
	 */
	private String custJobtitle;
	/**
	 * 字段描述：职务等级
	 * SF对应实体：Position 字段：cust_positionlevel
	 */
	private String custPositionlevel;
	/**
	 * 字段描述：职位类型
	 * SF对应实体：Position 字段：cust_positiontype
	 */
	private String custPositiontype;
	/**
	 * 字段描述：组别
	 * SF对应实体：Position 字段：department
	 */
	private String department;
	/**
	 * 字段描述：部门
	 * SF对应实体：Position 字段：division
	 */
	private String division;
	/**
	 * 字段描述：状态
	 * SF对应实体：Position 字段：effectiveStatus
	 */
	private String effectiveStatus;
	/**
	 * 字段描述：岗位名称
	 * SF对应实体：Position 字段：externalName_defaultValue
	 */
	private String externalNameDefaultValue;
	/**
	 * 字段描述：岗位名称
	 * SF对应实体：Position 字段：externalName_zh_CN
	 */
	private String externalNameZhCn;
	/**
	 * 字段描述：基准岗位
	 * SF对应实体：Position 字段：jobCode
	 */
	private String jobCode;
	/**
	 * 字段描述：职务等级
	 * SF对应实体：Position 字段：jobLevel
	 */
	private String jobLevel;

}
