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
	private String changeReason;
	private String code;
	private String company;
	private String custGroup1;
	private String custGroup2;
	private String custGroup3;
	private String custGroup4;
	private String custGroup5;
	private String custGroup6;
	private String custJobtitle;
	private String custPositionlevel;
	private String custPositiontype;
	private String department;
	private String division;
	private String effectiveStatus;
	private String externalNameDefaultValue;
	private String externalNameZhCn;
	private String jobCode;
	private String jobLevel;

}
