package com.heytea.demo.rabbitmq.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author weizibin
 * @since 2020/10/27 上午11:31 
 */
@Data
@Accessors(chain = true)
public class EntityChangeDTO<T> {
	private T previous;
	private T current;
}
