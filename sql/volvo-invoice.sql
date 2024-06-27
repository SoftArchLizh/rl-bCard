use volvo_invoice;
-- 创建表tt_invoice_record
CREATE TABLE tt_invoice_record (
                                   order_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单编号',
                                   amount DECIMAL(10, 2) NOT NULL COMMENT '订单金额',
                                   invoice_id INT COMMENT '发票编号',
                                   invoice_date DATE COMMENT '开发票的日期',
                                   frame_number VARCHAR(20) NOT NULL COMMENT '车架号'
);

-- 创建表v_jdcfphz
CREATE TABLE v_jdcfphz (
                           invoice_code INT PRIMARY KEY AUTO_INCREMENT COMMENT '发票编码',
                           invoice_amount DECIMAL(10, 2) NOT NULL COMMENT '发票金额',
                           frame_number VARCHAR(20) NOT NULL COMMENT '车架号',
                           tax_rate DECIMAL(5, 2) COMMENT '进项税率',
                           tax_inclusive_price DECIMAL(10, 2) COMMENT '含税单价',
                           unit_price_amount DECIMAL(10, 2) COMMENT '单价金额',
                           quantity INT COMMENT '数量',
                           total_unit_price DECIMAL(10, 2) COMMENT '合计单价',
                           billing_type VARCHAR(50) COMMENT '开票类型'
);