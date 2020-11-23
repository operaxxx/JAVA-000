SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `jeektime`.`t_goods`  (
  `id` int NOT NULL COMMENT '商品id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `brand` varchar(255) NOT NULL COMMENT '品牌',
  `origin_place` varchar(255) NULL COMMENT '产地',
  `price` bigint(255) NOT NULL COMMENT '价格',
  `size` varchar(1) NOT NULL COMMENT '尺寸',
  `color` varchar(255) NULL COMMENT '颜色',
  `create_time` timestamp NOT NULL,
  `update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `jeektime`.`t_order`  (
  `id` int NOT NULL COMMENT '主键',
  `order_no` int NOT NULL COMMENT '订单号',
  `goods_id` int NOT NULL COMMENT '商品id',
  `user_id` int NOT NULL COMMENT '用户id',
  `amount` bigint NOT NULL COMMENT '总额',
  `freight` bigint NOT NULL COMMENT '运费',
  `money` bigint NOT NULL COMMENT '商品价格',
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `jeektime`.`t_user`  (
  `id` int NOT NULL,
  `name` varchar(40) NOT NULL,
  `address` varchar(255) NULL,
  `phone` varchar(255) NULL,
  `create_time` datetime NULL,
  `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

SET FOREIGN_KEY_CHECKS=1;