-- 创建表tt_invoice_record的SQL语句
CREATE TABLE tt_invoice_record (
                                   id INT AUTO_INCREMENT COMMENT '主键ID',
                                   order_no VARCHAR(50) NOT NULL COMMENT '订单编号',
                                   order_amount DECIMAL(10, 2) NOT NULL COMMENT '订单金额',
                                   invoice_number VARCHAR(50) COMMENT '发票编号',
                                   invoice_date DATE COMMENT '开发票的日期',
                                   vin VARCHAR(17) NOT NULL COMMENT '车架号',
                                   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   PRIMARY KEY (id)
) COMMENT='订单记录表';

-- 创建表v_jdcfphz的SQL语句
CREATE TABLE v_jdcfphz (
                           id INT AUTO_INCREMENT COMMENT '主键ID',
                           invoice_code VARCHAR(50) NOT NULL COMMENT '发票编码',
                           invoice_amount DECIMAL(10, 2) NOT NULL COMMENT '发票金额',
                           vin VARCHAR(17) NOT NULL COMMENT '车架号',
                           tax_rate DECIMAL(5, 2) NOT NULL COMMENT '进项税率',
                           unit_price DECIMAL(10, 2) NOT NULL COMMENT '含税单价',
                           unit_amount DECIMAL(10, 2) NOT NULL COMMENT '单价金额',
                           quantity INT NOT NULL COMMENT '数量',
                           total_price DECIMAL(10, 2) NOT NULL COMMENT '合计单价',
                           invoice_type VARCHAR(20) NOT NULL COMMENT '开票类型',
                           create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           PRIMARY KEY (id)
) COMMENT='发票表';