package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SfDepartment {
	/**
	 * 字段描述：外部代码
	 * SF对应实体：FOCompany,cust_OG,FOBusinessUnit,FODivision,FODepartment,cust_group1,cust_group2,cust_group3,cust_group4
	 * 字段：externalCode
	 */
	private String externalCode;
	/**
	 * 字段描述：名称
	 * SF对应实体：cust_OG,cust_group1,cust_group2,cust_group3,cust_group4 字段：externalName
	 * SF对应实体：FOCompany,FODepartment,FOBusinessUnit,FODivision 字段：name_zh_CN
	 */
	private String nameZhCn;
	/**
	 * 字段描述：状态
	 * SF对应实体：cust_OG,cust_group1,cust_group2,cust_group3,cust_group4 字段：mdfSystemStatus
	 * SF对应实体：FOCompany,FOBusinessUnit,FODivision,FODepartment 字段：status
	 * (A:活动  I:非活动)
	 */
	private String status;
	/**
	 * 字段描述：负责人
	 * SF对应实体：cust_OG,FOCompany,cust_group1,cust_group2,cust_group3,cust_group4 字段：cust_HeadofUnit
	 * SF对应实体：FOBusinessUnit,FODivision,FODepartment 字段：headOfUnit
	 */
	private String headOfUnit;

	/**
	 * 字段描述：上级部门
	 * SF对应实体：cust_OG 字段：
	 * SF对应实体：FOCompany 字段：cust_toOG
	 * SF对应实体：FOBusinessUnit 字段：cust_toLegalEntity
	 * SF对应实体：FODivision 字段：cust_toBU
	 * SF对应实体：FODepartment 字段：cust_toDivsion
	 * SF对应实体：cust_group1 字段：cust_toDepartment
	 * SF对应实体：cust_group2 字段：cust_togroup1
	 * SF对应实体：cust_group3 字段：cust_togroup2
	 * SF对应实体：cust_group4 字段：cust_togroup3
	 */
	private String parent;

	/**
	 * 区域员工关系
	 * SF对应实体：FOCompany 字段：cust_StaffRelations
	 * SF对应实体：FOBusinessUnit 字段：cust_StaffRelations
	 * SF对应实体：FODivision 字段：cust_StaffRelations
	 * SF对应实体：FODepartment 字段：cust_StaffRelations
	 * SF对应实体：cust_group1 字段：cust_StaffRelations
	 * SF对应实体：cust_group2 字段：cust_StaffRelations
	 * SF对应实体：cust_group3 字段：cust_StaffRelations
	 * SF对应实体：cust_group4 字段：cust_StaffRelations
	 */
	private String custStaffRelations;

	/**
	 * 是否门店
	 * SF对应实体：FOCompany 字段：cust_ifStore
	 * SF对应实体：FOBusinessUnit 字段：cust_ifStore
	 * SF对应实体：FODivision 字段：cust_ifStore
	 * SF对应实体：FODepartment 字段：cust_ifStore
	 * SF对应实体：cust_group1 字段：cust_ifStore
	 * SF对应实体：cust_group2 字段：cust_ifStore
	 * SF对应实体：cust_group3 字段：cust_ifStore
	 * SF对应实体：cust_group4 字段：cust_ifStore
	 */
	private String custIfStore;

	/**
	 * HRBP
	 *  SF对应实体：FOCompany 字段：cust_HRBP
	 * 	 * SF对应实体：FOBusinessUnit 字段：cust_HRBP
	 * 	 * SF对应实体：FODivision 字段：cust_HRBP
	 * 	 * SF对应实体：FODepartment 字段：cust_HRBP
	 * 	 * SF对应实体：cust_group1 字段：cust_HRBP
	 * 	 * SF对应实体：cust_group2 字段：cust_HRBP
	 * 	 * SF对应实体：cust_group3 字段：cust_HRBP
	 * 	 * SF对应实体：cust_group4 字段：cust_HRBP
	 */
	private String custHrbp;
}
