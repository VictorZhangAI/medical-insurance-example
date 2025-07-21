DROP TABLE t_medicine;

CREATE TABLE t_medicine (
    med_id VARCHAR(50) PRIMARY KEY COMMENT '药品编码',
    med_name VARCHAR(100) NOT NULL COMMENT '药品名称',
    med_exp_type VARCHAR(50) COMMENT '收费类别',
    med_exp_level VARCHAR(50) COMMENT '收费项目等级',
    med_measurement VARCHAR(50) COMMENT '药品剂量单位',
    med_max_price DECIMAL(10,2) COMMENT '最高限价',
    med_approvalmark BOOLEAN COMMENT '是否需要审批标志',
    med_hos_level VARCHAR(50) COMMENT '医院等级',
    med_size VARCHAR(100) COMMENT '规格',
    med_tradename VARCHAR(100) COMMENT '药品商品名',
    med_starttime DATE COMMENT '开始日期',
    med_endtime DATE COMMENT '终止日期',
    med_valid BOOLEAN COMMENT '有效标识',
    med_specialmark BOOLEAN COMMENT '特检特制标志'
) COMMENT='药品信息维护表';


