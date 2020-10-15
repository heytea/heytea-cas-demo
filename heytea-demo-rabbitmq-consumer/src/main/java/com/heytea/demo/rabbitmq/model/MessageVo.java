package com.heytea.demo.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // josn 需要默认的构造函数，否则会报错。
@AllArgsConstructor
public class MessageVo {

  private Integer status;

  private String msg;

}
