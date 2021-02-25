package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author weizibin
 * @since 2020/10/26 下午5:22
 */
@Data
@Accessors(chain = true)
public class SfEmployeeJob {
	/**
	 * 工号
	 */
	private String userId;

	/**
	 * 职位编号
	 */
	private String position;

	/**
	 * 板块
	 */
	private String company;

	/**
	 * 中心
	 */
	private String businessUnit;

	/**
	 * 部门
	 */
	private String division;

	/**
	 * 组别
	 */
	private String department;

	/**
	 * 区域/组别
	 */
	private String customString7;

	/**
	 * 门店
	 */
	private String customString8;

	/**
	 * 九级部门
	 */
	private String customString2;

	/**
	 * 十级部门
	 */
	private String customString12;

	/**
	 * sf部门id
	 */
	private String customString4;

	/**
	 * 门店
	 */
	private String customString14;

	/**
	 * 事件原因
	 */
	private String eventReason;

	/**
	 * 城市代码
	 */
	private String customString3;

	/**
	 * 员工类型：5831-实习生
	 */
	private String employeeType;

	/**
	 * 最后修改时间
	 */
	private String lastModifiedOn;

	/**
	 * 工作类型：5919-门店；5920-职能
	 */
	private String customString21;

	/**
	 * 职务等级
	 */
	private String customString22;

	/**
	 * 状态
	 */
	private String emplStatus;

	/**
	 * 职位名称
	 */
	private String positionName;

	/**
	 * 员工姓名
	 */
	private String personName;

	/**
	 * 员工英文姓名
	 */
	private String firstName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 公司邮箱
	 */
	private String companyEmail;
	/**
	 * 企业邮箱
	 */
	private String personalEmail;
	/**
	 * 证件类型
	 */
	private String cardType;
	/**
	 * 直接上级
	 */
	private String managerId;
	/**
	 * 字段描述：职级编码
	 * SF对应实体：PicklistOption 字段：externalCode
	 */
	private String jobTitleCode;
	/**
	 * 字段描述：职级名称
	 * SF对应实体：PicklistOption 字段：localeLabel
	 */
	private String jobTitleName;
	/**
	 * 字段描述：入职日期
	 * SF对应实体：EmpEmployment 字段：startDate
	 */
	private String hireDate;
	
	/**
     	 * 员工类型名称
	 * SF对应实体:  PicklistOption 字段:localeLabel
    	 */
    	private String employeeTypeName;
	
	/**
    	 * 合同主体编码
	 * SF对应实体：PicklistOption 字段：externalCode
     	 */
    	private String mainContractCode;

    	/**
    	 * 合同主体名称
	 * SF对应实体：PicklistOption 字段：localeLabel
     	*/
    	private String mainContractName;

}
