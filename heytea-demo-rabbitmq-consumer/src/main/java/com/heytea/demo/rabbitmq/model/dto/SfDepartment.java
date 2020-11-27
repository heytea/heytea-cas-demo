package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SfDepartment {
	private String externalCode;
	private String nameZhCn;
	private String status;
	private String headOfUnit;
	private String parent;
}
